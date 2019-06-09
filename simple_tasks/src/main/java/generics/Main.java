package generics;

public class Main {
    public static void main(String[] args) {
        Box<Banana> boxBan1 = new Box<>(new Banana());
        for (int i = 0; i < 20; i++) {
            boxBan1.add(new Banana());
        }
        Box<Banana> boxBan2 = new Box<>(new Banana());
        for (int i = 0; i < 15; i++) {
            boxBan2.add(new Banana());
        }
        Box<Apple> boxApple1 = new Box<>(new Apple());
        for (int i = 0; i < 15; i++) {
            boxBan2.add(new Banana());
        }
        Box<Apple> boxApple2 = new Box<>(new Apple());
        for (int i = 0; i < 15; i++) {
            boxBan2.add(new Banana());
        }

        System.out.println(boxBan1.weightBox());
        System.out.println(boxBan2.weightBox());
        System.out.println(boxBan1.compareBox(boxBan2));
        boxBan1.emptyBox(boxBan2);
        System.out.println(boxBan1.weightBox());
        System.out.println(boxBan2.weightBox());
        System.out.println(boxApple1.compareBox(boxApple2));
    }
}
