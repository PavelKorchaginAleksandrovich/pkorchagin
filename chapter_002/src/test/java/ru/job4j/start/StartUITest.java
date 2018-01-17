package ru.job4j.start;
import org.junit.Test;
import ru.job4j.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String menu = "0. Add new Item\n"
            + "1. Show all items\n"
            + "2. Edit item\n"
            + "3. Delete item\n"
            + "4. Find item by Id\n"
            + "5. Find items by name\n"
            + "6. Exit Program\n";
    Tracker tracker = new Tracker();
    Item item1 = tracker.add(new Item("name1", "desc1"));
    Item item2 = tracker.add(new Item("name2", "desc2"));
    Item item3 = tracker.add(new Item("name3", "desc3"));
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "new item", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getByIndex(3).getName(), is("new item"));
    }
    @Test
    public void whenEditThenTrackerHasEditValue() {
        Input input = new StubInput(new String[]{"2", this.item2.getId(), "edit name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item2.getId()).getName(), is("edit name"));
    }

    @Test
    public void whenDeleteItemThenTrackerNotHasItem() {
        Item[] result = {this.item2, this.item3};
        Input input = new StubInput(new String[]{"3", this.item1.getId(), "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findAll(), is(result));
    }

    @Test
    public void whenFindItemThenItemByID() {
        String expected = new StringBuilder().
                append(this.menu).append(System.lineSeparator()).
                append(item2.getName()).append(System.lineSeparator()).
                append(this.menu).append(System.lineSeparator()).toString();
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        StartUI start = new StartUI(input, tracker);
        this.loadOutput();
        start.init();
        assertThat(new String(this.out.toByteArray()), is(expected));
        this.backOutput();
    }
    @Test
    public void whenFindItemNameThenItemByName() {
        String expected = new StringBuilder().append(this.menu).
                append(System.lineSeparator()).
                append("Найдено заявок 1").append(System.lineSeparator()).
                append("Имя: ").append(item3.getName()).append(" ID: ").append(item3.getId()).
                append(System.lineSeparator()).
                append(this.menu).append(System.lineSeparator()).toString();
        Input input = new StubInput(new String[]{"5", item3.getName(), "6"});
        StartUI start = new StartUI(input, tracker);
        this.loadOutput();
        start.init();
        assertThat(new String(this.out.toByteArray()), is(expected));
        this.backOutput();
    }
    @Test
    public void whenShowAllThenAllItems() {
        String expected = new StringBuilder()
                .append(this.menu).append(System.lineSeparator()).
                append("Список всех заявок:").append(System.lineSeparator()).
                append("Имя: ").append(item1.getName()).append(" ID: ").append(item1.getId()).append(System.lineSeparator()).
                append("Имя: ").append(item2.getName()).append(" ID: ").append(item2.getId()).append(System.lineSeparator()).
                append("Имя: ").append(item3.getName()).append(" ID: ").append(item3.getId()).append(System.lineSeparator()).
                append(this.menu).append(System.lineSeparator()).toString();
        Input input = new StubInput(new String[]{"1", "6"});
        StartUI start = new StartUI(input, tracker);
        this.loadOutput();
        start.init();
        assertThat(new String(this.out.toByteArray()), is(expected));
        this.backOutput();
    }
}


