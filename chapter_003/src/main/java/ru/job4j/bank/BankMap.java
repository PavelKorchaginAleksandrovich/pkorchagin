package ru.job4j.bank;
import java.util.*;
public class BankMap {
    private Map<User, List<Account>> users = new TreeMap<>();


    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = this.users.get(passport);
        if (accounts != null) {
            int index = accounts.indexOf(account);
            if (index != -1) {
                accounts.add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = this.users.get(passport);
        if (accounts != null) {
            accounts.remove(account);
        }
    }


    public List<Account> getUserAccounts(String passport) {
        return this.users.;
    }

    public boolean transferMoney(String srcPassport, int srcRequisite, String destPassport, int dstRequisite, double amount) {
        boolean result = false;
        List<Account> accountsFirst = this.users.get(srcPassport);
        List<Account> accountsSecond = this.users.get(destPassport);
        if (accountsFirst != null && accountsSecond != null) {
            int indexFirst = accountsFirst.indexOf(srcRequisite);
            int indexSecond = accountsSecond.indexOf(srcRequisite);
            if (indexFirst != -1 && indexSecond != -1) {
                Account accountFirst = accountsFirst.get(indexFirst);
                Account accountSecond = accountsSecond.get(indexSecond);
                if (accountFirst.subValue(amount)) {
                    accountSecond.addValue(amount);
                    result = true;
                }
            }
        }
        return result;
    }
}
