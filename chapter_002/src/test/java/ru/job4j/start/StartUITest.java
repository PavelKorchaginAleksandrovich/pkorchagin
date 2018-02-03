//package ru.job4j.start;
//import org.junit.Test;
//import ru.job4j.models.Item;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertArrayEquals;
//
//public class StartUITest {
//    private final PrintStream stdout = System.out;
//    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
//    private final String menu = "0. Add new Item\r\n"
//            + "1. Show all items\r\n"
//            + "2. Edit item\r\n"
//            + "3. Delete item\r\n"
//            + "4. Find item by Id\r\n"
//            + "5. Find items by name\r\n"
//            + "6. Exit";
//       public void loadOutput() {
//        System.setOut(new PrintStream(this.out));
//    }
//
//    public void backOutput() {
//        System.setOut(this.stdout);
//    }
//
//    @Test
//    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
//        Tracker tracker = new Tracker();
//        Input input = new StubInput(new String[]{"0", "new item", "desc", "6"});
//        new StartUI(input, tracker).init();
//        assertThat(tracker.getByIndex(0).getName(), is("new item"));
//    }
//    @Test
//    public void whenEditThenTrackerHasEditValue() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("name", "decs"));
//        Input input = new StubInput(new String[]{"2", item.getId(), "edit name", "desc", "6"});
//        new StartUI(input, tracker).init();
//        assertThat(tracker.findById(item.getId()).getName(), is("edit name"));
//    }
//
//    @Test
//    public void whenDeleteItemThenTrackerNotHasItem() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("name", "decs"));
//        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
//        new StartUI(input, tracker).init();
//        assertThat(tracker.findAll().length, is(0));
//    }
//
//    @Test
//    public void whenFindItemThenItemByID() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("test name", "decs"));
//        String expected = new StringBuilder().
//                append(this.menu).append(System.lineSeparator()).
//                append(item.getName()).append(System.lineSeparator()).
//                append(this.menu).append(System.lineSeparator()).toString();
//        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
//        StartUI start = new StartUI(input, tracker);
//        this.loadOutput();
//        start.init();
//        assertThat(new String(this.out.toByteArray()), is(expected));
//        this.backOutput();
//    }
//    @Test
//    public void whenFindItemNameThenItemByName() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("test name", "decs"));
//        String expected = new StringBuilder().append(this.menu).
//                append(System.lineSeparator()).
//                append("Найдено заявок 1").append(System.lineSeparator()).
//                append("Имя: ").append(item.getName()).append(" ID: ").append(item.getId()).
//                append(System.lineSeparator()).
//                append(this.menu).append(System.lineSeparator()).toString();
//        Input input = new StubInput(new String[]{"5", "test name", "6"});
//        StartUI start = new StartUI(input, tracker);
//        this.loadOutput();
//        start.init();
//        assertThat(new String(this.out.toByteArray()), is(expected));
//        this.backOutput();
//    }
//    @Test
//    public void whenShowAllThenAllItems() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("test name", "decs"));
//        String expected = new StringBuilder()
//                .append(this.menu).append(System.lineSeparator()).
//                append("Список всех заявок:").append(System.lineSeparator()).
//                append("Имя: ").append("test name").append(" ID: ").append(item.getId()).append(System.lineSeparator()).
//                append(this.menu).append(System.lineSeparator()).toString();
//        Input input = new StubInput(new String[]{"1", "6"});
//        StartUI start = new StartUI(input, tracker);
//        this.loadOutput();
//        start.init();
//        assertThat(new String(this.out.toByteArray()), is(expected));
//        this.backOutput();
//    }
//}
//
//
