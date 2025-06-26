package com.Day13;

public class BubbleSort {
    public static void bubble(int[] arr){
            int n = arr.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;

                for (int j = 0; j < n - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }

                if (!swapped) {
                    break;
                }
            }
    }
    public static void main(String[] args) {
        int[] data = {100, 100, 91, 78, 99, 100, 90};

        bubble(data);

        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
