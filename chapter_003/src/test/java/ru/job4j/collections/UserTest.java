package ru.job4j.collections;
import org.junit.Test;

import java.util.*;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class UserTest {
    @Test
    public void whenFirstMoreSecond() {
        int result = new User(123, "Ivan", 19).compareTo(new User(43, "Boris", 45));
        assertThat(result > 0, is(true));
    }
}
