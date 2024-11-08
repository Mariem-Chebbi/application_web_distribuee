const Event = require('../models/event')

async function getAllEvents(req,res){
    try {
        const data = await Event.find();
        res.status(200).send(data);
    } catch (err) {
        res.status(400).send({error:err});
    }
}

async function getEventById(req,res){
    try {
        const data = await Event.findById(req.params.id);
        res.status(200).send(data);
    } catch (err) {
        res.status(400).send({error:err});
    }
}


async function addEvent(req,res){
    try {
        const event = new Event(req.body);
        await event.save();
        res.status(201).send(event);
    } catch (err) {
        res.status(400).send({error:err});
    }
}

async function getEventByName(req,res){
    try {
        const data = await Event.findOne({nom:req.params.nom});
        res.status(200).send(data);
    } catch (err) {
        res.status(404).send({error:err});
    }
}

async function editEvent(req,res){
    try {
        const data = await Event.findByIdAndUpdate(req.params.id,req.body,{new:true});
        res.status(202).send(data);
    } catch (err) {
        res.status(400).send({error:err});
    }
}

async function deleteEvent(req,res){
    try {
        await Event.findByIdAndDelete(req.params.id);
        res.status(200).send("deleted");
    } catch (err) {
        res.status(400).send({error:err});
    }
}

module.exports={
    getAllEvents,
    getEventById,
    addEvent,
    getEventByName,
    editEvent,
    deleteEvent
}

