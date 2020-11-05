package com.andersenlab;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

  Set<Node> nodes = new HashSet<>();

  public Graph(Set<Node> nodes) {
    this.nodes.addAll(nodes);
  }

  public void searcher(Node startNode) {
    Set<Node> pathsFound = new HashSet<>();
    Set<Node> rawNodes = new HashSet<>();
    startNode.setMinDistance(0);
    rawNodes.add(startNode);

    while (!rawNodes.isEmpty()) {
      Node currentNode = searchNearestNode(rawNodes);
      for (Map.Entry<Node, Integer> nearestNodeEntry :
          currentNode.getNeighboringNodes().entrySet()) {

        int path = currentNode.getMinDistance() + nearestNodeEntry.getValue();
        Node nearestNode = nearestNodeEntry.getKey();

        if (!pathsFound.contains(nearestNode)) {
          if (path < nearestNode.getMinDistance()) {
            nearestNode.setMinDistance(path);
          }
          rawNodes.add(nearestNodeEntry.getKey());
        }
      }
      rawNodes.remove(currentNode);
      pathsFound.add(currentNode);
    }
  }

  public Node searchNearestNode(Set<Node> pathsFound) {
    Node nearestNode = null;
    int minDistance = Integer.MAX_VALUE;
    for (Node node : pathsFound) {
      if (node.getMinDistance() < minDistance) {
        nearestNode = node;
        minDistance = node.getMinDistance();
      }
    }
    return nearestNode;
  }

  @Override
  public String toString() {
    return "Graph{" + "nodes=" + nodes + '}';
  }

  static class Node {
    String name;
    int minDistance;
    Map<Node, Integer> neighboringNodes;

    public Node(String name) {
      this.name = name;
      this.minDistance = Integer.MAX_VALUE;
      this.neighboringNodes = new HashMap<>();
    }

    public void addNeighboringNodes(Node node, int distance) {
      neighboringNodes.put(node, distance);
    }

    public int getMinDistance() {
      return minDistance;
    }

    public void setMinDistance(int minDistance) {
      this.minDistance = minDistance;
    }

    public Map<Node, Integer> getNeighboringNodes() {
      return neighboringNodes;
    }

    @Override
    public String toString() {
      return "Node{" + "name='" + name + '\'' + ", minDistance=" + minDistance + '}';
    }
  }
}
