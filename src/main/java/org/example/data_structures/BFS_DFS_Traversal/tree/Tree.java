package org.example.data_structures.BFS_DFS_Traversal.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Tree<E> implements AbstractTree {

    private E value;
    private Tree<E> parent;

    private boolean isVisited ;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... subTrees) {
        this.value = value;
        this.children = new ArrayList<>();
        this.isVisited = false;

        for (Tree<E> subTree : subTrees) {
          this.children.add(subTree);
          subTree.parent = this;
        }

    }



    @Override
    public void bfsTraverse() {
        ArrayDeque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (!queue.isEmpty()){
            Tree<E> current = queue.poll();
            if (!current.isVisited){
                current.isVisited = true;
                System.out.println(current.value.toString());

                for (Tree<E> child : current.children) {
                    queue.offer(child);
                }
            }

        }

    }

    @Override
    public void dfsTraverse() {
        ArrayDeque<Tree<E>> stack = new ArrayDeque<>();
        stack.push(this);

        while (!stack.isEmpty()){
            Tree<E> current = stack.pop();

            if (!current.isVisited){
                current.isVisited = true;
                System.out.println(current.value.toString());
                List<Tree<E>> reordered = new ArrayList<>();

                reverse(current, reordered);
                for (Tree<E> child : reordered) stack.push(child);
            }
        }
    }

    private void reverse(Tree<E> current, List<Tree<E>> reordered) {
        for (int i = current.children.size()-1; i >=0 ; i--) {
            reordered.add(current.children.get(i));
        }
    }


}
