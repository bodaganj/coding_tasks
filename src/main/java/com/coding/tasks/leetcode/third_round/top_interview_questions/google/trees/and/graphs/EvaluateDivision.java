package com.coding.tasks.leetcode.third_round.top_interview_questions.google.trees.and.graphs;

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
      System.out.println(Arrays.toString(calcEquation(
         List.of(List.of("a", "b"), List.of("b", "c")),
         new double[]{2.0, 3.0},
         List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x")) // 6, 0.5, -1, 1, -1
      )));

      System.out.println(Arrays.toString(calcEquation(
         List.of(List.of("x1", "x2"), List.of("x2", "x3"), List.of("x3", "x4"), List.of("x4", "x5")),
         new double[]{3.0, 4.0, 5.0, 6.0},
         List.of(
            List.of("x1", "x5"),
            List.of("x5", "x2"),
            List.of("x2", "x4"),
            List.of("x2", "x2"),
            List.of("x2", "x9"),
            List.of("x9", "x9")
         ) // 360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000
      )));
   }

   public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      double[] ans = new double[queries.size()];
      Arrays.fill(ans, -1.0);

      Map<String, Map<String, Double>> mapping = new HashMap<>();
      for (int i = 0; i < equations.size(); i++) {
         List<String> equation = equations.get(i);
         if (mapping.containsKey(equation.get(0))) {
            Map<String, Double> map = mapping.get(equation.get(0));
            map.put(equation.get(1), values[i]);
         } else {
            Map<String, Double> tmp = new HashMap<>();
            tmp.put(equation.get(1), values[i]);
            mapping.put(equation.get(0), tmp);
         }

         if (mapping.containsKey(equation.get(1))) {
            Map<String, Double> map = mapping.get(equation.get(1));
            map.put(equation.get(0), 1 / values[i]);
         } else {
            Map<String, Double> tmp = new HashMap<>();
            tmp.put(equation.get(0), 1 / values[i]);
            mapping.put(equation.get(1), tmp);
         }
      }

      for (int i = 0; i < queries.size(); i++) {
         List<String> query = queries.get(i);
         if (!mapping.containsKey(query.get(0)) || !mapping.containsKey(query.get(1))) {
            ans[i] = -1.0;
         } else if (query.get(0).equals(query.get(1))) {
            ans[i] = 1.0;
         } else {
            if (mapping.get(query.get(0)).containsKey(query.get(1))) {
               ans[i] = mapping.get(query.get(0)).get(query.get(1));
            } else {
               // calculate
               Set<String> set = new HashSet<>();
               set.add(query.get(0));
               Queue<Map<String, Double>> queue = new LinkedList<>();
               queue.add(mapping.get(query.get(0)));
               while (!queue.isEmpty()) {
                  Map<String, Double> poll = queue.poll();
                  for (Map.Entry<String, Double> entry : poll.entrySet()) {
                     if (entry.getKey().equals(query.get(1))) {
                        ans[i] = entry.getValue();
                        queue.clear();
                        break;
                     }

                     set.add(entry.getKey());
                     Map<String, Double> map = mapping.get(entry.getKey());
                     for (Map.Entry<String, Double> ent : map.entrySet()) {
                        if (!set.contains(ent.getKey())) {
                           queue.add(Map.of(ent.getKey(), ent.getValue() * entry.getValue()));
                        }
                     }
                  }
               }
            }
         }
      }

      return ans;
   }
}
