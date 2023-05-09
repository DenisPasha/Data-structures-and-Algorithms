package org.example.data_structures.Heap_BinarySearchTree_priorityQueue_exercise.solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class CookiesProblem {
    public Integer solve(int requiredSweetness, int[] cookies) {
        Queue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i < cookies.length; i++) {
            priorityQueue.offer(cookies[i]);
        }

        int numOfOperations = 0;
        Integer leastSweetCookie = priorityQueue.peek();

        while (leastSweetCookie < requiredSweetness ){

            numOfOperations++;
            if (priorityQueue.size() < 2){
                return -1;
            }
            int leastSweet = priorityQueue.poll();
            int secondLeastSweet = priorityQueue.poll();

            int combinedCookie = leastSweet + (2 * secondLeastSweet);
            priorityQueue.offer(combinedCookie);
            leastSweetCookie = priorityQueue.peek();

        }
        return numOfOperations;
    }
}
