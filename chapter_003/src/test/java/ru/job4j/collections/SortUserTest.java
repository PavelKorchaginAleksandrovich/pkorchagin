package ru.job4j.collections;

import org.junit.Test;

import java.util.*;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenConvertToTreeSet() {
        List<User> users = new ArrayList<>();
        User user1 = new User(123, "Petr", 43);
        User user2 = new User(124, "Pit", 21);
        User user3 = new User(123, "Pit", 33);
        User user4 = new User(123, "Li", 13);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Set<User> result = new SortUser().sort(users);
        Iterator<User> it = result.iterator();
        assertThat(it.next().getAge(), is(13));
        assertThat(it.next().getAge(), is(21));
        assertThat(it.next().getAge(), is(33));
        assertThat(it.next().getAge(), is(43));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenSortByStringLenght() {
        List<User> users = new ArrayList<>();
        User user1 = new User(123, "Petr", "Moscow");
        User user2 = new User(123, "Pit", "Moscow");
        User user3 = new User(123, "Steven", "Moscow");
        User user4 = new User(123, "Li", "Moscow");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        List result = new SortUser().sortNameLength(users);
        List<User> expected = new ArrayList();
        expected.add(user4);
        expected.add(user2);
        expected.add(user1);
        expected.add(user3);
        assertThat(result, is(expected));
    }

//    @Test
//    public void whenSort() {
//
//    }

}
