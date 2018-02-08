package ru.job4j.bank;

import java.util.Objects;

public class User {
    private String name, passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public User(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return this.passport.equals(user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }


}
