package org.example.data_structures.heap_BinarySearchTree_priorityQueue_exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    private int count;

    public static class Node<E> {
        private E value;
        private Node<E> leftChild;
        private Node<E> rightChild;

        public Node() {
        }

        public Node(E value) {
            this.value = value;
        }

        public Node<E> getLeft() {
            return this.leftChild;
        }

        public Node<E> getRight() {
            return this.rightChild;
        }

        public E getValue() {
            return this.value;
        }
    }

    public void insert(E element) {
        Node<E> nodeToInsert = new Node<>(element);
        if (this.root == null){
            this.root = nodeToInsert;
            count++;
        }
        insertRecursively(this.root ,nodeToInsert);
    }

    private void insertRecursively(Node<E> currentRoot, Node<E> nodeToInsert) {

        if (isLess(nodeToInsert.value , currentRoot.value)){
            if (currentRoot.leftChild == null){
                currentRoot.leftChild = nodeToInsert;
                count++;
            }else {
                insertRecursively(currentRoot.leftChild ,nodeToInsert);
            }
        } else if (isGreater(nodeToInsert.value, currentRoot.value)) {
            if (currentRoot.rightChild == null){
                currentRoot.rightChild = nodeToInsert;
                count++;
            }else {
                insertRecursively(currentRoot.rightChild, nodeToInsert);
            }
        }

    }

    public void eachInOrder(Consumer<E> consumer) {
            traverseInOrder(this.root ,consumer);
    }

    private void traverseInOrder(Node<E> tree, Consumer<E> consumer) {
        Node<E> currentRoot = tree;
        if (currentRoot == null){
            return;
        }
        if(currentRoot.leftChild!=null){
            traverseInOrder(currentRoot.leftChild , consumer);
        }
        consumer.accept(currentRoot.value);
        if(currentRoot.rightChild!=null){
            traverseInOrder(currentRoot.rightChild , consumer);
        }
    }

    public Node<E> getRoot() {
        return this.root;
    }

    public boolean contains(E element) {
        Node<E> currentRoot = this.root;

        while (currentRoot != null && currentRoot.value!=null) {
            if (isLess(element, currentRoot.value)) {
                currentRoot = currentRoot.leftChild;
            } else if (isGreater(element, currentRoot.value)) {
                currentRoot = currentRoot.rightChild;
            } else if (isEqual(element, currentRoot.value)) {
                return true;
            }
        }
        return false;
    }

    public BinarySearchTree<E> search(E element) {
        BinarySearchTree<E> tree = this;

        ArrayDeque<Node<E>> queue = new ArrayDeque<>();
        queue.offer(tree.root);
        while (!queue.isEmpty()){
            Node<E> currentRoot = queue.poll();
            if (currentRoot.value == element){
                BinarySearchTree<E> treeToReturn = new BinarySearchTree<>();
                treeToReturn.root = currentRoot;
                treeToReturn.root.leftChild = currentRoot.leftChild;
                treeToReturn.root.rightChild = currentRoot.rightChild;
                return treeToReturn;
            }
            if (currentRoot.leftChild!=null ){
                queue.offer(currentRoot.leftChild);
            }
            if (currentRoot.rightChild!=null){
                queue.offer(currentRoot.rightChild);
            }
        }
        return null;
    }
    public List<E> range(E lower, E upper) {
        List<E> elements = new ArrayList<>();

       return findFloor(this.root ,lower ,upper ,elements);
    }

    private List<E> findFloor(Node<E> node, E lower, E upper, List<E> elements) {
        Node<E> currentNode = node;
        if (currentNode == null){
            return null;
        }
        Integer currentNodeValue = Integer.valueOf(String.valueOf(currentNode.value));
        Integer lowerValue = Integer.valueOf(String.valueOf(lower));
        Integer upperValue = Integer.valueOf(String.valueOf(upper));

        if (currentNodeValue >= lowerValue && currentNodeValue <= upperValue ){

            elements.add(currentNode.value);
        }
        if (currentNode.leftChild!=null){
            findFloor(currentNode.leftChild , lower ,upper ,elements);
        }
        if (currentNode.rightChild!=null){
            findFloor(currentNode.rightChild , lower ,upper ,elements);
        }
        return elements;
    }



    public void deleteMin() {
        if (this.root == null){
            throw new IllegalStateException();
        }
        List<Node<E>> nodes = new ArrayList<>();
        nodes.add(this.root);
        deleteMinElement(this.root ,nodes);
        count--;

    }

    private void deleteMinElement(Node<E> currentRoot , List<Node<E>> nodes) {
        if (currentRoot.leftChild!=null){
            nodes.add(currentRoot.leftChild);
            deleteMinElement(currentRoot.leftChild ,nodes);
        }else {
            if (currentRoot.rightChild!=null){
                Node<E> parent = nodes.get(nodes.size() - 2);
                parent.leftChild = currentRoot.rightChild;
            }
            currentRoot.value = null;
            currentRoot = null;
        }
    }

    public void deleteMax() {
        if (this.root == null){
            throw new IllegalStateException();
        }
        List<Node<E>> nodes = new ArrayList<>();
        nodes.add(this.root);
        deleteMaxElement(this.root ,nodes);
        count--;
    }

    private void deleteMaxElement(Node<E> currentRoot, List<Node<E>> nodes) {
        if (currentRoot.rightChild!=null){
            nodes.add(currentRoot.rightChild);
            deleteMaxElement(currentRoot.rightChild ,nodes);
        }else {
            if (currentRoot.leftChild!=null){
                Node<E> parent = nodes.get(nodes.size() - 2);
                parent.rightChild = currentRoot.leftChild;
            }
            currentRoot.value = null;
            currentRoot = null;
        }
    }

    public int count() {
        return this.count;
    }

    public int rank(E element) {
        int count = 0;
        int countOfSmallerThen = getCountOfSmallerThen(element, this.root, count);
        return countOfSmallerThen;
    }

    private int getCountOfSmallerThen(E element, Node<E> currentRoot, int count ) {

            if (element.compareTo(currentRoot.value) <= 0 ){
                if (currentRoot.leftChild!=null){
                   return getCountOfSmallerThen(element ,currentRoot.leftChild ,count);
                }
            }
            if (element.compareTo(currentRoot.value) > 0){
                count++;
                if (currentRoot.leftChild!=null){
                  return   getCountOfSmallerThen(element, currentRoot.leftChild, count);
                }
                if (currentRoot.rightChild!=null){
                  return   getCountOfSmallerThen( element,currentRoot.rightChild,count);
                }
            }
            return count;
    }

    public E ceil(E element) {
        BinarySearchTree<E> search = search(element);
        if (search == null){
            throw new IllegalStateException();
        }
        Node<E> currentRoot = search.root;
        if (currentRoot.rightChild==null){
            currentRoot = currentRoot.leftChild;
        }
        return findCeil(currentRoot);
    }

    private E findCeil(Node<E> currentRoot) {

        if (currentRoot.rightChild!=null){
            return findCeil(currentRoot.rightChild) ;
        }else {
            return currentRoot.value;
        }

    }

    public E floor(E element) {
        BinarySearchTree<E> search = search(element);
        if (search == null){
            throw new IllegalStateException();
        }
        Node<E> currentRoot = search.root;
        if (currentRoot.leftChild==null){
            currentRoot = currentRoot.rightChild;
        }
       return findFloor(currentRoot);
    }

    private E findFloor(Node<E> currentRoot) {

        if (currentRoot.leftChild!=null){
           return findFloor(currentRoot.leftChild);
        }else {
            return currentRoot.value;
        }

    }

    private boolean isLess(E newNodeValue, E treeValue) {
        return newNodeValue.compareTo(treeValue) < 0;
    }

    private boolean isGreater(E newNodeValue, E treeValue) {
        return newNodeValue.compareTo(treeValue) > 0;
    }

    private boolean isEqual(E newNodeValue, E treeValue) {
        return newNodeValue.compareTo(treeValue) == 0;
    }
}
