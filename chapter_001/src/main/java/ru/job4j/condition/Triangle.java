package ru.job4j.condition;

/**
 *@class Triangle задача 3.3.
 *@author Pavel Korchagin.
 *@since 14.12.2017.
 *@version 1.0.
 */

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {

            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
    /**
     * Проверяем является ли фигура abc треугольником
     * @param ab, ac, bc расстояния сторон треугольника.
     * @return является ли данная фигура треугольником.
     */
    private boolean exist(double ab, double ac, double bc) {
        boolean thisIsTriangle;
        thisIsTriangle = ab < ac + bc && ac < ab + bc && bc < ab + ac;
        return thisIsTriangle;
    }

}
