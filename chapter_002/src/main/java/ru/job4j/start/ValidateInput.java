package ru.job4j.start;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Введите число");
            } catch (MenuOutException moe) {
                System.out.println("Введите номер из пункта меню");
            }
        } while (invalid);
        return value;
    }
}
