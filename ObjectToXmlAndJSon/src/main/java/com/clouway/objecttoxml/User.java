package com.clouway.objecttoxml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by clouway on 21.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class User{
  private String firstName;
  private String lastName;
  private int age;

  public User() {

  }

  public User(String firstName, String lastName,int age) {
    this.firstName = firstName;
    this.age = age;
    this.lastName = lastName;
  }

  @XmlElement
  public String getFirstName() {
    return firstName;
  }

  @XmlElement
  public String getLastName() {
    return lastName;
  }

  @XmlElement
  public int getAge() {
    return age;
  }
}
