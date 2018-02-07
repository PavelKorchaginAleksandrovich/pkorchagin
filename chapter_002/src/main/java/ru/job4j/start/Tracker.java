package ru.job4j.start;

import ru.job4j.models.Item;

import java.util.*;
import java.io.*;


public class Tracker {
    private static final Random RN = new Random();
    private Item[] items = new Item[100];

    private int position = 0;

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    public void replace(String id, Item item) {
        int index = findByIdIndex(id);
        if (index != -1) {
            this.items[index] = item;
        }
    }
    public void delete(String id) {

        int index = findByIdIndex(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, this.position - index - 1);
            this.position--;
            this.items[position] = null;
        }
    }

    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    public Item[] findByName(String key) {
        //посчитаем сколько совпадений и найдем индексы совпадений
        int count = 0;
        Item[] items = new Item[this.items.length];
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                items[count] = item;
                count++;
            }
        }

        return Arrays.copyOf(items, count);
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item: this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    // вспомогательные методы, ищет индекс по id, возвращает item по индексу
    public int findByIdIndex(String id) {
        int result = -1;
        for (int i = 0; i != this.position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
    public Item getByIndex(int index) {
        Item result = null;
        if (index < this.items.length) {
            result = this.items[index];
        }
        return result;
    }

}

