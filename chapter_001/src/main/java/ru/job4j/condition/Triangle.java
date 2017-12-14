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
     * По условию задачи в метод передаются расчитанные стороны преполагаемеого треугольника.
     * Треугольник не будет являться таковым, если фигура является прямой, а одна из точек лежит на этой прямой,
     * в таком случае самая длинная сторона будет равна сумме оставшихся.
     * Так же треугольник не будетя являться таковым, если фигура это точка,
     * это частный случай предыдущего усливия и в этом случае все стороны равны 0
     * и проверка на равенство суммы двух сторон с третьей будет выполняться.
     * ИЗ вышесказанного следует, что в случае, если фигура является прямой, тогда
     * А = В+С , где А - большая сторона, следовательно Р = А+В+С = А+А, где Р - периметр.
     * Я бы еще передал периметр, но так как задание составлено без его передачи, то посчитаем его в методе.
     */
    private boolean exist(double ab, double ac, double bc) {

        double maxSide;
        if (ab > ac) {
            maxSide = (ab > bc ? ab : bc);
        } else {
            maxSide = (ac > bc ? ac : bc);
        }
        return (ab + ac + bc != 2 * maxSide);
    }

}
