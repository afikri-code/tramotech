package de.tramotech.demospringbootkotlinmongodb.controller

import de.tramotech.demospringbootkotlinmongodb.model.Person
import de.tramotech.demospringbootkotlinmongodb.repository.PersonRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/people")
class PersonController(private val personRepository: PersonRepository) {

    @GetMapping
    fun getAllPeople(): List<Person> = personRepository.findAll()

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable id: String): Person =
        personRepository.findById(id)
            .orElseThrow { ChangeSetPersister.NotFoundException() }

    @PostMapping
    fun createPerson(@RequestBody person: Person): Person = personRepository.save(person)

    @PutMapping("/{id}")
    fun updatePerson(@PathVariable id: String, @RequestBody person: Person): Person {
        if (!personRepository.existsById(id)) {
            throw ChangeSetPersister.NotFoundException()
        }
        return personRepository.save(person.copy(id = id))
    }

    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: String) {
        if (!personRepository.existsById(id)) {
            throw ChangeSetPersister.NotFoundException()
        }
        personRepository.deleteById(id)
    }
}