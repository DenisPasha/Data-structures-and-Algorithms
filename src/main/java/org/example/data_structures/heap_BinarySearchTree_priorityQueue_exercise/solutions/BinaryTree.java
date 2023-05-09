package org.example.data_structures.heap_BinarySearchTree_priorityQueue_exercise.solutions;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private int key;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int key, BinaryTree first, BinaryTree second) {
        this.key = key;
        this.left = first;
        this.right = second;
    }

    public Integer findLowestCommonAncestor(int first, int second) {
        List<Integer> firstPath = new ArrayList<>();
        List<Integer> secondpPath = new ArrayList<>();
        List<Integer> firstPathFromRoot = getPathFromRoot(this, first, firstPath);
        List<Integer> secondPathFromRoot = getPathFromRoot(this, second, secondpPath);
        return null;
    }

    private List<Integer> getPathFromRoot(BinaryTree currentRoot, int first, List<Integer> path) {
       if (currentRoot.key!=first){
           if (currentRoot.left!=null){
               path.add(currentRoot.key);
              return getPathFromRoot(currentRoot.left ,first ,path);
           }
           if (currentRoot.right!=null){
               path.add(currentRoot.key);
            return getPathFromRoot(currentRoot.right,first,path);
           }

       }
       return path;
    }


    public List<Integer> topView() {
        return null;
    }

}
