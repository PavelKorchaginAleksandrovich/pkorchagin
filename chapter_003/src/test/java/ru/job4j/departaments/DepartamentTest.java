package ru.job4j.departaments;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class DepartamentTest {
    @Test
    public void whenFillAndDirectSort() {
        List<String> depsString =  new ArrayList<>(Arrays.asList(
                "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K3\\SK3\\SSK2\\SSk4"));
        Departament deps = new Departament(depsString);
        deps.fillDeps();
        deps.directSort();
        List<String> expected = new ArrayList<>(Arrays.asList(
                "K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2",
                "K3", "K3\\SK3", "K3\\SK3\\SSK2", "K3\\SK3\\SSK2\\SSk4"));
        assertThat(depsString, is(expected));
    }
    @Test
    public void whenFillAndReverseSort() {
        List<String> depsString =  new ArrayList<>(Arrays.asList(
                "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K3\\SK3\\SSK2\\SSk4"));
        Departament deps = new Departament(depsString);
        deps.fillDeps();
        deps.reverseSort();
        List<String> expected = new ArrayList<>(Arrays.asList(
                "K3", "K3\\SK3", "K3\\SK3\\SSK2", "K3\\SK3\\SSK2\\SSk4",
                "K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"));
        assertThat(depsString, is(expected));
    }
}
