package _14_sort.exercise.e2;

public class InsertionSortByStep {
    public static void insertionSortByStep(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
            System.out.print("Array after the " + i + " sort: " );
            for (int k : list) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] list = {1, 5, -9, -11, 2, 8};
        insertionSortByStep(list);
    }
}
