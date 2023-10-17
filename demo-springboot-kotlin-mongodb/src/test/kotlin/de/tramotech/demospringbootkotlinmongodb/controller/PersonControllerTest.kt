package de.tramotech.demospringbootkotlinmongodb.controller

import org.junit.jupiter.api.Assertions.*

import com.fasterxml.jackson.databind.ObjectMapper
import de.tramotech.demospringbootkotlinmongodb.model.Person
import de.tramotech.demospringbootkotlinmongodb.repository.PersonRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var personRepository: PersonRepository

    private val objectMapper = ObjectMapper()

    private val personList = listOf(
        Person("1", "Alice", 25),
        Person("2", "Bob", 30)
    )

    @BeforeEach
    fun setUp() {
        // Mock the behavior of the repository
        given(personRepository.findAll()).willReturn(personList)
        given(personRepository.findById("1")).willReturn(Optional.of(personList[0]))
        given(personRepository.findById("3")).willReturn(Optional.empty())
        given(personRepository.save(Mockito.any(Person::class.java))).willAnswer { it.arguments[0] as Person }
    }

    @Test
    fun testGetAllPeople() {
        mockMvc.perform(MockMvcRequestBuilders.get("/people"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(personList))
            )
    }

    @Test
    fun testGetPersonById() {
        mockMvc.perform(MockMvcRequestBuilders.get("/people/1"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(personList[0]))
            )
    }

    @Test
    fun testGetPersonByIdNotFound() {
        mockMvc.perform(MockMvcRequestBuilders.get("/people/3"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }

    @Test
    fun testCreatePerson() {
        val newPerson = Person(name = "Charlie", age = 35)
        mockMvc.perform(
            MockMvcRequestBuilders.post("/people")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newPerson))
        )
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(newPerson))
            )
    }
}
