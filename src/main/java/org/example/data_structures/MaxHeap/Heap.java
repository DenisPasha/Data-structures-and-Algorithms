package org.example.data_structures.MaxHeap;

import java.util.List;

public interface Heap<E extends Comparable<E>> {
    int size();
    void add(E element);
    E peek();

   List<E> getElements();
}
