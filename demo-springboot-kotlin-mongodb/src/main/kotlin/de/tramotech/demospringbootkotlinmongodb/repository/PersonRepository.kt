package de.tramotech.demospringbootkotlinmongodb.repository

import de.tramotech.demospringbootkotlinmongodb.model.Person
import org.springframework.data.mongodb.repository.MongoRepository

interface PersonRepository : MongoRepository<Person, String>