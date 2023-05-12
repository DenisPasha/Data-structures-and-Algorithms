package org.example.algorithms.searching_algorithms;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class searchAlgorithmsTest {

    @Test
    public void binarySearchTest(){
        int[] arr= {67,32,5,89,12};
        int[] arr1= {67,32,5,89,12,78,43,60,55,42,77};
        int search = BinarySearch.search(arr, 12);
        int search1 = BinarySearch.search(arr1, 60);

        assertEquals(search, 12);
        assertEquals(search1, 60);

    }

    @Test()
    public void searchThrows(){
        int[] arr1= {67,32,5,89,12,78,43,60,55,42,77};
        assertThrows(NullPointerException.class,() -> BinarySearch.search(arr1,0));
    }

    @Test
    public void linearSearch(){
        int[] arr1= {67,32,5,89,12,78,43,60,55,42,77};
        int search = LinearSearch.search(77, arr1);
        int index = 10;
        assertEquals(index,search);
    }
    @Test
    public void linearSearchThrows(){
        int[] arr1= {67,32,5,89,12,78,43,60,55,42,77};
        assertThrows(NullPointerException.class, () -> LinearSearch.search(0 ,arr1));
    }

    @Test
    public void interpolationSearch(){
        int[] arr1= {1,2,3,4,5,6,7,8,9,};
        int search = InterpolationSearch.search(arr1, 6);
        assertEquals(5,search);
    }
}