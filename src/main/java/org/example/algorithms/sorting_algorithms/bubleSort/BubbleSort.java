package org.example.algorithms.sorting_algorithms.bubleSort;

import java.util.Collections;

public class BubbleSort {
    public static void sort(int [] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length  ; j++) {
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
