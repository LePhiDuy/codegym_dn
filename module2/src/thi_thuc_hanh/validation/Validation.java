package thi_thuc_hanh.validation;

public class Validation {
    private static final String CHOICE_REGEX = "^\\d{1}";

    public static boolean validChoice(String choice){
        return choice.matches(CHOICE_REGEX);
    }

    public static boolean validNumberPositive(String value){
        try {
            return Double.valueOf(value) > 0;
        }
        catch(Exception e){
            return false;
        }
    }
}
