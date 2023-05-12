package org.example.algorithms.searching_algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class searchAlgorithmsTest {

    @Test
    public void binarySearchTest(){
        int[] arr= {67,32,5,89,12};
        int[] arr1= {67,32,5,89,12,78,43,60,55,42,77};
        int search = BinarySearch.search(arr, 12);
        int search1 = BinarySearch.search(arr1, 60);
        int search2 = BinarySearch.search(arr1, 0);

        assertEquals(search, 12);
        assertEquals(search1, 60);
        assertEquals(search2, -100);
        System.out.println(search);
        System.out.println(search1);
        System.out.println(search2);



        System.out.println();
    }

}