package org.example.data_structures.BFS_DFS_Traversal.bfs;

import java.util.ArrayDeque;

public class BreadthFirstSearch<E>{
    private final Vertex<E> root;

    public BreadthFirstSearch(Vertex<E> root) {
        this.root = root;
    }

    public void traverse(){
        ArrayDeque <Vertex<E>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Vertex<E> current = queue.pop();
            if (!current.isVisited()){
                current.setVisited(true);
                System.out.println(current);
                queue.addAll(current.getChilds());
            }
        }
    }
}
