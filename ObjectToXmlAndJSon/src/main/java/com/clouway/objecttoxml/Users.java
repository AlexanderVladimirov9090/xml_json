package com.clouway.objecttoxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by clouway on 21.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users<T> {
  @XmlElement(name = "user")
  public List<T> users;

  public Users() {

  }

  public Users(List<T> users) {
    this.users = users;
  }

  /**
   * Adds user to users list.
   *
   * @param firstName of user.
   * @param lastName  of user.
   * @param age       of user.
   */
  public void addUser(String firstName, String lastName, int age) {
    T user = (T) new User(firstName, lastName, age);
    users.add(user);

  }
}
