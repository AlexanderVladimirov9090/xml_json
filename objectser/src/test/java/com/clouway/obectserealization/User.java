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
    String name;
    @XmlElement
    int age;

    public User() {
    }

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;

    }
}