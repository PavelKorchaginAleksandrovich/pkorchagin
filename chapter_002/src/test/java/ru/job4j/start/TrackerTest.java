package ru.job4j.start;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {
    Tracker trackerList = new Tracker();
    Item testItem1 = new Item("не печатает принтер", 3232, "Ремонт принтера");

    public Tracker getTrackerList() {
        return this.trackerList;
    }

    @Test
    public whenFindByName() {

    }

    @Test
    public whenFindByID() {

    }


    @Test
    public whenReplace() {

    }



    @Test
    public void whenDelete() {



    }

}
