package com.clouway.userdata;

import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by clouway on 31.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class UserRepositoryTest {
    @Test
    public void addUser() {
        User user = new User("Goshko", "Goshev", 13);
        UserRepository userRepository = new UserRepository(new LinkedList<>());

        userRepository.users().add(user);

        assertThat(userRepository.users().get(0), is(user));
    }

    @Test
    public void numberOfUsers() {
        User user = new User("Goshko", "Goshev", 13);
        UserRepository userRepository = new UserRepository(new LinkedList<>());

        userRepository.users().add(user);

        assertThat(userRepository.numberOfUsers(), is(1));
    }

    @Test
    public void averageAge() {
        User user = new User("Goshko", "Goshev", 13);
        UserRepository userRepository = new UserRepository(new LinkedList<>());

        userRepository.users().add(user);
        userRepository.users().add(user);
        userRepository.users().add(user);
        userRepository.users().add(user);
        userRepository.users().add(user);

        assertThat(userRepository.averageAge(), is(13));
    }
}