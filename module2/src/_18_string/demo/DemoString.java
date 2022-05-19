package _18_string.demo;

public class DemoString {
    public static int compareTo(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int lengthMin = (length1 > length2) ? length2 : length1;
        for (int i = 0; i < lengthMin; i++) {
            int charStr1 = (int)str1.charAt(i);
            int charStr2 = (int)str2.charAt(i);

            if (charStr1 != charStr2) {
                return charStr1 - charStr2;
            }
        }
        if (length1 != length2) {
            return length1 - length2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String string1 = new String("Geeksforgeeks");
        String string2 = new String("Practice");
        String string3 = new String("Geeks");
        String string4 = new String("Geeks");

        // Comparing for String 1 < String 2
        System.out.println("Comparing " + string1 + " and " + string2
                + " : " + compareTo(string1, string2));

        // Comparing for String 3 = String 4
        System.out.println("Comparing " + string3 + " and " + string4
                + " : " + compareTo(string3, string4));

        // Comparing for String 1 > String 4
        System.out.println("Comparing " + string1 + " and " + string4
                + " : " + compareTo(string1, string4));

        System.out.println(string3.equals(string4)); // => true
    }
}
