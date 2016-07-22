package com.clouway.objecttoxml;

import org.junit.Test;

import java.io.IOException;
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
public class JSONCodecTest {

  @Test
  public void happyPath() throws IOException {
    String path = "/home/clouway/developmnet/xml_json/Users.json";
    Users users = new Users(new LinkedList<User>());
    JSONCodec jsonCodec = new JSONCodec();

    users.addUser("1", "2", 3);

    assertThat(jsonCodec.createJSON(users, path), is(true));
    assertThat(jsonCodec.objectFromJSON("/home/clouway/developmnet/xml_json/Users.json"),is(instanceOf(Users.class)));
  }

  @Test
  public void pathNotGiven() throws IOException {
    String path = "";
    Users users = new Users(new LinkedList<User>());
    JSONCodec jsonCodec = new JSONCodec();

    users.addUser("1", "2", 3);

    assertThat(jsonCodec.createJSON(users, path), is(false));
  }

  @Test
  public void many() throws IOException {

    String path = "/home/clouway/developmnet/xml_json/Users.json";
    Users users = new Users(new LinkedList<User>());
    JSONCodec jsonCodec = new JSONCodec();
    addAll(users);


    assertThat(jsonCodec.createJSON(users, path), is(true));
    assertThat(jsonCodec.objectFromJSON("/home/clouway/developmnet/xml_json/Users.json"),is(instanceOf(Users.class)));
  }

  private void addAll(Users users) {
    users.addUser("1", "2", 3);
    users.addUser("11", "22", 4);
    users.addUser("111", "222", 5);
    users.addUser("1111", "2222", 6);
  }
}
