package org.example.data_structures.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {

    List<E> elements = new ArrayList<>();


    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(E element) {
        elements.add(element);
        heapifyUp(elements.size() - 1);
    }

    private void heapifyUp(int index) {

        int parentIndex = getParentIndex(index);
        int childIndex = index;

        while (elements.get(childIndex).compareTo(elements.get(parentIndex) ) > 0){
            Collections.swap(elements , parentIndex , childIndex);
            childIndex = parentIndex;
            parentIndex = getParentIndex(childIndex);

        }
    }

    private int getParentIndex(int currentIndex) {
        return (currentIndex - 1) /2;
    }

    @Override
    public E peek() {
        if (this.elements.size() > 0){
            return elements.get(0);
        }else {
            throw new IllegalStateException("Heap is empty , cannot peek not existing element!");
        }
    }

    @Override
    public E poll() {
        Collections.swap(this.elements , this.elements.size()-1 , 0);
        E toBeRemoved = this.elements.get(this.elements.size() - 1);
        this.elements.remove(toBeRemoved);
        heapifyDown();
        return toBeRemoved;
    }

    private void heapifyDown() {
        int currentRootIndex = 0;
        E currentRootElement = this.elements.get(0);
        int leftChildIndex = getLeftChildIndex(currentRootIndex);
        int rightChildIndex = getRightChildIndex(currentRootIndex);

        if (this.elements.size() > 1){


            while (currentRootElement.compareTo(this.elements.get(leftChildIndex)) < 0){

                Collections.swap(this.elements , currentRootIndex , leftChildIndex);
                currentRootIndex = leftChildIndex;
                leftChildIndex = getLeftChildIndex(currentRootIndex);
                if(leftChildIndex >= this.elements.size()){
                    return;
                }
            }

            while (currentRootElement.compareTo(this.elements.get(rightChildIndex)) < 0){
                Collections.swap(this.elements , currentRootIndex , rightChildIndex);
                currentRootIndex = rightChildIndex;
                rightChildIndex = getLeftChildIndex(currentRootIndex);
            }
        }

    }

    private int getLeftChildIndex(int currentRootIndex) {
        return (currentRootIndex * 2) + 1;
    }
    private int getRightChildIndex(int currentRootIndex) {
        return (currentRootIndex * 2) + 2;
    }
}
