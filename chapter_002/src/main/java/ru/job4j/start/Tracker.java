package ru.job4j.start;

import java.util.*;


public class Tracker {
    private Item[] items = new Item[100];

    private int position = 0;
    private static final Random RN = new Random();
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++]= item;
    }
    public void replace(String id, Item item) {
        int index = findByIdIndex(id);
        if (index != -1) {
            this.items[index] = item;
        }
    }
    public void delete(String id) {
        int index = findByIdIndex(id);
        System.arraycopy(items, index, items, index+1, items.length - index +1);
    }
    public Item[] findAll() {
        Item[] result = new Item[position+1];
        int index=0;
        for (Item item: this.items) {
            result[index] = item;
            index++;
        }
        return result;
    }

    public Item[] findByName(String key) {
        int length, index
        for (Item item: this.items) {
            if (item != null && item.getName().equals(key)) {

            }

        }
        Item[] result = Item();
        result = null;
        return result;

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
    public int findByIdIndex(String id) {
        int result = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
