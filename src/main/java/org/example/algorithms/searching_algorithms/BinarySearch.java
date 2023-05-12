package org.example.algorithms.searching_algorithms;

import java.util.Arrays;

public class BinarySearch {


    public static int search(int[]elements ,int element ){
        Arrays.sort(elements);
        System.out.println();
       return search(element , elements );
    }

    private static int search(int element, int[] elements) {

        if (elements.length < 1){
            throw new NullPointerException("Element does not exist in the given array");
        }

        if (elements[0] == element) {
            return elements[0];
        }

        int pivot = elements[elements.length / 2];
        if (element < pivot) {
            int newArrLength = (elements.length - 1) / 2;
            int[] left = new int[newArrLength];
            for (int i = 0; i < newArrLength; i++) {
                left[i] = elements[i];
            }
            return search(element, left);
        } else if (element > pivot) {

            int newArrLength = (elements.length - 1) / 2;
            int[] right = new int[newArrLength];
            for (int i = newArrLength + 1 ; i < elements.length; i++) {
                right[i - newArrLength - 1 ] = elements[i];
            }
            return search(element, right);
        } else if (element == pivot) {
            return pivot;
        }
        return pivot;
    }
}
