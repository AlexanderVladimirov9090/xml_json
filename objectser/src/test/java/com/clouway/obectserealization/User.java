package com.clouway.obectserealization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by clouway on 25.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class User {
  @XmlElement
  public String name;
  @XmlElement
  public int age;

  public User() {
  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
