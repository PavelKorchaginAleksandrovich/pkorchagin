package ru.job4j.bank;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import java.util.*;

public class BankMapTest {
    @Test
    public void whenAddUser() {
        BankMap map = new BankMap();
        map.addUser(new User("Ivan", "HP12"));
        assertThat(map.getUserAccounts("HP12"), is(new HashSet<>()));
    }

    @Test
    public void whenDeleteExistingUser() {
        User user1 = new User("Ivan", "HP12");
        BankMap map = new BankMap();
        map.addUser(user1);
        Set<Account> result = null;
        map.deleteUser(user1);
        assertThat(map.getUserAccounts("HP12"), is(result));
    }

    @Test
    public void whenAddAccountToExistingUser() {
        User user1 = new User("Ivan", "HP12");
        Account account = new Account(1000, 1234556789);
        BankMap map = new BankMap();
        map.addUser(user1);
        map.addAccountToUser("HP12", account);
        HashSet<Account> result = new HashSet<>();
        result.add(account);
        assertThat(map.getUserAccounts("HP12"), is(result));
    }
    @Test
    public void whenDelAccountFromExistingUser() {
        User user1 = new User("Ivan", "HP12");
        Account account = new Account(1000, 1234556789);
        BankMap map = new BankMap();
        map.addUser(user1);
        map.addAccountToUser("HP12", account);
        map.deleteAccountFromUser("HP12", account);
        assertThat(map.getUserAccounts("HP12"), is(new HashSet<>()));
    }
    @Test
    public void whenTranferMoneyBetweenDifferentUsers() {
        User user1 = new User("Ivan", "HP12");
        User user2 = new User("Petr", "HP15");
        Account account1 = new Account(1000, 1234556789);
        Account account2 = new Account(500, 123455678);
        BankMap map = new BankMap();
        map.addUser(user1);
        map.addUser(user2);
        map.addAccountToUser("HP12", account1);
        map.addAccountToUser("HP15", account2);
        assertThat(map.transferMoney("HP12", 1234556789, "HP15", 123455678, 100), is(true));
    }
    @Test
    public void whenTranferTooManyMoneyBetweenDifferentUsers() {
        User user1 = new User("Ivan", "HP12");
        User user2 = new User("Petr", "HP15");
        Account account1 = new Account(1000, 1234556789);
        Account account2 = new Account(500, 123455678);
        BankMap map = new BankMap();
        map.addUser(user1);
        map.addUser(user2);
        map.addAccountToUser("HP12", account1);
        map.addAccountToUser("HP15", account2);
        assertThat(map.transferMoney("HP12", 1234556789, "HP15", 123455678, 10000), is(false));
    }

}
