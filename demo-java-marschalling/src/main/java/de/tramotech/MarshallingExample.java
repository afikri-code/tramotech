package de.tramotech;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class MarshallingExample
{
    public static void main( String[] args ) throws JAXBException {
        // Create an instance of your Java object
        Person person = new Person();
        person.setAge(22);
        person.setName("Max");

        // Create a JAXBContext for your object's class
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        // Create a Marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();

        // Marshal the object into an XML string
        StringWriter writer = new StringWriter();
        marshaller.marshal(person, writer);

        String xmlString = writer.toString();
        System.out.println(xmlString);
    }
}
