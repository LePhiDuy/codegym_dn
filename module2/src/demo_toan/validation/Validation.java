package demo_toan.validation;

public class Validation {
    private static final String CHOICE_REGEX = "^\\d{1}";

    public static boolean validChoice(String choice){
        return choice.matches(CHOICE_REGEX);
    }
}
