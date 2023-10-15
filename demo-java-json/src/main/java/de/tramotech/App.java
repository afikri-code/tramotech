package de.tramotech;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    private static void objectToJson() throws JsonProcessingException {
        Person person = new Person();
        person.setName("John");
        person.setAge(30);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }

    private static void jsonToObject() throws JsonProcessingException {
        String json = "{\"name\":\"John\",\"age\":30}";
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(String.format("name: %s, age: %d", person.getName(),person.getAge()));
    }
    public static void main( String[] args ) throws JsonProcessingException {
        objectToJson();
        jsonToObject();
    }
}
