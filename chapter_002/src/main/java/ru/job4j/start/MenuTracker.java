package ru.job4j.start;


import ru.job4j.models.Item;

class AddItem implements  UserAction {
    @Override
    public int key() {
        return 0;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Add new Item");
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Имя новой заявки");
        String desc = input.ask("Описание новой заявки");
        tracker.add(new Item(name, desc));
    }
}
class Exit implements UserAction {
    StartUI ui;
    public Exit(StartUI ui) {
        this.ui = ui;
    }
    @Override
    public int key() {
        return 6;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Exit");
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        ui.exit();
    }
}

public class MenuTracker {
    private UserAction[] actions = new UserAction[7];
    private Tracker tracker;
    private Input input;

    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }
    public void fillActions(StartUI ui) {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItems();
        this.actions[2] = this.new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemsByName();
        this.actions[6] = new Exit(ui);
    }
    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    class ShowAllItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Список всех заявок:");
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("Имя: %s ID: %s", item.getName(), item.getId()));
            }
        }
    }
    class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id редактируемой заявки :");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(String.format("Заявка %s будет изменена", item.getName()));
                String name = input.ask("Введите новое имя заявки :");
                String desc = input.ask("Введите новое описание заявки :");
                item.setName(name);
                item.setDescription(desc);
            } else {
                System.out.println("Заявка не найдена, выберите другой ID");
            }
        }
    }
    class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки :");
            tracker.delete(id);
        }
    }
    static class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки :");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Заявка не найдена");
            } else {
                System.out.println(item.getName());
            }
        }
    }

    static class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            Item[] items = tracker.findByName(name);
            System.out.println(String.format("Найдено заявок %s", items.length));
            for (Item item : items) {
                System.out.println(String.format("Имя: %s ID: %s", item.getName(), item.getId()));
            }
        }
    }
}






