package enums;

public class Schedule {


    public static int amountHours(Week day) {
        int result = 0;
        if (day.getHours() != 0) {
            switch (day) {
                case MONDAY:
                    result = result + Week.MONDAY.getHours();

                case TUESDAY:
                    result = result + Week.TUESDAY.getHours();

                case WEDNESDAY:
                    result = result + Week.WEDNESDAY.getHours();

                case THURSDAY:
                    result = result + Week.THURSDAY.getHours();

                case FRIDAY:
                    result = result + Week.FRIDAY.getHours();

                case SATURDAY:
                    result = result + Week.SATURDAY.getHours();

                case SUNDAY:
                    result = result + Week.SUNDAY.getHours();
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + day);
            }
        }
        return result;
    }

    public static void task(Week day) {
        int result = amountHours(day);
        if (result != 0) {
            System.out.println("Осталось дней:" + result);
        } else {
            System.out.println("Сегодня выходной");
        }
    }


    public static void main(String[] args) {
        task(Week.WEDNESDAY);
        task(Week.SATURDAY);
    }
}
