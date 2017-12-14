package ru.job4j.calculator;

/**
 *@class Calculate задача 2.3.
 *@author Pavel Korchagin.
 *@since 13.12.2017.
 *@version 1.0.
 */

public class Calculate {
    private double result;

    /**
     *method сложение двух чисел.
     *@param first, second.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     *method разность двух чисел
     *@param first, second.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     *method деление одного числа на другое
     *@param first; second.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     *method умножение двух чисел
     *@param first, second.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     *method возвращение результата.
     */
    public double getResult() {
        return this.result;
    }

}
