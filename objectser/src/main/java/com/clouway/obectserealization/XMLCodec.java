package com.clouway.obectserealization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by clouway on 21.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class XMLCodec<T> implements MessageCodec<T> {

  /**
   * Export object to xml file.
   * @param object any type of object will be exported to file.
   * @param path of file that object will be exported.
   * @return
   */
  public boolean exportObject(T object, String path){
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(object, new File(path));
    }
    catch (JAXBException e){
      e.printStackTrace();
    }
      return true;
  }

  /**
   * Import object form xml.
   * @param object any type of object will be imported to application.
   * @param path of file that will be exported.
   * @return
   */
  public T importObject(T object, String path) {
    JAXBContext jaxbContext;
    try {
      jaxbContext = JAXBContext.newInstance(object.getClass());
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      return (T) unmarshaller.unmarshal(new File(path));

    } catch (JAXBException e) {
      e.printStackTrace();
    }
    throw new RuntimeException();
  }
}
