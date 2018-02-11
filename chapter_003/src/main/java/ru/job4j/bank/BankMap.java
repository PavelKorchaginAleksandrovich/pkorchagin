package ru.job4j.bank;
import java.util.*;
public class BankMap {
    private Map<User, Set<Account>> users = new HashMap<>();


    public void addUser(User user) {
        this.users.putIfAbsent(user, new HashSet<Account>());
    }

    private Account getAccountByRequisite(Set<Account> accounts, int requisite) {
        Account result = null;
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext() && result == null) {
            Account temp = it.next();
            result = temp.equals(new Account(requisite)) ? temp : null;
        }
        return result;
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        Set<Account> accounts = this.users.get(new User(passport));
        if (accounts != null) {
            accounts.add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        Set<Account> accounts = this.users.get(new User(passport));
        if (accounts != null) {
            accounts.remove(account);
        }
    }


    public Set<Account> getUserAccounts(String passport) {
        return this.users.get(new User(passport));
    }

    public boolean transferMoney(String srcPassport, int srcRequisite, String destPassport, int dstRequisite, double amount) {
        boolean result = false;
        Set<Account> srcAccounts = this.users.get(new User(srcPassport));
        Set<Account> dstAccounts = this.users.get(new User(destPassport));
        if (srcAccounts != null && dstAccounts != null) {
            Account srcAccount = this.getAccountByRequisite(srcAccounts, srcRequisite);
            Account dstAccount = this.getAccountByRequisite(dstAccounts, dstRequisite);
            if (srcAccount.subValue(amount)) {
                dstAccount.addValue(amount);
                result = true;

            }
        }
        return result;
    }
}
