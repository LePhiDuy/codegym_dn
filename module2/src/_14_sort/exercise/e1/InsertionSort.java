package _14_sort.exercise.e1;

public class InsertionSort {
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] list = {1, 5, -9, -11, 2, 8};
        insertionSort(list);
        for (int i: list) {
            System.out.print(i + " ");
        }
    }
}
