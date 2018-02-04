package ru.job4j.collections;

public class User implements Comparable<User> {
    private int id, age;
    private String name, city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(User o) {


        int result = this.name.compareTo(o.name);

        return result;
    }

}
