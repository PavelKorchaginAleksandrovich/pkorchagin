package ru.job4j.bank;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import java.util.*;

public class BankMapTest {
    @Test
    public void whenAddUser() {
        User user1 = new User("Ivan", "HP12");
        BankMap map = new BankMap();
        map.addUser(user1);
        assertThat(map.getUserAccounts("HP12"), is(user1));
    }

}
