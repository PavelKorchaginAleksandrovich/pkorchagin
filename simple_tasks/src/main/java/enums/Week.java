package enums;

public enum Week {
    MONDAY(8),
    TUESDAY(8),
    WEDNESDAY(8),
    THURSDAY(8),
    FRIDAY(7),
    SATURDAY(0),
    SUNDAY(0);

    private int hours;

    Week(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return this.hours;
    }
}
