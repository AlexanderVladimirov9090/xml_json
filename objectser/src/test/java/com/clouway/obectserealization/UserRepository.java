package com.clouway.obectserealization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by clouway on 25.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class UserRepository {


    private List<User> users;

    public UserRepository() {
    }

    UserRepository(List<User> users) {
        this.users = users;
    }

    List<User> users() {
        return users;
    }
}