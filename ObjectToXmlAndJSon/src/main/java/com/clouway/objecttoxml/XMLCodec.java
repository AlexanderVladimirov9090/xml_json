package com.clouway.objecttoxml;

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
public class XMLCodec {

  /**
   * Creates xml of object
   *
   * @param users wrapper for users.
   * @param path  for file to be written on.
   * @return
   * @throws JAXBException
   */
  public boolean createXML(Users users, String path) throws JAXBException {

    JAXBContext jaxbContext = JAXBContext.newInstance(com.clouway.objecttoxml.Users.class, com.clouway.objecttoxml.User.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    jaxbMarshaller.marshal(users, new File(path));

    return true;
  }

  public Users objectFromXML(String path) throws JAXBException {

    JAXBContext jaxbContext = JAXBContext.newInstance(com.clouway.objecttoxml.Users.class, com.clouway.objecttoxml.User.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    Users users = (Users) unmarshaller.unmarshal(new File(path));

    return users;
  }
}
