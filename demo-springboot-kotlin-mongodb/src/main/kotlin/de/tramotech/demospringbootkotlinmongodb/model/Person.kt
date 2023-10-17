package de.tramotech.demospringbootkotlinmongodb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "people")
data class Person(
    @Id
    val id: String? = null,
    val name: String,
    val age: Int
)