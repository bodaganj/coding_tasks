package com.coding.tasks.leetcode.second_round.google.trees_and_graphs;

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
      Set<String> distinct = new HashSet<>();
      for (List<String> equation : equations) {
         distinct.add(equation.get(0));
         distinct.add(equation.get(1));
      }

      Map<String, Map<String, Double>> mapping = getMapping(equations, values);
      double[] ans = new double[queries.size()];
      for (int index = 0; index < queries.size(); index++) {
         Set<String> visited = new HashSet<>();
         Queue<String> stringsQueue = new LinkedList<>();
         Queue<Double> doubleQueue = new LinkedList<>();

         String first = queries.get(index).get(0);
         String second = queries.get(index).get(1);

         if (!distinct.contains(first) || !distinct.contains(second)) {
            ans[index] = -1.0;
            continue;
         }

         for (Map.Entry<String, Double> entry : mapping.get(first).entrySet()) {
            stringsQueue.offer(entry.getKey());
            visited.add(entry.getKey());
            doubleQueue.offer(entry.getValue());
         }

         boolean flag = true;
         while (!stringsQueue.isEmpty() && flag) {
            int size = stringsQueue.size();
            while (size > 0) {
               String poll = stringsQueue.poll();
               Double value = doubleQueue.poll();
               if (poll.equals(second)) {
                  ans[index] = value;
                  flag = false;
                  break;
               } else {
                  for (Map.Entry<String, Double> entry : mapping.get(poll).entrySet()) {
                     if (!visited.contains(entry.getKey())) {
                        stringsQueue.offer(entry.getKey());
                        visited.add(entry.getKey());
                        doubleQueue.offer(entry.getValue() * value);
                     }
                  }
               }
               size--;
            }
         }

         if (flag) {
            ans[index] = -1.0;
         }
      }

      return ans;
   }

   private static Map<String, Map<String, Double>> getMapping(List<List<String>> equations, double[] values) {
      Map<String, Map<String, Double>> mapping = new HashMap<>();
      int i = 0;
      while (i < equations.size()) {
         Map<String, Double> map1 = mapping.getOrDefault(equations.get(i).get(0), new HashMap<>());
         map1.put(equations.get(i).get(1), values[i]);
         mapping.put(equations.get(i).get(0), map1);

         Map<String, Double> map2 = mapping.getOrDefault(equations.get(i).get(1), new HashMap<>());
         map2.put(equations.get(i).get(0), 1 / values[i]);
         mapping.put(equations.get(i).get(1), map2);

         i++;
      }
      return mapping;
   }
}
