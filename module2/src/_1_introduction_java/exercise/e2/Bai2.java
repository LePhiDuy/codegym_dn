package _1_introduction_java.exercise.e2;

import java.util.Scanner;

public class Bai2 {
    static String result = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number: ");
        int number = sc.nextInt();
        if (number < 10) {
            System.out.println(convertNumberLess10ToString(number));
        } else if (number < 20) {
            System.out.println(convertNumberLess20ToString(number));
        } else if (number < 100) {
            System.out.println(convertNumberLess100ToString(number));
        } else if (number < 1000){
            System.out.println(convertNumberLess999ToString(number));
        }
    }

    public static String convertNumberLess10ToString(int num) {

        switch (num) {
            case 0:
                result = "zero";
                break;
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
                result = "four";
                break;
            case 5:
                result = "five";
                break;
            case 6:
                result = "six";
                break;
            case 7:
                result = "seven";
                break;
            case 8:
                result = "eight";
                break;
            case 9:
                result = "nine";
                break;
        }
        return result;
    }

    public static String convertNumberLess20ToString(int num) {
        switch (num % 10) {
            case 0:
                result = "ten";
                break;
            case 1:
                result = "eleven";
                break;
            case 2:
                result = "twelve";
                break;
            case 3:
                result = "thirteen";
                break;
            case 4:
                result = "fourteen";
                break;
            case 5:
                result = "fifteen";
                break;
            case 6:
                result = "sixteen";
                break;
            case 7:
                result = "seventeen";
                break;
            case 8:
                result = "eighteen";
                break;
            case 9:
                result = "nineteen";
        }
        return result;
    }

    public static String convertNumberLess100ToString(int num) {
        int dozens = num / 10;
        int units = num % 10;
        switch (dozens) {
            case 2:
                result = "twenty";
                break;
            case 3:
                result = "thirty";
                break;
            case 4:
                result = "fourty";
                break;
            case 5:
                result = "fifty";
                break;
            case 6:
                result = "sixty";
                break;
            case 7:
                result = "seventy";
                break;
            case 8:
                result = "eighty";
                break;
            case 9:
                result = "ninety";
                break;
        }
        if (units != 0) {
            result += " " + convertNumberLess10ToString(units);
        }
        return result;
    }
    public static String convertNumberLess999ToString(int num) {
        int hundreds = num / 100;
        int dezones = num - hundreds * 100;
        int units = num % 10;
        result = convertNumberLess10ToString(hundreds) + " " + "hundred";
        if (dezones >= 10 && dezones <= 19) {
            result += " " + "and" + " " + convertNumberLess20ToString(dezones);
        } else if (dezones >= 20 && dezones <= 99) {
            result += " " + "and" + " " + convertNumberLess100ToString(dezones);
        } else if (dezones % 10 == 0) {
            if (units != 0) {
                result += " " + convertNumberLess10ToString(units);
            }
        }
        return result;
    }
}
