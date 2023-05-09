package org.example.data_structures.BFS_DFS_Traversal.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex <E>{

    private final E data;
    private boolean isVisited;
    private List<Vertex<E>> childs;

    public Vertex(E data) {
        this.data = data;
        this.isVisited = false;
        this.childs = new ArrayList<>();
    }

    public E getData() {
        return data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Vertex<E>> getChilds() {
        return childs;
    }

    public void setChilds(List<Vertex<E>> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
