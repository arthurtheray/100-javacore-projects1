package prg40;

public enum DayOfWeek {
    MONDAY("Понедельник" , 1),
    TUESDAY("Вторник", 2),
    WEDNESDAY("Среда", 3),
    THURSDAY("Четверг", 4),
    FRIDAY("Пятница", 5),
    SATURDAY("Суббота", 6, true),
    SUNDAY("Воскресенье", 7, true);

    private final String russian;
    private final boolean isHoliday;
    private final int number;

    DayOfWeek(String russian, int number) {
        this.russian = russian;
        this.isHoliday = false;
        this.number = number;
    }

    DayOfWeek(String russian, int number, boolean isHoliday) {
        this.russian = russian;
        this.number = number;
        this.isHoliday = isHoliday;
    }


    public String getRussian() {
        return russian;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public static DayOfWeek byRussian(String russian) {
        if (russian == null) return null;

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.getRussian().equalsIgnoreCase(russian)) {
                return dayOfWeek;
            }
        }
        return null;
    }

    public int getNumber() {
        return number;
    }
}
