package com.clouway.obectserealization;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by clouway on 25.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class JSONCodecTest {

    @Test
    public void happyPath(){
        User user = new User("Gosho", 50);
        JSONCodec jsonCodec = new JSONCodec();

        assertThat(jsonCodec.toMessage(user), is(equalTo("{\"name\":\"Gosho\",\"age\":50}")));
    }

    @Test
    public void many(){
        List<User> users = Lists.newArrayList(new User("Gosho", 50), new User("Pesho", 37), new User("Yordan", 56));
        JSONCodec jsonCodec = new JSONCodec();

        String actual = jsonCodec.toMessage(users);

        String expected = "[{\"name\":\"Gosho\",\"age\":50},{\"name\":\"Pesho\",\"age\":37},{\"name\":\"Yordan\",\"age\":56}]";

        assertThat(actual, is(equalTo(expected)));
    }
}