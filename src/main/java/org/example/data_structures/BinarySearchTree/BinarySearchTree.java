package org.example.data_structures.BinarySearchTree;


public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {


    private Node<E> root;
    private Node<E> leftChild;
    private Node<E> rightChild;


    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.root == null){
            this.root = newNode;
        }else {
            Node<E> currentRoot = this.root;
            while (true){

                if (newNode.value.compareTo(currentRoot.value) < 0){
                    if (currentRoot.leftChild!=null){
                        currentRoot = currentRoot.leftChild;
                    }else {
                        currentRoot.leftChild = newNode;
                        break;
                    }
                }

                if (newNode.value.compareTo(currentRoot.value) > 0){
                    if (currentRoot.rightChild!=null){
                        currentRoot = currentRoot.rightChild;
                    }else {
                        currentRoot.rightChild = newNode;
                        break;
                    }
                }

            }
        }
    }

    @Override
    public boolean contains(E element) {
        Node<E> currentRoot = this.root;

        if (element.compareTo(currentRoot.value) < 0){

            while (currentRoot.leftChild!=null){
                if (currentRoot.value == element){
                    return true;
                }
                currentRoot = currentRoot.leftChild;
            }
            return false;


        } else if (element.compareTo(currentRoot.value) > 0){

            while (currentRoot.rightChild!=null){
                if (currentRoot.value == element){
                    return true;
                }
                currentRoot = currentRoot.rightChild;
            }
            return false;
        }

        return false;

    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {

        Node<E> currentRoot = this.root;
        BinarySearchTree<E> treeToReturn = new BinarySearchTree<>();

        if (element.compareTo(currentRoot.value) < 0){

            while (currentRoot.leftChild!=null){
                if (currentRoot.value == element){
                    initialiseTreeToReturn(currentRoot, treeToReturn);
                    return treeToReturn;
                }
                currentRoot = currentRoot.leftChild;
            }

        } else if (element.compareTo(currentRoot.value) > 0){

            while (currentRoot.rightChild!=null){
                if (currentRoot.value == element){
                    initialiseTreeToReturn(currentRoot, treeToReturn);
                    return treeToReturn;
                }
                currentRoot = currentRoot.rightChild;
            }

        }

        return treeToReturn;

    }

    private void initialiseTreeToReturn(Node<E> currentRoot, BinarySearchTree<E> treeToReturn) {
        treeToReturn.root = currentRoot;
        treeToReturn.leftChild = currentRoot.leftChild;
        treeToReturn.rightChild = currentRoot.rightChild;
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.root.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return this.root.rightChild;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }
}
