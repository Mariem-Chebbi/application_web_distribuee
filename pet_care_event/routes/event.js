const express = require("express");
const router = express.Router();
const Event= require("../models/event"); 
const eventController= require("../controllers/eventController"); 
router.get("/", function (req, res) {
  res.send("hello express");
});

router.post("/add",eventController.addEvent);
router.get("/getall", eventController.getAllEvents);
router.get("/get/:id", eventController.getEventById);
router.get("/getname/:nom", eventController.getEventByName);
router.put("/edit/:id",eventController.editEvent);
router.delete("/delete/:id", eventController.deleteEvent); 

module.exports = router