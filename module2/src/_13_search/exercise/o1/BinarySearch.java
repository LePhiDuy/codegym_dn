package _13_search.exercise.o1;

public class BinarySearch {
    public static int searchBinary(int[] arr, int left, int right, int value) {
        int middle = (left + right) / 2;
        while (left <= right) {
            if (arr[middle] == value) {
                return middle;
            } else if(arr[middle] < value) {
                return searchBinary(arr, middle + 1, right, value);
            } else if(arr[middle] > value) {
                return searchBinary(arr, left, middle - 1, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9, 11, 24, 56};
        System.out.println(searchBinary(arr, 0, arr.length - 1, 4));
        System.out.println(searchBinary(arr, 0, arr.length - 1, 29));

    }
}
