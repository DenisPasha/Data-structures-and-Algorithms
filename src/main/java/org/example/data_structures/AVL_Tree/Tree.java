package org.example.data_structures.AVL_Tree;

public interface Tree <E> {
    class Node<E>{

        private E value;
        private int height;
        private Node<E> leftChild;
        private Node<E> rightChild;

        public Node(E value) {
            this.value = value;
            this.height = 1;
        }


        public void setValue(E value) {
            this.value = value;
        }

        public void setLeftChild(Node<E> leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node<E> rightChild) {
            this.rightChild = rightChild;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getLeftChild() {
            return leftChild;
        }

        public Node<E> getRightChild() {
            return rightChild;
        }
    }

   void insert(E element);
    void delete(E element);
}
