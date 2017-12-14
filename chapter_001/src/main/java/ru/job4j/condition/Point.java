package ru.job4j.condition;

/**
 *@class Point задача 2.4.
 *@author Pavel Korchagin.
 *@since 14.12.2017.
 *@version 1.0.
 */

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public float distanceTo(Point that) {
        return (float) Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    public static void main(String[] args) {
        Point a = new Point(0, 2);
        Point b = new Point(2, 0);
        int x1 = a.x;
        int y1 = a.y;
        int x2 = b.x;
        int y2 = b.y;
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        float result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
