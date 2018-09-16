package ru.job4j.collectpro;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StoreTest {
    @Test
    public void storeTest() {
        UserStore users = new UserStore(20);
        Base one = new User("first");
        Base two = new User("second");
        Base three = new User("third");
        users.add(one);
        users.add(two);
        assertThat(users.findById("second"), is(two));
        assertThat(users.replace("second", three), is(true));
        assertThat(users.delete("second"), is(false));
        assertThat(users.findById("third"), is(three));
        assertThat(users.delete("third"), is(true));

    }

}
