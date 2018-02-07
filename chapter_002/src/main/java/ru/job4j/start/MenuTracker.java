package ru.job4j.start;


import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.List;

class AddItem extends BaseAction {
    public AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Имя новой заявки");
        String desc = input.ask("Описание новой заявки");
        tracker.add(new Item(name, desc));
    }
}
class Exit extends BaseAction {
    StartUI ui;

    public Exit(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        ui.exit();
    }
}

public class MenuTracker {
    private ArrayList<UserAction> actions = new ArrayList<>();
    private Tracker tracker;
    private Input input;
    int position = 0;

    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }
    public void fillActions(StartUI ui) {

        this.actions.add(position, new AddItem(position++, "Add new Item"));
        this.actions.add(position, new ShowAllItems(position++, "Show all items"));
        this.actions.add(position, this.new EditItem(position++, "Edit item"));
        this.actions.add(position, this.new DeleteItem(position++, "Delete item"));
        this.actions.add(position, new FindItemById(position++, "Find item by Id"));
        this.actions.add(position, new FindItemsByName(position++, "Find items by name"));
        this.actions.add(position, new Exit(position++, "Exit", ui));
    }

    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    class ShowAllItems extends BaseAction {
        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Список всех заявок:");
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("Имя: %s ID: %s", item.getName(), item.getId()));
            }
        }
    }
    class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
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
    class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки :");
            tracker.delete(id);
        }
    }
    static class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
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

    static class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
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






