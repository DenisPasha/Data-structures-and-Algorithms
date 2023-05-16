package org.example.algorithms.graph_algorithms.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node<E> implements Comparable<Node <E>> {

    private String name;
    private Integer distance = Integer.MAX_VALUE;
    private List<Node<E>> shortestPath = new LinkedList<>();
    private Map<Node<E> ,Integer > adjacentNodes = new HashMap<>();

    public Node(String name, Integer distance, List<Node<E>> shortestPath, Map<Node<E>, Integer> adjacentNodes) {
        this.name = name;
        this.distance = distance;
        this.shortestPath = shortestPath;
        this.adjacentNodes = adjacentNodes;
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node<E>> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node<E>> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Map<Node<E>, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node<E>, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public void addAdjacentNode(Node<E> adjacentNode , int weight){
        adjacentNodes.put(adjacentNode , weight);
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.distance , node.getDistance());
    }

}
