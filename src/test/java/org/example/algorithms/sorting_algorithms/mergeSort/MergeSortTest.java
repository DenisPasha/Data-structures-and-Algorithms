package org.example.algorithms.sorting_algorithms.mergeSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {


    @Test
    public void testMergeSort(){
        int[] arr = {5,21,0,-54,199,87,15,32};
        int[] expected = {-54,0,5,15,21,32,87,199};
        MergeSort.sort(arr);
        assertArrayEquals(expected , arr);

    }


}