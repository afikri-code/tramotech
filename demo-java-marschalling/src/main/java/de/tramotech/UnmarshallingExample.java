package de.tramotech;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class UnmarshallingExample {
    public static void main(String[] args) throws JAXBException {
        // XML content as a string
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><person><name>Max</name><age>22</age></person>";

        // Create a JAXBContext for your object's class
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        // Create an Unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // Unmarshal the XML string into a Java object
        Person yourObject = (Person) unmarshaller.unmarshal(new StringReader(xmlString));

        System.out.println("Name: " + yourObject.getName());
        System.out.println("Age: " + yourObject.getAge());
    }
}

