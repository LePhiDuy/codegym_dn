package _14_sort.practice.p3;

public class SelectionSort {
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min_index]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                int temp = list[min_index];
                list[min_index] = list[i];
                list[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {1, 5, 2, 9, 4, 47, 18};
        selectionSort(list);
        for (int i: list) {
            System.out.print(i + " ");
        }
    }
}
