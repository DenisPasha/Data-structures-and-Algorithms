package org.example.algorithms.searching_algorithms;

// Average Case: O(N)
public class LinearSearch {

    public static int search(int element , int[] array){

        for (int i = 0; i < array.length; i++) {
            if (element == array[i]){
                return i;
            }
        }
        throw new NullPointerException("Element does not exist in the given array");
    }
}
