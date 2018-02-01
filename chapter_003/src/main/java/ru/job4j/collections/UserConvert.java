package ru.job4j.collections;
import java.util.*;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User temp = iterator.next();
            result.put(temp.getId(), temp);
        }
        return  result;
    }
}
