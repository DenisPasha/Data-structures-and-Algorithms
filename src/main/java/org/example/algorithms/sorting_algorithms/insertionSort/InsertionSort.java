package org.example.algorithms.sorting_algorithms.insertionSort;

// The average time complexity of Insertion sort is O(N^2)
public class InsertionSort {


    public static void sort(int[] arr ){

        for (int i = 1; i < arr.length; i++) {
            int second = arr[i];
            int j = i - 1;

            while (j>=0 && second < arr[j]){
                // swap
                int temp = arr[j];
                arr[j] = second;
                arr[j + 1] = temp;
                j--;
            }
            arr[j + 1] = second;
        }

    }
}
