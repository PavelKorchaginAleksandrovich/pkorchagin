package collect;

import java.util.*;

public class FirstTask {
    public void getUniqueWords(String[] strings) {
         Set set = new HashSet();
         set.addAll(Arrays.asList(strings));
         Iterator itr = set.iterator();
         System.out.println(set);
    }

    public void calculateMatches(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: strings) {
            if (map.containsKey(s)) {
                int newValue = map.get(s) + 1;
               map.put(s, newValue);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map);
    }
}
