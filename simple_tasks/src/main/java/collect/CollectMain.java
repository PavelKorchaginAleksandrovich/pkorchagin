package collect;

public class CollectMain {
    public static void main(String[] args) {
        String[] strings = {"Петя", "Вася", "Вася", "Саша", "Петя", "Коля", "Махмуд"};
        FirstTask firstTask = new FirstTask();
        firstTask.getUniqueWords(strings);
        firstTask.calculateMatches(strings);

        PhoneCatalog catalog = new PhoneCatalog();
        catalog.add("Petrov", 893233212121L);
        catalog.add("Sidorov", 893233564121L);
        catalog.add("Lomov", 893278912121L);
        catalog.add("Nemov", 893412212121L);
        catalog.add("Petrov", 893233635121L);
        catalog.add("Lomov", 893237892121L);
        catalog.add("Kuznecov", 893233212121L);
        catalog.add("Petrov", 898523212121L);
        catalog.get("Petrov");
        catalog.get("Sidorov");



    }
}
