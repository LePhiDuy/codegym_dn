package _3_array_and_method.exercise.e5;

public class Bai5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int minValue = findElementMinInArray(arr);
        System.out.println("Element min in arr is " + minValue);
    }

    static int findElementMinInArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
