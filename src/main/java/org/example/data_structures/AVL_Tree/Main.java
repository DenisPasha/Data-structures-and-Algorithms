package org.example.data_structures.AVL_Tree;

public class Main {
    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);

        avlTree.delete(10);
        avlTree.delete(20);
        System.out.println();



    }
}
