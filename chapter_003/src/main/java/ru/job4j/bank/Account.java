package ru.job4j.bank;

import java.util.Objects;

public class Account {
    private int requisites;
    private double value;
    public Account(int value, int requisites) {
        this.requisites = requisites;
        if (value >= 0) {
            this.value = value;
        }
    }

    public void addValue(double value) {
        this.value += value;
    }

    public boolean subValue(double value) {
        boolean result = false;
        if (this.value >= value) {
            this.value -= value;
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        }
        if (o == null || getClass() != o.getClass()) {
            result = false;
        }
        Account account = (Account) o;
        result = requisites == account.requisites;
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
