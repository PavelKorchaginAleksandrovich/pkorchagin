package exceptions;

import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

class SummMatrixTest {

    @Test
    void whenMatrixHaveWrongColumns() {
        String exeptionMessage = "неверный размер массива";
        String[][] matrix = {{"1", "2", "3"}, {"1", "2", "3"}};
        SummMatrix summMatrix = new SummMatrix(2, matrix);
        Throwable exception = assertThrows(MyArraySizeException.class, () -> summMatrix.checkSize());
        assertEquals(exeptionMessage, exception.getMessage());
    }

    @Test
    void  whenMatrixHaveWrongRaws() {
        String exeptionMessage = "неверный размер массива";
        String[][] matrix = {{"1", "2", "3"}, {"1", "2", "3"}};
        SummMatrix summMatrix = new SummMatrix(3, matrix);
        Throwable exception = assertThrows(MyArraySizeException.class, () -> summMatrix.checkSize());
        assertEquals(exeptionMessage, exception.getMessage());
    }
    @Test
    void whenMatrixHaveOneWrongCell() {
        String exeptionMessage = "Неправильные значения в следующих ячейках: 1 2; ";
        String[][] matrix = {{"1", "2", "3"}, {"1", "2", "фуфыры"}, {"1", "2", "3"}};
        SummMatrix summMatrix = new SummMatrix(2, matrix);
        Throwable exception = assertThrows(MyArrayDataException.class, () -> summMatrix.summ());
        assertEquals(exeptionMessage, exception.getMessage());
    }
    @Test
    void whenMatrixHaveFewWrongCells() {
        String exeptionMessage = "Неправильные значения в следующих ячейках: 1 2; 3 1; ";
        String[][] matrix = {{"1", "2", "3", "4"}, {"1", "2", "фуфыры", "4"}, {"1", "2", "3", "4"}, {"1", "фыра", "3", "4"}};
        SummMatrix summMatrix = new SummMatrix(2, matrix);
        Throwable exception = assertThrows(MyArrayDataException.class, () -> summMatrix.summ());
        assertEquals(exeptionMessage, exception.getMessage());
    }
    @Test
    void whenSummOfMatrixEquals30() {
        String[][] matrix2 = {{"1", "1", "3", "2"}, {"1", "2", "1", "1"}, {"1", "2", "3", "4"}, {"1", "0", "3", "4"}};
        SummMatrix summMatrix = new SummMatrix(4, matrix2);
        assertEquals(30, summMatrix.calculate());
    }



}