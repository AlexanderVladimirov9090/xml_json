package com.clouway.obectserealization;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by clouway on 17.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class XMLCodecDeserializationTest {

    @Test
    public void userName() {
        User user = new User("Pesho", 19);

        XMLCodec xmlCodec = new XMLCodec();
        User actual = xmlCodec.fromMessage(xmlCodec.toMessage(user), user.getClass());
        assertThat(actual.name, is(equalTo(user.name)));
    }

    @Test
    public void userAge() {
        String message = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<userRepository>\n    <users>\n        <name>Ivan</name>\n        <age>33</age>\n    </users>\n    <users>\n        <name>Ivan</name>\n        <age>33</age>\n    </users>\n    <users>\n        <name>Ivan</name>\n        <age>33</age>\n    </users>\n</userRepository>\n\n";
        List<User> users = Lists.newArrayList(new User("Ivan", 33), new User("Ivan", 33), new User("Ivan", 33));
        UserRepository expected = new UserRepository(users);
        XMLCodec xmlCodec = new XMLCodec();
        UserRepository actual = xmlCodec.fromMessage(message,expected.getClass());
        assertThat(actual.users(), is(equalTo(expected.users())));
    }
}