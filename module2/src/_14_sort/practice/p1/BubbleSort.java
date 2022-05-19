package _14_sort.practice.p1;

public class BubbleSort {
    public static void bubbleSort(int[] list) {
        boolean isSwap = true;
        for (int i = 0; i < list.length - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    isSwap = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {5, 7, -9, 8, 2, 87, 29};
        bubbleSort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
