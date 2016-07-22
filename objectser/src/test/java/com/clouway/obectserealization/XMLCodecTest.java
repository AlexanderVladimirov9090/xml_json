package com.clouway.obectserealization;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by clouway on 21.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class XMLCodecTest {

    @Test
    public void happyPath() {
        User user = new User("Ivan", 33);
        XMLCodec xmlCodec = new XMLCodec();

        assertThat(xmlCodec.toMessage(user), is(equalTo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "\n<user>\n    <name>Ivan</name>\n    <age>33</age>\n</user>\n\n")));
    }

    @Test
    public void many() {
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<userRepository>\n    <users>\n        <name>Ivan</name>\n        <age>33</age>\n    </users>\n    <users>\n        <name>Ivan</name>\n        <age>33</age>\n    </users>\n    <users>\n        <name>Ivan</name>\n        <age>33</age>\n    </users>\n</userRepository>\n\n";
        List<User> users = Lists.newArrayList(new User("Ivan", 33), new User("Ivan", 33), new User("Ivan", 33));
        UserRepository userRepository = new UserRepository(users);
        XMLCodec xmlCodec = new XMLCodec();

        String actual = xmlCodec.toMessage(userRepository);
        assertThat(actual, is(equalTo(expected)));
    }
}