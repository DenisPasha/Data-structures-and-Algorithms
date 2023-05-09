package org.example.data_structures.heap_BinarySearchTree_priorityQueue_exercise.solutions;

import org.example.data_structures.heap_BinarySearchTree_priorityQueue_exercise.interfaces.Decrease;
import org.example.data_structures.heap_BinarySearchTree_priorityQueue_exercise.interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap<E extends Comparable<E> & Decrease<E>> implements Heap<E> {

    private List<E> data;

    public MinHeap() {
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public void add(E element) {
        this.data.add(element);
        heapifyUp();
    }

    private void heapifyUp() {

        int addedElementCurrentIndex = this.data.size()-1;
        int parentIndex = getParentIndex(addedElementCurrentIndex);

        while (this.data.get(addedElementCurrentIndex).compareTo(this.data.get(parentIndex)) < 0){
            Collections.swap(this.data , parentIndex ,addedElementCurrentIndex);
            addedElementCurrentIndex = parentIndex;
            parentIndex = getParentIndex(addedElementCurrentIndex);
        }
    }

    private int getParentIndex(int addedElementCurrentIndex) {
        return (addedElementCurrentIndex-1 ) / 2;
    }

    @Override
    public E peek() {
        return this.data.get(0);
    }

    @Override
    public E poll() {
        Collections.swap(this.data , 0 , this.data.size()-1);
        E elementToReturn = this.data.remove(this.data.size() - 1);
        heapifyDown();

        return elementToReturn;
    }

    private void heapifyDown() {
        int currentElementIndex = 0;
        int leftChildIndex = getLeftChildIndex(currentElementIndex);
        int rightChildIndex = getRightChildIndex(currentElementIndex);

        insertOnProperPlace(currentElementIndex ,leftChildIndex ,rightChildIndex ,this.data);
    }

    private void insertOnProperPlace(int currentElementIndex, int leftChildIndex, int rightChildIndex, List<E> data) {
        if (data.get(currentElementIndex).compareTo(data.get(leftChildIndex)) > 0){


            Collections.swap(data , currentElementIndex ,leftChildIndex);
            currentElementIndex = leftChildIndex;
            leftChildIndex = getLeftChildIndex(currentElementIndex);
            if (leftChildIndex < data.size() ){
                insertOnProperPlace(currentElementIndex ,leftChildIndex,rightChildIndex ,data);
            }
        }
        if (data.get(currentElementIndex).compareTo(data.get(rightChildIndex)) < 0){
            Collections.swap(data , currentElementIndex ,rightChildIndex);
            currentElementIndex = rightChildIndex;
            rightChildIndex = getRightChildIndex(currentElementIndex);
            if (rightChildIndex < data.size()){
                insertOnProperPlace(currentElementIndex ,leftChildIndex,rightChildIndex ,data);
            }
        }

    }

    private int getRightChildIndex(int currentElementIndex) {
        return (currentElementIndex * 2) + 2;
    }

    private int getLeftChildIndex(int currentElementIndex) {
        return (currentElementIndex * 2) + 1;
    }

    @Override
    public void decrease(E element) {
        E elementFromHeap = this.data.stream().filter(e -> e.compareTo(element) == 0).findFirst().get();
        elementFromHeap.decrease();
        this.data.remove(elementFromHeap);
        this.add(elementFromHeap);
    }
}
