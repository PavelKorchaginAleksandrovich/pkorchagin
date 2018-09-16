package ru.job4j.collectpro;

public class UserStore extends AbstractStore<User> {
    public UserStore(int size) {
        super(size);
    }
//    private SimpleArray<User> users;
//
//    public UserStore(int size) {
//        this.users = new SimpleArray(size);
//    }
//    @Override
//    public void add(Base model) {
//        users.add((User) model);
//    }
//
//    @Override
//    public boolean replace(String id, Base model) {
//        boolean result = false;
//        int index = this.findIndexById(id);
//        if (index != -1) {
//                this.users.set(index, (User) model);
//                result = true;
//            }
//        return result;
//    }
//
//    @Override
//    public boolean delete(String id) {
//        boolean result = false;
//        int index = this.findIndexById(id);
//        if (index != -1) {
//            users.delete(index);
//            result = true;
//        }
//        return result;
//    }
//
//    @Override
//    public Base findById(String id) {
//        Base user = null;
//        for (Base element : users) {
//                if (element.getId() == id) {
//                user = element;
//                break;
//            }
//        }
//        return user;
//    }
//    private int findIndexById(String id) {
//        int index = -1;
//        int pos = 0;
//        for (int i = 0; i != this.users.getSize(); i++) {
//            if (this.users.get(i).getId() == id) {
//                index = i;
//                break;
//            }
//        }
//        return index;
//    }

}
