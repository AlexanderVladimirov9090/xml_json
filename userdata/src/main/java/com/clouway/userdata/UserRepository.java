package com.clouway.userdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by clouway on 25.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
@XmlRootElement
@XmlSeeAlso(User.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRepository{

  private List<User> users;
  public UserRepository(){}
  public UserRepository(LinkedList<User> users){
    this.users=users;
  }

  public List<User> getUsers(){
    return users;
  }

  /**
   * Counts number of users.
   * @return
   */
  public int numberOfUsers(){
    return users.size();
  }

  /**
   * Calculate average age of users.
   * @return
   */
  public int averageAge(){
    int sumOfAges= 0;
    int numberOfUsers= users.size();
    for (User each:users) {
      sumOfAges += each.getAge();
    }

    return sumOfAges/numberOfUsers;
  }
}
