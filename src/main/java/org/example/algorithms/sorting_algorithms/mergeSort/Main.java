package org.example.algorithms.sorting_algorithms.mergeSort;

public class Main {
    public static void main(String[] args) {

        int[] arr = {5,21,0,-54,199,87,15,32};
        int[] sorted = {-54,0,5,15,21,32,87,199};
        MergeSort.sort(arr);
        System.out.println();
    }
}
