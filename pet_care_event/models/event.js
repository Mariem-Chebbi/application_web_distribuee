const mongo=require("mongoose")
const Schema=mongo.Schema
const Event=new Schema({
  nom:String,
  lieu:String,
  date:Date,
  capacite:Number
})
module.exports=mongo.model("event",Event)