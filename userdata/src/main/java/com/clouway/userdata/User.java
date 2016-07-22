package com.clouway.userdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
    private String firstName;
    private String lastName;
    private int age;

    public User() {
    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public String firstName() {
        return firstName;
    }


    public String lastName() {
        return lastName;
    }


    public int age() {
        return age;
    }
}