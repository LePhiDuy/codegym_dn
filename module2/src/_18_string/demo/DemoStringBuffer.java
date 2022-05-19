package _18_string.demo;

public class DemoStringBuffer {
    public static void main(String[] args) {
        // Creating adn storing string by creating object of
        // StringBuffer
//        StringBuffer s = new StringBuffer("GeeksforGeeks");
//
//        // Getting the length of the string
//        int p = s.length();
//
//        // Getting the capacity of the string
//        int q = s.capacity();
//
//        // Printing the length and capacity of
//        // above generated input string on console
//        System.out.println("Length of string GeeksforGeeks="
//                + p);
//        System.out.println(
//                "Capacity of string GeeksforGeeks=" + q);
        StringBuffer s = new StringBuffer("Geeksfor");

        // Usage of append() method
        s.append("Geeks");

        // Returns GeeksforGeeks
        System.out.println(s);

        s.append(1);
        // Returns GeeksforGeeks1
        System.out.println(s);
    }
}
