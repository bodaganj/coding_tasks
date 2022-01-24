package com.coding.tasks.cracking.the.code.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RoutBetweenNodes {

   public static void main(String[] args) {
      int[][] array1 = new int[][]{
         {1, 2},
         {3},
         {3},
         {}
      };

      List<List<Integer>> lists1 = allPathsSourceTarget(array1);
      System.out.println(lists1);

      int[][] array2 = new int[][]{
         {4, 3, 1},
         {3, 2, 4},
         {3},
         {4},
         {}
      };

      List<List<Integer>> lists2 = allPathsSourceTarget(array2);
      System.out.println(lists2);
   }

   private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      if (graph == null) {
         return null;
      }

      int expectedNode = graph.length - 1;
      List<List<Integer>> result = new ArrayList<>();

      Queue<Map<Integer, List<Integer>>> queue = new LinkedList<>(); // Space O(n)
      List<Integer> list = new ArrayList<>(); // Space O(n)
      list.add(0);
      queue.add(Map.of(0, list));

      while (!queue.isEmpty()) {  // Time O(number_of_edges)
         Map<Integer, List<Integer>> poll = queue.poll();

         if (poll.containsKey(expectedNode)) {
            result.add(poll.get(expectedNode));
         } else {
            Integer node = poll.keySet().stream().findFirst().get();
            List<Integer> integers = poll.get(node);
            for (int i = 0; i < graph[node].length; i++) {
               List<Integer> newList = new ArrayList<>(integers);
               newList.add(graph[node][i]);
               queue.add(Map.of(graph[node][i], newList));
            }
         }
      }

      return result;
   }
}
