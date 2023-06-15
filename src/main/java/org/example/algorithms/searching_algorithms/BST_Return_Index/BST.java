package org.example.algorithms.searching_algorithms.BST_Return_Index;

public class BST {
    public static int search(int[] arr, int wantedNum) {

        int indexOfWantedNumber = getIndexOfWantedNumber(arr, wantedNum, 0, arr.length - 1);
        return indexOfWantedNumber;

    }

    private static int getIndexOfWantedNumber(int[] arr, int wantedNum, int left, int right) {
        if (left > right) {
            return -1; // Element not found
        }

        int middle = left + (right - left) / 2;

        if (arr[middle] == wantedNum) {
            return middle; // Element found at middle index
        } else if (wantedNum < arr[middle]) {
            return getIndexOfWantedNumber(arr, wantedNum, left, middle - 1); // Search in the left half
        } else {
            return getIndexOfWantedNumber(arr, wantedNum, middle + 1, right); // Search in the right half
        }
    }
}