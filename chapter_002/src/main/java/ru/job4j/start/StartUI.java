package ru.job4j.start;
import ru.job4j.models.Item;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
               this.createItem();
           } else if (SHOWALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
                this.findByID();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();

            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void findByName() {
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        System.out.println("Найдено заявок " + items.length);
        for (Item item : items) {
            System.out.println("Имя: " + item.getName() + " ID: " + item.getId())0;
        }
    }

    private void edit() {
        String id = this.input.ask("Введите id редактируемой заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка " + item.getName() + " будет изменена");
            String name = this.input.ask("Введите новое имя заявки :");
            String desc = this.input.ask("Введите новое описание заявки :");
            item.setName(name);
            item.setDescription(desc);
        }else {
            System.out.println("Заявка не найдена, выберите другой ID");
        }
    }

    private void delete() {
        String id = this.input.ask("Введите id заявки :");
        this.tracker.delete(id);
    }

    private void showAll() {
        System.out.println("Список всех заявок:");
        for (Item item : this.tracker.findAll()) {
            System.out.println("Имя: " + item.getName() + " ID: " + item.getId());
        }
    }

    private void findByID() {
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка не найдена");
        }else {
            System.out.println(item.getName());
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
