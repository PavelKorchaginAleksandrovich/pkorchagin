package ru.job4j.collections;
import java.util.*;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {

            result.put(user.getId(), user);
        }
        return  result;
    }

}
