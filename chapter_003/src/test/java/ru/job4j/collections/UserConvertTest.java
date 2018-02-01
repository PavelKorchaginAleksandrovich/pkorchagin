package ru.job4j.collections;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import java.util.*;

public class UserConvertTest {
    @Test
    public void whenProcess() {
        List<User> users = new ArrayList<>();
        User user = new User(123, "Petr", "Moscow");
        users.add(user);

        HashMap<Integer, User> result = new UserConvert().process(users);
        assertThat(result.get(123), is(user));
    }
}
