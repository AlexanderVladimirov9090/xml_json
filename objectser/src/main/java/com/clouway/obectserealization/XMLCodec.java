package com.clouway.obectserealization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;

/**
 * Created by clouway on 21.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class XMLCodec implements MessageCodec {

    /**
     * Serialize of given object.
     *
     * @param object for serialization to xml format.
     * @return serialized object to xml format.
     */
    public <T> String toMessage(T object) {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jaxbContext = null;
            Class clazz = object.getClass();
            jaxbContext = JAXBContext.newInstance(clazz);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    /**
     * Deserializes message to given object .
     *
     * @param message for deserialization from xml format.
     * @param clazz   for casting in to object class.
     * @return deserialize object form xml format.
     */
    public <T> T fromMessage(String message, Type clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance((Class) clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(message));
        } catch (JAXBException ignore) {
            throw new CanNotReadMessageException("This message does not meet the requirement to be read.");
        }
    }
}