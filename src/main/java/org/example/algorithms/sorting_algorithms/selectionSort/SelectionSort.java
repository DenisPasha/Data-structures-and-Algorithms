package org.example.algorithms.sorting_algorithms.selectionSort;
// The average time complexity of Selection sort is O(N^2)

public class SelectionSort {
    public static void sort(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            int min = index;
            for (int curr = index + 1; curr < arr.length; curr++) {
                int minElement = arr[min];
                int current = arr[curr];
                if ( current < minElement ) {
                    min = curr;
                }
            }
            swap(arr, index, min);
        }
    }

    private static void swap(int[] arr, int index, int min) {
        int temp = arr[index];
        arr[index] = arr[min];
        arr[min] = temp;
    }
}
