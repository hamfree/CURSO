/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import paquetePojos.Person;
import java.io.File;
import javax.xml.bind.Marshaller;

public class EjemploJAXB {

    public static void main(String[] args) {
        // unmarshalleando
        try {
            JAXBContext jaxbCtx = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            File f = new File("./src/xsdYxmlOrigen/persona.xml");
            Person p = (Person) unmarshaller.unmarshal(f); //NOI18N
            System.out.println(p.getName());
        } catch (JAXBException ex) {
            System.out.println("Horror "+ex);
        }
        // Marshallear
        try {            
            JAXBContext jaxbCtx = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            Person persona = new Person();
            persona.setName("paco");
            
            marshaller.marshal(persona, System.out);
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            System.out.println("Horror "+ex);
        }
    }
    
}
