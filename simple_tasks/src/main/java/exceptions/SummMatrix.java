package exceptions;

public class SummMatrix {

    private int size;

    private String[][] matrix;

    public SummMatrix(int size, String[][] matrix) {
        this.size = size;
        this.matrix = matrix;
    }

    public void checkSize() throws MyArraySizeException {
        boolean wrongSize = false;
        if (size <= 0 || matrix.length != size) {
            wrongSize = true;

        } else {

            for (int index = 0; !wrongSize && index != matrix.length; index++) {
                if (matrix[index].length != size) {
                    wrongSize = true;
                    break;
                }
            }
        }
        if (wrongSize) {
            throw new MyArraySizeException("неверный размер массива");
        }
    }

    public int summ() throws MyArrayDataException {
        String[] wrongData = new String[size * size];
        int wtrongStringAmount = 0;
        int summ = 0;


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                try {
                    int number = Integer.valueOf(matrix[row][col]);
                    summ = summ + number;

                } catch (NumberFormatException e) {
                    wrongData[wtrongStringAmount] = Integer.toString(row) + " " + Integer.toString(col);
                    wtrongStringAmount++;
                }

            }
        }
        if (wtrongStringAmount != 0) {
            StringBuilder message = new StringBuilder("Неправильные значения в следующих ячейках: ");
            for (int index = 0; index < wtrongStringAmount; index++) {
                message.append(wrongData[index]).append("; ");
            }
            throw new MyArrayDataException(message.toString());
        }
        return summ;
    }


    public int calculate() {
         try {
            checkSize();
            return summ();
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.getMessage();
            return -1;
        }

    }
}