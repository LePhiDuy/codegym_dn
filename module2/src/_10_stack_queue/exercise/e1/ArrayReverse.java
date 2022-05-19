package _10_stack_queue.exercise.e1;

import java.util.Stack;

public class ArrayReverse {
    public static void reverseIntegerArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println("Mảng sau khi đảo ngược là: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void reverseArrayString(String s) {
        Stack<String> stack = new Stack<>();
        for (String mWord : s.split("")) {
            stack.push(mWord);
        }
        String newString = new String();
        for (int i = 0; i < s.length(); i++) {
            newString += stack.pop();
        }
        System.out.print("String after reverse: " + newString);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        String s = "hello";
        reverseIntegerArray(arr);
        reverseArrayString(s);
    }
}
