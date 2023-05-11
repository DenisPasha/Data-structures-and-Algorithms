package org.example.algorithms.sorting_algorithms.quickSort;

import java.util.Random;

public class QuickSort {

    public static void sort(int[] array){
        sort(array , 0 , array.length - 1);
    }

    private static void sort(int[] array, int lowIndex, int highIndex) {

        //iint[] arr = {5,3,19,8};


        // Base case
        if (lowIndex > highIndex){
            return;
        }

        //1. Choose a pivot
        int pivotIndex = highIndex;
//        int pivotIndex = (highIndex - lowIndex) / 2;
//        swap(array , pivotIndex ,highIndex );

        //2. Partitioning
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer){

            while (array[leftPointer] <= array[pivotIndex] && leftPointer < rightPointer){
                leftPointer++;
            }
            while (array[rightPointer] >= array[pivotIndex] && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(array , leftPointer ,rightPointer);
        }
        int newPivot = leftPointer;
        swap(array , newPivot,highIndex);
        sort(array ,lowIndex , newPivot - 1);
        sort(array ,newPivot + 1 , highIndex);
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
