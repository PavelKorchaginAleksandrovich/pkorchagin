package ru.job4j.start;

import org.junit.Test;
import ru.job4j.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;


public class TrackerTest {

    Item testItem1 = new Item("не печатает принтер", 3232, "Ремонт принтера");
    Item testItem2 = new Item("не включается компьютер", 2341, "Ремонт компьютера");
    Item testItem3 = new Item("создать учетную запись на почтовом сервере", 4567, "Новая почта");
    Item testItem4 = new Item("сгорел монитор", 3743, "Замена монитора");
    Item testItem5 = new Item("установить linux на компьютер", 8963, "Установка ОС");
    Item testItem6 = new Item("обнаружен вирус", 7865, "Настройка безопасности");
    Item testItem7 = new Item("установить новый процеесор, добавить оперативную память", 1445, "Апгрейд компьютера");
    Item testItem8 = new Item("создать учетную запись на почтовом сервере", 1223, "Новая почта");

    private Tracker addTestItems() {
        Tracker trackerList = new Tracker();
        trackerList.add(testItem1);
        trackerList.add(testItem2);
        trackerList.add(testItem3);
        trackerList.add(testItem4);
        trackerList.add(testItem5);
        trackerList.add(testItem6);
        trackerList.add(testItem7);
        trackerList.add(testItem8);
        return trackerList;
    }

    Tracker tracker = addTestItems();

    @Test
    public void whenAdd() {
        Tracker track = new Tracker();
        assertThat(track.add(testItem3), is(testItem3));
    }

    @Test
    public void whenGetByIndex() {
        int i = 5;
        assertThat(tracker.getByIndex(i), is(testItem6));
    }

    @Test
    public void whenFindByName() {
        String name = "Новая почта";
        Item[] expected = {testItem3, testItem8};
        assertThat(tracker.findByName(name), is(expected));
    }

    @Test
    public void whenFindByID() {
        String id = testItem5.getId();
        assertThat(tracker.findById(id), is(testItem5));
    }

    @Test
    public void whenGetAll() {
        Item[] expected = {testItem1, testItem2, testItem3, testItem4, testItem5, testItem6, testItem7, testItem8};
        assertArrayEquals(expected, tracker.findAll());

    }

    @Test
    public void whenReplace() {
        int index = tracker.findByIdIndex(testItem5.getId());
        tracker.replace(testItem5.getId(), testItem3);
        assertThat(tracker.getByIndex(index), is(testItem3));

    }

    @Test
    public void whenDelete() {
        Item[] expected = {testItem1, testItem2, testItem3, testItem4, testItem5, testItem7, testItem8};
        tracker.delete(testItem6.getId());
        assertArrayEquals(tracker.findAll(), expected);

    }

    @Test
    public void whenFindByIdIndex() {
        assertThat(tracker.findByIdIndex(testItem4.getId()), is(3));
    }

}
