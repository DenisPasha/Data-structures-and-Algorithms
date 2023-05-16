package org.example.algorithms.graph_algorithms.dijkstra;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dijkstra<E> {

    public void calculateShortestPath(Node<E> source){

        source.setDistance(0);

        Queue<Node<E>> nonVisitedNodes = new PriorityQueue<>(Collections.singleton(source));

        while (!nonVisitedNodes.isEmpty()){
            Node<E> current = nonVisitedNodes.poll();
            Map<Node<E>, Integer> adjacentNodes = current.getAdjacentNodes();

            for (Map.Entry<Node<E>, Integer> entry : adjacentNodes.entrySet()) {
                    evaluateDistanceAndPath(entry.getKey() ,entry.getValue() , current);
                    nonVisitedNodes.add(entry.getKey());

            }

        }
    }

    private void evaluateDistanceAndPath(Node<E> adjacentNode, Integer weight, Node<E> current) {
        int newDistance = current.getDistance() + weight;
        if (newDistance < adjacentNode.getDistance()){
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(Stream.concat(current.getShortestPath().stream() ,Stream.of(current)).toList());

        }
    }
    public void printPaths(List<Node<E>> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(Node::getName).map(Objects::toString)
                    .collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getName(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getName(), node.getDistance()))
            );
        });
    }

}
