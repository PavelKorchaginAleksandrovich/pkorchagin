package ru.job4j.bank;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name, passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o.getClass() == String.class) {
            return passport.equals(o);
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {

        return Objects.hash(passport);
    }

    @Override
    public int compareTo(User o) {
        return this.passport.compareTo(o.passport);
    }
}
