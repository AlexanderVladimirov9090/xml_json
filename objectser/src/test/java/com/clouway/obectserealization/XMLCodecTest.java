package com.clouway.obectserealization;

import org.junit.Test;

import javax.xml.bind.JAXBException;

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
    String path = "/home/clouway/developmnet/xml_json/TestFolder/xml.xml";
    User user = new User("Hello",14);
    XMLCodec xmlCodec = new XMLCodec();


    assertThat(xmlCodec.exportObject(user, path), is(true));
    assertThat(xmlCodec.importObject(user, path), is(instanceOf(User.class)));
  }

  @Test(expected = JAXBException.class)
  public void emptyPath() throws JAXBException {
    String path = "";
    User user = new User("Hello",14);
    XMLCodec xmlCodec = new XMLCodec();


    assertThat(xmlCodec.exportObject(user, path), is(false));

  }

  @Test (expected = JAXBException.class)
  public void classNoAnnotation() throws JAXBException {
    String path = "/home/clouway/developmnet/xml_json/TestFolder/xml.xml";
    Object object = new Object();
    XMLCodec xmlCodec = new XMLCodec();
    xmlCodec.exportObject(object,path);
  }

  @Test
  public void many() throws JAXBException {
    User user = new User("Hello",14);
    User user1 = new User("Hello",14);
    User user2 = new User("Hello",14);
    XMLCodec xmlCodec = new XMLCodec();

    assertThat(xmlCodec.exportObject(user, "/home/clouway/developmnet/xml_json/object.xml"), is(true));
    assertThat(xmlCodec.importObject(user, "/home/clouway/developmnet/xml_json/object.xml"), is(instanceOf(User.class)));

    assertThat(xmlCodec.exportObject(user1, "/home/clouway/developmnet/xml_json/object2.xml"), is(true));
    assertThat(xmlCodec.importObject(user1, "/home/clouway/developmnet/xml_json/object2.xml"), is(instanceOf(User.class)));

    assertThat(xmlCodec.exportObject(user2, "/home/clouway/developmnet/xml_json/object3.xml"), is(true));
    assertThat(xmlCodec.importObject(user2, "/home/clouway/developmnet/xml_json/object3.xml"), is(instanceOf(User.class)));
  }

}