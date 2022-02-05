package com.coding.tasks.leetcode.google.trees_and_graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EvaluateDivision {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(calcEquation(List.of(List.of("a", "b"), List.of("b", "c")),
                                                      new double[]{2.0, 3.0},
                                                      List.of(List.of("a", "c"),
                                                              List.of("b", "a"),
                                                              List.of("a", "e"),
                                                              List.of("a", "a"),
                                                              List.of("x", "x")))));

      System.out.println(Arrays.toString(calcEquation(List.of(List.of("a", "b"), List.of("c", "d")),
                                                      new double[]{1.0, 1.0},
                                                      List.of(List.of("a", "c"),
                                                              List.of("b", "d"),
                                                              List.of("b", "a"),
                                                              List.of("d", "c")))));
   }

   private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      Map<String, Map<String, Double>> mapping = new HashMap<>();

      for (int i = 0; i < equations.size(); i++) {
         List<String> equation = equations.get(i);
         String first = equation.get(0);
         String second = equation.get(1);

         // add mapping for first str
         Map<String, Double> firstMap = mapping.getOrDefault(first, new HashMap<>());
         firstMap.put(second, values[i]);
         mapping.put(first, firstMap);

         // add mapping for second str
         Map<String, Double> secondMap = mapping.getOrDefault(second, new HashMap<>());
         secondMap.put(first, 1 / values[i]);
         mapping.put(second, secondMap);
      }

      double[] result = new double[queries.size()];
      Arrays.fill(result, -1.0);

      for (int i = 0; i < queries.size(); i++) {
         List<String> query = queries.get(i);

         String first = query.get(0);
         String second = query.get(1);

         if (mapping.containsKey(first) && mapping.containsKey(second)) {
            if (first.equals(second)) {
               result[i] = 1.0;
            } else {
               Queue<String> stringQueue = new LinkedList<>();
               stringQueue.offer(first);

               Queue<Double> resultQueue = new LinkedList<>();
               resultQueue.offer(1.0);

               Set<String> visited = new HashSet<>();
               visited.add(first);

               while (!stringQueue.isEmpty()) {
                  String poll = stringQueue.poll();
                  Double doublePoll = resultQueue.poll();

                  if (poll.equals(second)) {
                     result[i] = doublePoll;
                     break;
                  } else {
                     Map<String, Double> map = mapping.get(poll);
                     for (String key : map.keySet()) {
                        if (!visited.contains(key)) {
                           stringQueue.offer(key);
                           resultQueue.offer(doublePoll * map.get(key));
                           visited.add(key);
                        }
                     }
                  }
               }
            }
         }
      }

      return result;
   }
}
