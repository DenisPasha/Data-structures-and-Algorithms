package org.example.algorithms.sorting_algorithms.mergeSort;

import org.example.algorithms.sorting_algorithms.bubleSort.BubbleSort;
import org.example.algorithms.sorting_algorithms.insertionSort.InsertionSort;
import org.example.algorithms.sorting_algorithms.quickSort.QuickSort;
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

    @Test
    public void insertionSortTest(){
        int[] arr = {12,32,21,125,76,122 ,9};
        int[] expected = {9,12,21,32,76,122,125};
        InsertionSort.sort(arr);
        assertArrayEquals(expected ,arr);
    }

    @Test
    public void quickSortTest(){
        int[] arr = {54,21,78,0,82,92};
        int[] expected = {0,21,54,78,82,92};
        QuickSort.sort(arr);

        int[] arr2 = {10,9,25,0,76};
        int[] expected2 = {0,9,10,25,76};
        QuickSort.sort(arr2);
        assertArrayEquals(expected2,arr2);
    }

}