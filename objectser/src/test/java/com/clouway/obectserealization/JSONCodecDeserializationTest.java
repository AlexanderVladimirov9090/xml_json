package com.clouway.obectserealization;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.jmock.AbstractExpectations.equal;

/**
 * Created by clouway on 17.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class JSONCodecDeserializationTest {

    @Test
    public void userName() {
        User user = new User("Guy", 99);
        JSONCodec jsonCodec = new JSONCodec();

        User actual = jsonCodec.fromMessage(jsonCodec.toMessage(user), user.getClass());

        assertThat(actual.name, is(equalTo(user.name)));
    }
    @Test
    public void userAge(){
        User user = new User("Guy", 99);
        JSONCodec jsonCodec = new JSONCodec();

        User actual = jsonCodec.fromMessage(jsonCodec.toMessage(user), user.getClass());

        assertThat(actual.age, is(equalTo(user.age)));
    }

    @Test
    public void many(){
        Type listType = new TypeToken<ArrayList<User>>() {
        }.getType();
        String message = "[{\"name\":\"One\",\"age\":99},{\"name\":\"Two\",\"age\":99},{\"name\":\"Three\",\"age\":99}]";
        List<User> expected = Lists.newArrayList(new User("One", 99), new User("Two", 99), new User("Three", 99));
        JSONCodec jsonCodec = new JSONCodec();
        ArrayList<User> actual = jsonCodec.fromMessage(message, listType);
        assertThat(actual, is(expected));
    }
}