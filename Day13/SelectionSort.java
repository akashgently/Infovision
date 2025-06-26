package com.Day13;

public class SelectionSort {
    public static void selection(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int minIndex = i;
            for(int j = i+1; j < n; j++){
                if(arr[j]<arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] data = {100, 100, 91, 78, 99, 100, 90};

        selection(data);

        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
