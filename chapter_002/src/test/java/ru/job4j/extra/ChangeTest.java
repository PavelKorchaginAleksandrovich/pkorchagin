package ru.job4j.extra;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.assertThat;
public class ChangeTest {
    @Test
    public void when35And50Then10And5() {
        int[] expected = {10, 5};
        Change change = new Change();
        int[] result = change.changes(50, 35);
        assertThat(result, is(expected));
    }
    @Test
    public void when47And50Then2And1() {
        int[] expected = {2, 1};
        Change change = new Change();
        int[] result = change.changes(50, 47);
        assertThat(result, is(expected));
    }
    @Test
    public void when3And100Then() {
        int[] expected = {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 2};
        Change change = new Change();
        int[] result = change.changes(100, 3);
        assertThat(result, is(expected));
    }
}
