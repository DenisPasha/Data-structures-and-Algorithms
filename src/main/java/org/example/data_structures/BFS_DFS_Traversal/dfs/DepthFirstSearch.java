package org.example.data_structures.BFS_DFS_Traversal.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch<E> {

    private final Vertex<E> root;

    public DepthFirstSearch(Vertex<E> root) {
        this.root = root;
    }

    public void traverse(Vertex<Integer> startVertex){

        ArrayDeque<Vertex<E>> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Vertex<E> current = stack.pop();

            if (!current.isVisited()){
                System.out.println(current);
                current.setVisited(true);
                List<Vertex<E>> reordered= new ArrayList<>();

                for (int i = current.getChilds().size()-1; i >=0 ; i--) {
                    reordered.add(current.getChilds().get(i));
                }
               reordered.forEach(stack::push);
            }
        }

    }
}
