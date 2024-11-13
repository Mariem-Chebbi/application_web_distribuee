const express = require("express");
const http = require("http");
const mongo = require("mongoose");
const bodyparser = require("body-parser");
const axios = require("axios");
const eventRouter = require("./routes/event");

// Config Server URL et paramètres du service
const CONFIG_SERVER_URL = process.env.CONFIG_SERVER_URL || "http://localhost:8888";
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

  const server = http.createServer(app);
  const port = process.env.PORT || 3000;

  server.listen(port, () => console.log(`Serveur démarré sur le port ${port}`));

  // Exporte l'application pour les tests ou autres usages
  module.exports = app;
}

startApp();
