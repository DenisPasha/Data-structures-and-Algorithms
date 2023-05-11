package org.example.algorithms.sorting_algorithms.mergeSort;

import org.example.algorithms.sorting_algorithms.bubleSort.BubbleSort;
import org.example.algorithms.sorting_algorithms.selectionSort.SelectionSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortAlgorithmsTest {


    @Test
    public void testMergeSort(){
        int[] arr = {5,21,0,-54,199,87,15,32};
        int[] expected = {-54,0,5,15,21,32,87,199};
        MergeSort.sort(arr);
        assertArrayEquals(expected , arr);

    }

    @Test
    public void testBubbleSort(){
        int[] arr = {12,32,21,125,76,122 ,9};
        int[] expected = {9,12,21,32,76,122,125};
        BubbleSort.sort(arr);
        assertArrayEquals(expected ,arr);
    }

    @Test
    public void selectionSortTest(){
        int[] arr = {12,32,21,125,76,122 ,9};
        int[] expected = {9,12,21,32,76,122,125};
        SelectionSort.sort(arr);
        assertArrayEquals(expected ,arr);
    }


}