package org.example.algorithms.sorting_algorithms.mergeSort;

public class MergeSort {

    public static void sort(int[] inputArr) {

        // 1. divide

        if (inputArr.length < 2){
            return;
        }

        int mid = inputArr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[inputArr.length-mid];

        for (int i = 0; i < mid; i++) {
            left[i] = inputArr[i];
        }

        for (int i = mid; i < inputArr.length; i++) {
            right[i - mid] = inputArr[i];
        }

        sort(left);
        sort(right);
        merge(inputArr , left ,right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length){
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            arr[k] = right[j];
            j++;
            k++;
        }
    }

}
