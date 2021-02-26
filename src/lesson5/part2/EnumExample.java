package lesson5.part2;

public class EnumExample {
    enum DayOfWeek{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public static void main(String[] args) {
        DayOfWeek day5 = DayOfWeek.FRIDAY;
        System.out.println(day5);
    }
}
