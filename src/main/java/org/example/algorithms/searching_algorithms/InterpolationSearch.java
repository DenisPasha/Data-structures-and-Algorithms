package org.example.algorithms.searching_algorithms;

public class InterpolationSearch {
    public static int search(int[] arr, int element) {
        int lower = 0;
        int upper = arr.length - 1;

        while (lower <= upper && element >= arr[lower] && element <= arr[upper]) {
            if (lower == upper) {
                if (arr[lower] == element) {
                    return lower;
                }
                return -1;
            }

            int pos = lower + (((upper - lower) / (arr[upper] - arr[lower])) * (element - arr[lower]));

            if (arr[pos] == element) {
                return pos;
            }

            if (arr[pos] < element) {
                lower = pos + 1;
            } else {
                upper = pos - 1;
            }
        }

        return -1;
    }
}