package ru.job4j.start;

public class Item {
    private String id;
    private String description;
    private long create;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item (String id, String description, long create){
        this.id = id;
        this.description = description;
        this.create = create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreate() {
        return this.create;
    }

    public void setCreate(long create) {
        this.create = create;
    }
}
