const express = require("express");
const http = require("http");
const config = require("./config/dbconnection.json");
const mongo = require("mongoose");
const bodyparser = require("body-parser");
const eventRouter = require("./routes/event")


mongo
  .connect(config.url, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log("database connected"))
  .catch(() => console.log("database not connected"));


const app = express();
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({ extended: true }));
app.use("/event",eventRouter);


const server = http.createServer(app);

server.listen(3000, console.log("server run"));

module.exports = app;