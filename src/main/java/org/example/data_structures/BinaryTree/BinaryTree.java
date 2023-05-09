package org.example.data_structures.BinaryTree;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {

    private E key ;
    private BinaryTree<E> leftChild;
    private BinaryTree<E> rightChild;

    public BinaryTree(E key, BinaryTree<E> leftChild, BinaryTree<E> rightChild) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return this.rightChild;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder sb = new StringBuilder();
       String indentPreOrder = traverseWithRecursionPreOrder(this , indent ,sb);
       return indentPreOrder.trim();
    }

    private String traverseWithRecursionPreOrder(BinaryTree<E> tree, int indent , StringBuilder sb) {

        getOffset(indent, sb);
        sb.append(tree.getKey())
                .append(System.lineSeparator());

        if (tree.leftChild!=null){
            traverseWithRecursionPreOrder(tree.leftChild ,indent + 2 ,sb);
        }

        if (tree.rightChild!=null){
            traverseWithRecursionPreOrder(tree.rightChild ,indent +2 ,sb);
        }

       return sb.toString();
    }

    private static void getOffset(int indent, StringBuilder sb) {
        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {

        List<AbstractBinaryTree<E>> preOrderList = new ArrayList<>();
        List<AbstractBinaryTree<E>> preorderedList = traverseWithRecursionPreOrder(this, preOrderList);
        return preorderedList;
    }

    private List<AbstractBinaryTree<E>> traverseWithRecursionPreOrder(BinaryTree<E> tree, List<AbstractBinaryTree<E>> preOrderList) {

        preOrderList.add(tree);
        if(tree.leftChild != null){
            traverseWithRecursionPreOrder(tree.leftChild ,preOrderList);
        }

        if (tree.rightChild!=null){
            traverseWithRecursionPreOrder(tree.rightChild , preOrderList);
        }
        return preOrderList;

    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> inOrderList = new ArrayList<>();
        List<AbstractBinaryTree<E>> inOrderedList = traverseWithRecursionInOrder(this, inOrderList);
        return inOrderedList;

    }

    private List<AbstractBinaryTree<E>> traverseWithRecursionInOrder(BinaryTree<E> tree, List<AbstractBinaryTree<E>> inOrderList) {
        if(tree.leftChild != null){
            traverseWithRecursionInOrder(tree.leftChild ,inOrderList);
        }
        inOrderList.add(tree);
        if (tree.rightChild!=null){
            traverseWithRecursionInOrder(tree.rightChild , inOrderList);
        }
        return inOrderList;

    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> postOrderList = new ArrayList<>();
        List<AbstractBinaryTree<E>> postOrderedList = traverseWithRecursionPostOrder(this, postOrderList);
        return postOrderedList;
    }

    private List<AbstractBinaryTree<E>> traverseWithRecursionPostOrder(BinaryTree<E> tree, List<AbstractBinaryTree<E>> postOrderList) {
        if(tree.leftChild != null){
            traverseWithRecursionPostOrder(tree.leftChild ,postOrderList);
        }
        if (tree.rightChild!=null){
            traverseWithRecursionPostOrder(tree.rightChild , postOrderList);
        }
        postOrderList.add(tree);
        return postOrderList;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        List<AbstractBinaryTree<E>> inOrderList = inOrder();
        inOrderList.forEach(e-> consumer.accept(e.getKey()));
    }


}
