const express = require("express");
const mongoose = require("mongoose");

const app = express();
const port = 3000;

// Body parsing middleware to handle JSON data
app.use(express.json());

// Connect to MongoDB
mongoose.connect("mongodb://localhost:27017/mydatabase", {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

const db = mongoose.connection;

db.on("error", console.error.bind(console, "MongoDB connection error:"));
db.once("open", () => {
  console.log("Connected to MongoDB");
});

// Define a schema for a sample entity (e.g., a "Person")
const personSchema = new mongoose.Schema({
  name: String,
  age: Number,
});

const Person = mongoose.model("Person", personSchema);

// Create a new person
app.post("/people", async (req, res) => {
  const { name, age } = req.body;
  const person = new Person({ name, age });

  try {
    await person.save();
    res.status(201).json(person);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Get all people
app.get("/people", async (req, res) => {
  const people = await Person.find();
  res.json(people);
});

// Get a person by ID
app.get("/people/:id", async (req, res) => {
  const id = req.params.id;

  try {
    const person = await Person.findById(id);
    if (!person) {
      res.status(404).json({ error: "Person not found" });
    } else {
      res.json(person);
    }
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Update a person by ID
app.put("/people/:id", async (req, res) => {
  const id = req.params.id;
  const { name, age } = req.body;

  try {
    const updatedPerson = await Person.findByIdAndUpdate(id, { name, age }, { new: true });
    if (!updatedPerson) {
      res.status(404).json({ error: "Person not found" });
    } else {
      res.json(updatedPerson);
    }
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Delete a person by ID
app.delete("/people/:id", async (req, res) => {
  const id = req.params.id;

  try {
    const deletedPerson = await Person.findByIdAndRemove(id);
    if (!deletedPerson) {
      res.status(404).json({ error: "Person not found" });
    } else {
      res.json(deletedPerson);
    }
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

app.listen(port, () => {
  console.log(`Express app listening on port ${port}`);
});

