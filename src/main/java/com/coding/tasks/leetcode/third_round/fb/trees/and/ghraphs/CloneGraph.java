package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {

   public static Node cloneGraph(Node node) {
      if (node == null) {
         return null;
      }
      Map<Integer, Node> allNodes = getAllNodes(node);
      assignAllNeighbors(node, allNodes);
      return allNodes.get(node.val);
   }

   private static Map<Integer, Node> getAllNodes(Node node) {
      Map<Integer, Node> map = new HashMap<>();
      Set<Integer> seen = new HashSet<>();
      Queue<Node> queue = new LinkedList<>();
      queue.add(node);
      while (!queue.isEmpty()) {
         int size = queue.size();
         while (size > 0) {
            Node poll = queue.poll();
            if (!seen.contains(poll.val)) {
               map.put(poll.val, new Node(poll.val, new ArrayList<>()));
               seen.add(poll.val);
            }
            for (Node neighbor : poll.neighbors) {
               if (!seen.contains(neighbor.val)) {
                  map.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
                  seen.add(neighbor.val);
                  queue.add(neighbor);
               }
            }
            size--;
         }
      }
      return map;
      // create node with empty arraylist
   }

   private static void assignAllNeighbors(Node node, Map<Integer, Node> allNodes) {
      Set<Integer> seen = new HashSet<>();
      Queue<Node> queue = new LinkedList<>();
      queue.add(node);
      seen.add(node.val);
      while (!queue.isEmpty()) {
         int size = queue.size();
         while (size > 0) {
            Node poll = queue.poll();
            for (Node neighbor : poll.neighbors) {
               allNodes.get(poll.val).neighbors.add(allNodes.get(neighbor.val));
               if (!seen.contains(neighbor.val)) {
                  queue.add(neighbor);
                  seen.add(neighbor.val);
               }
            }
            size--;
         }
      }
   }

   static class Node {

      public int val;
      public List<Node> neighbors;

      public Node() {
         val = 0;
         neighbors = new ArrayList<>();
      }

      public Node(int _val) {
         val = _val;
         neighbors = new ArrayList<>();
      }

      public Node(int _val, ArrayList<Node> _neighbors) {
         val = _val;
         neighbors = _neighbors;
      }
   }
}
