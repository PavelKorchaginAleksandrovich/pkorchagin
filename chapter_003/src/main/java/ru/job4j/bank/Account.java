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
    public Account(int requisites) {
        this.requisites = requisites;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
