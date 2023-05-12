package org.example.algorithms.sorting_algorithms.bubleSort;

import java.util.Collections;
// The average time complexity of Bubble sort is O(N^2)

public class BubbleSort {
    public static void sort(int [] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length  ; j++) {
                if (arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
