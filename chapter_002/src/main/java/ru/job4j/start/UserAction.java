package ru.job4j.start;

public interface UserAction {
    int key();
    String info();
    void execute(Input input, Tracker tracker);
}
