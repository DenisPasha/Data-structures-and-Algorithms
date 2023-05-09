package org.example.data_structures.avlTree;

public class AvlTree <E extends Comparable<E>> implements Tree<E>{

    public Node<E> root;

    @Override
    public void insert(E element){
        root = insert(element ,root);
    }

    @Override
    public void delete(E element) {
       root = delete(element , this.root);
    }

    private Node<E> insert(E key ,Node<E> node ) {

        if (node == null) {
            return new Node(key);
        } else if (node.getValue().compareTo(key) > 0) {
            node.setLeftChild(insert(key, node.getLeftChild()));
        } else if (node.getValue().compareTo(key) < 0) {
            node.setRightChild(insert(key, node.getRightChild()));
        }
        updateHeight(node);
        return applyRotation(node);
    }
    private Node<E> delete(E element, Node<E> node) {
        if (node == null) {
            return null;
        }

        if (isLess(element ,node)) {
            Node<E> delete = delete(element, node.getLeftChild());
            node.setLeftChild(delete);
        } else if (isGreater(element ,node)) {
            Node<E> delete = delete(element, node.getRightChild());
            node.setRightChild(delete);
        } else {

            if (node.getLeftChild() == null && node.getRightChild() == null){
                return null;
            }

            // One Child or Leaf Node (no children)
            if (node.getLeftChild() == null) {
                Node<E> temp = node.getRightChild();
                node = null;
                return temp;
            } else if (node.getRightChild() == null) {
                Node<E> temp = node.getLeftChild();
                node = null;
                return temp;
            }
            // Two Children
            E max = getMax(node.getLeftChild());
            node.setValue(max);
            Node<E> delete = delete(node.getValue(), node.getLeftChild());
            node.setLeftChild(delete);
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private E getMax(Node<E> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getValue();
    }

    private boolean areEqual(E element, Node<E> node) {
        return element.compareTo(node.getValue()) == 0;
    }

    private boolean isGreater(E element, Node<E> node) {
        return element.compareTo(node.getValue()) > 0;
    }

    private void updateHeight(Node<E> root) {
        int currentHeight = getCurrentHeight(root.getLeftChild());
        int currentHeight1 = getCurrentHeight(root.getRightChild());
        int max = Math.max(currentHeight, currentHeight1);

        root.setHeight(max + 1);

    }

    private int getCurrentHeight(Node<E> node) {
        return node !=null ? node.getHeight() : 0;
    }

    private Node<E> applyRotation(Node<E> node) {
        int balance = getBalanceFactor(node);
        if (balance > 1) {
            if (getBalanceFactor(node.getLeftChild()) < 0) {
               node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (getBalanceFactor(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<E> rotateRight(Node<E> root) {
        Node<E> leftChild = root.getLeftChild();
        Node<E> centerNode = leftChild.getRightChild();

        leftChild.setRightChild(root);
        root.setLeftChild(centerNode);

        updateHeight(root);
        updateHeight(leftChild);
        return leftChild;
    }

    private Node<E> rotateLeft(Node<E> root) {
        Node<E> rightChild = root.getRightChild();
        Node<E> centerNode = rightChild.getLeftChild();

        rightChild.setLeftChild(root);
        root.setRightChild(centerNode);

        updateHeight(root);
        updateHeight(rightChild);
        return rightChild;
    }

    private int getBalanceFactor(Node<E> root) {
        if (root!=null){
            int currentLeftHeight = getCurrentHeight(root.getLeftChild());
            int currentRightHeight = getCurrentHeight(root.getRightChild());
            return currentLeftHeight-currentRightHeight ;
        }else {
            return 0;
        }
    }


    private boolean isLess(E element, Node<E> node) {
        return element.compareTo(node.getValue()) < 0;
    }
}

