package collect;


import java.util.*;

public class MainPass {
    public static void main(String[] args) {
        Password password = new Password();
        password.checkPassword("неправильный1!");
        password.checkPassword("Неправильный1");
        password.checkPassword("Неправильный!");
        password.checkPassword("Н1@");
        password.checkPassword("Неправильный1!СлишкомДлинныйПароль");
        password.checkPassword("Правильный1!");

    }
}
