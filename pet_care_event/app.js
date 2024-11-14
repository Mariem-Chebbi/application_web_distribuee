const express = require("express");
const http = require("http");
const mongo = require("mongoose");
const bodyparser = require("body-parser");
const axios = require("axios");
const eventRouter = require("./routes/event");
const Eureka = require("eureka-js-client").Eureka; // Importez le client Eureka

// Config Server URL et paramètres du service
const CONFIG_SERVER_URL = process.env.CONFIG_SERVER_URL || "http://config-server:8888";
const SERVICE_NAME = process.env.SERVICE_NAME || "express-microservice";
const SERVICE_PROFILE = process.env.SERVICE_PROFILE || "dev";

// Fonction pour charger la configuration depuis le Config Server
async function loadConfig() {
  try {
    const response = await axios.get(`${CONFIG_SERVER_URL}/${SERVICE_NAME}/${SERVICE_PROFILE}`);
    const configData = response.data.propertySources[0].source;
    return configData;
  } catch (error) {
    console.error("Erreur lors du chargement de la configuration:", error);
    process.exit(1); // Arrête le processus si la configuration ne peut pas être chargée
  }
}

// Démarrer l'application Express avec les configurations du Config Server
async function startApp() {
  const config = await loadConfig();
  const app = express();

  // Connexion à MongoDB avec l'URL récupérée depuis le Config Server
  mongo
    .connect(config["mongodb.url"], {
      useNewUrlParser: true,
      useUnifiedTopology: true,
    })
    .then(() => console.log("Base de données connectée"))
    .catch((err) => console.log("Erreur de connexion à la base de données:", err));

  app.use(bodyparser.json());
  app.use(bodyparser.urlencoded({ extended: true }));
  app.use("/event", eventRouter);

  const port = process.env.PORT || 3000;
  const server = http.createServer(app);

  // Créez une instance Eureka Client
  const eurekaClient = new Eureka({
    instance: {
      app: SERVICE_NAME,
      instanceId: `${SERVICE_NAME}:${port}`,
      hostName: "localhost",
      ipAddr: "127.0.0.1",
      statusPageUrl: `http://localhost:${port}`,
      port: {
        $: port,
        "@enabled": "true"
      },
      vipAddress: SERVICE_NAME,
      dataCenterInfo: {
        "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
        name: "MyOwn"
      }
    },
    eureka: {
      host: "eureka",
      port: 8761,
      servicePath: "/eureka/apps/"
    }
  });

  // Démarrez le client Eureka pour l'enregistrement
  eurekaClient.start((error) => {
    if (error) {
      console.error("Erreur lors de l'inscription au serveur Eureka:", error);
    } else {
      console.log("Microservice enregistré avec succès au serveur Eureka");
    }
  });

  // Démarrez le serveur Express
  server.listen(port, () => {
    console.log(`Serveur démarré sur le port ${port}`);
  });

  // Exporte l'application pour les tests ou autres usages
  module.exports = app;

  // Arrêtez l'enregistrement Eureka lorsque l'application se ferme
  process.on("SIGINT", () => {
    eurekaClient.stop();
    process.exit();
  });
}

startApp();
