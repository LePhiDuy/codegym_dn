package _8_clean_code.demo_cleancode;

public class CleanCode {
    private static final int JANUARY = 1;

    public static int getDayOfMonth(int month, int year) {
        switch (month) {
            case JANUARY:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isALeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    public static boolean isALeapYear(int year) {
        final boolean isDivision400 = year % 400 == 0;
        return isDivision400 || (year % 100 != 0 && year % 4 == 0);
    }

    public static void main(String[] args) {

    }
}