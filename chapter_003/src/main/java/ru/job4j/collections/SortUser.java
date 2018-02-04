package ru.job4j.collections;

import java.util.*;

public class SortUser {

    Set<User> sort(List<User> users) {
        Set<User> result = new TreeSet(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        result.addAll(users);
        return result;
    }

    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return Integer.compare(user1.getName().length(), user2.getName().length());
            }
        });
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                final int result = user1.getName().compareTo(user2.getName());
                return result != 0 ? result : Integer.compare(user1.getAge(), user2.getAge());
            }
        });
        return users;
    }
}
