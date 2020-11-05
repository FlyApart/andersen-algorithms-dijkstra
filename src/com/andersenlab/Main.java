package com.andersenlab;

import java.util.Set;

public class Main {
  public static void main(String[] args) {
      Graph.Node node1 = new Graph.Node("1");
      Graph.Node node2 = new Graph.Node("2");
      Graph.Node node3 = new Graph.Node("3");
      Graph.Node node4 = new Graph.Node("4");
      Graph.Node node5 = new Graph.Node("5");
      Graph.Node node6 = new Graph.Node("6");

      node1.addNeighboringNodes(node2,2);
      node1.addNeighboringNodes(node3,1);
      node1.addNeighboringNodes(node4,4);

      node2.addNeighboringNodes(node4,7);
      node2.addNeighboringNodes(node5,3);

      node3.addNeighboringNodes(node4,5);
      node3.addNeighboringNodes(node5,10);
      node3.addNeighboringNodes(node6,4);

      node4.addNeighboringNodes(node6,5);

      node5.addNeighboringNodes(node6,4);

      Graph graph = new Graph(Set.of(node1,node2,node3,node4,node5,node6));
      graph.searcher(node1);
      System.out.println(graph.toString());
  }
}
