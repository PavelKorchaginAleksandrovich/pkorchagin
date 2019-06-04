package collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PhoneCatalog {

   private HashMap<String, ArrayList<Long>> catalog;

    public PhoneCatalog() {
        this.catalog = new HashMap<>();
    }

    public void add(String surname, Long number) {
       if (catalog.containsKey(surname)) {
           catalog.get(surname).add(number);
       } else {
         ArrayList<Long> arrayList = new ArrayList<>();
         arrayList.add(number);
         catalog.put(surname, arrayList);
       }
   }
   public void get(String surname) {
       System.out.println(catalog.get(surname));
   }

}
