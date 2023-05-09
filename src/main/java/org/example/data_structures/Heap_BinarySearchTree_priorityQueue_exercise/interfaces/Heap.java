package org.example.data_structures.Heap_BinarySearchTree_priorityQueue_exercise.interfaces;

public interface Heap<E extends Comparable<E> & Decrease<E>> {
    int size();
    void add(E element);
    E peek();
    E poll();
    void decrease(E element);
}
