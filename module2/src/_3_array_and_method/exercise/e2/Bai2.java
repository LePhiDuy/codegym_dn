package _3_array_and_method.exercise.e2;

public class Bai2 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] newArray = insertElementOnArray(10, 2, arr);
        for (int i = 0; i <newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
    static int[] insertElementOnArray(int num, int index, int[] arr) {
        int length = arr.length;
        int[] newArray = new int[length + 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = arr[i];
        }
        newArray[index] = num;
        for (int i = newArray.length - 1; i > index; i--) {
            newArray[i] = arr[i - 1];
        }
        return newArray;
    }
}
