package ru.job4j.start;

public class StubInput implements Input {
    private final String[] value;
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }


    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
    @Override
    public int ask(String question, int[] ranges) {
        return -1;
    }
}
