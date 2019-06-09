package generics;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final double WEIGHT_OF_FRUIT;
    private ArrayList<T> fruits = new ArrayList<>();

    public Box(T fruit) {
        this.WEIGHT_OF_FRUIT = fruit.getWeight();
        this.fruits = new ArrayList<T>();
        fruits.add(fruit);
    }

    public void add(T fruit) {
       this.fruits.add(fruit);
    }

    public double weightBox() {
        return WEIGHT_OF_FRUIT * fruits.size();
    }

    public void emptyBox(Box<T> box) {
       this.fruits.addAll(box.fruits);
       box.fruits.clear();
    }
    public boolean compareBox(Box<T> box) {
        return this.weightBox() == box.weightBox();
    }
}
