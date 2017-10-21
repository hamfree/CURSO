package ejemploJaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import pojos.Person;

public class EjemploJAXB {

    /**
     * Genera el objeto Person de Java a partir del fichero XML "persona.xml". (UnMarshall) Después de haber generado el POJO con el
     * compilador xjc al que se le pasa el esquema "persona.xsd" (JAXB Bindings en Netbeans)
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Unmarshall:");
        unmarshall();
        System.out.println("\nMarshall:");
        marshall(true);
    }

    public static void unmarshall() {
        //Unmarshall (jaxbu + TAB) -> De fichero XML con los datos a objeto/objetos de Java.
        try {
            JAXBContext jaxbCtx = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            File f = new File("./src/xsdYxmlOrigen/persona.xml");
            Person p = (Person) unmarshaller.unmarshal(f); //NOI18N
            System.out.println(p.getName());
        } catch (javax.xml.bind.JAXBException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex); //NOI18N
        }
    }

    public static void marshall(boolean toScreen) {
        // Marshall /jaxbm + TAB) -> De objeto java a fichero XML...
        try {
            JAXBContext jaxbCtx = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Person persona = new Person();
            persona.setName("Juan Francisco");
            if (toScreen == true) {
                marshaller.marshal(persona, System.out);
            } else {
                File f = new File("./src/xsdYxmlOrigen/miPersona.xml");
                FileOutputStream os;
                os = new FileOutputStream(f);
                marshaller.marshal(persona, os);
                os.close();
            }

            System.out.println("\n\n");
        } catch (JAXBException ex) {
            System.out.println("Error:" + ex.getLocalizedMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("Error:" + ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getLocalizedMessage());
        }
    }
}
