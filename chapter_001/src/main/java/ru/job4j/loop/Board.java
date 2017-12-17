package ru.job4j.loop;
/**
 *@class Loop задача 4.1.
 *@author Pavel Korchagin.
 *@since 15.12.2017.
 *@version 1.0.
 */

public class Board {
    /**
     * Рисует шахматную доску с заданной шириной и высотой.
     * @param width
     * @param height
     * @return string of board
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int countHeight = 1; countHeight <= height; countHeight++) {
            for (int countWidth = 1; countWidth <= width; countWidth++) {
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if (((countHeight + countWidth) % 2) == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
