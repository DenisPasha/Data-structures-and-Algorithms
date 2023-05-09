package org.example.data_structures.BFS_DFS_Traversal.tree;

public class Main {
    public static void main(String[] args) {

        //bfs ordered tree from 1 to 11
        Tree childToChild3 = new Tree(9,new Tree<>(10,new Tree<>(11)));

        Tree childToChild2 = new Tree(3,new Tree<>(5,new Tree<>(7)  ));

        Tree childToRoot = new Tree(2,new Tree(4,new Tree<>(6,new Tree<>(8) ,childToChild3)));

        Tree bfsRootTree = new Tree(1 ,childToRoot,childToChild2 );

        bfsRootTree.bfsTraverse();



        // dfs ordered tree from 1 to 10
        Tree dfsChild2 = new Tree<>(8,new Tree<>(9) ,new Tree<>(10) );

        Tree dfsChild = new Tree<>(6,new Tree<>(7) ,dfsChild2);

        Tree dfsChildToRoot = new Tree<>(2,new Tree<>(3 ,new Tree<>(4) ,new Tree<>(5) ,dfsChild));

        Tree dfsRootTree = new Tree<>(1 ,dfsChildToRoot);
        dfsRootTree.dfsTraverse();

    }
}
