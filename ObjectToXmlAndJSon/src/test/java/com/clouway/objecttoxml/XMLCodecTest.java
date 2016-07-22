package com.clouway.objecttoxml;

import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by clouway on 21.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class XMLCodecTest {

  @Test
  public void happyPath() throws JAXBException {
    String path = "/home/clouway/developmnet/xml_json/xml.xml";
    Users users = new Users(new LinkedList());
    XMLCodec xmlCodec = new XMLCodec();

    users.addUser("Go6o", "Go6ev", 1);
    assertThat(xmlCodec.createXML(users, path), is(true));
    assertThat(xmlCodec.objectFromXML(path),is(instanceOf(Users.class)));
  }

  @Test(expected = JAXBException.class)
  public void emptyPath() throws JAXBException {
    String path = "";
    Users users = new Users(new LinkedList());
    XMLCodec xmlCodec = new XMLCodec();

    users.addUser("o","1",2);
    assertThat(xmlCodec.createXML(users, path), is(false));

  }

  @Test
  public void many() throws JAXBException {
    String path = "/home/clouway/developmnet/xml_json/xml.xml";
    Users users = new Users(new LinkedList());
    XMLCodec xmlCodec = new XMLCodec();
    addAll(users);

    assertThat(xmlCodec.createXML(users, path), is(true));
    assertThat(xmlCodec.objectFromXML(path),is(instanceOf(Users.class)));
  }

  private void addAll(Users users){
    users.addUser("Go6o", "Go6ev", 1);
    users.addUser("Go6o", "Go6ev", 1);
    users.addUser("Go6o", "Go6ev", 1);
    users.addUser("Go6o", "Go6ev", 1);
  }
}