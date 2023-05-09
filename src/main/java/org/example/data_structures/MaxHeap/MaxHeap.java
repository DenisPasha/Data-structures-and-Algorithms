package org.example.data_structures.MaxHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

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

    public List<E> getElements(){
       return this.elements;
    }
}
