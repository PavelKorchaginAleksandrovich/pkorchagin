package ru.job4j.collectpro;

public abstract class AbstractStore<E extends Base> implements Store {
    private SimpleArray<E> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray(size);
    }
    @Override
    public void add(Base model) {
        simpleArray.add((E) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        int index = this.findIndexById(id);
        if (index != -1) {
                this.simpleArray.set(index, (E) model);
                result = true;
            }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = this.findIndexById(id);
        if (index != -1) {
            simpleArray.delete(index);
            result = true;
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        Base user = null;
        for (Base element : simpleArray) {
                if (element.getId() == id) {
                user = element;
                break;
            }
        }
        return user;
    }
    private int findIndexById(String id) {
        int index = -1;
        int pos = 0;
        for (int i = 0; i != this.simpleArray.getSize(); i++) {
            if (this.simpleArray.get(i) != null && this.simpleArray.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
}
