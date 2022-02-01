package com.coding.tasks.leetcode.top.interview.questions.hard.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LongestIncreasingPathInMatrix {

//   private static int max;

   public static void main(String[] args) {
      int[][] arr1 = new int[][]{
         {9, 9, 4},
         {6, 6, 8},
         {2, 1, 1}
      };
      int[][] arr2 = new int[][]{
         {7, 8, 9},
         {9, 7, 6},
         {7, 2, 3}
      };

      System.out.println(longestIncreasingPath(arr1));
      System.out.println(longestIncreasingPath(arr2));
      System.out.println(longestIncreasingPath(new int[][]{{1}}));
   }

   /**
    * Graph theory (bhs approach)
    */
   private static int longestIncreasingPath(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
         return 0;
      }

      int maxPath = 1;

      // 1 create dif predefined lists/maps
      List<List<Tuple>> rules = getRules(matrix);
      Map<Tuple, List<Tuple>> directionMapping = getDirectionMapping(rules);
      Queue<Tuple> queue = getNoInTuplesQueue(rules, matrix);

      Queue<Integer> currentPathSizeQueue = new LinkedList<>();
      int counter = 0;
      while (counter < queue.size()) {
         currentPathSizeQueue.offer(1);
         counter++;
      }

      // 2 bhs
      while (!queue.isEmpty()) {
         Tuple poll = queue.poll();
         Integer currentPathSize = currentPathSizeQueue.poll();

         if (directionMapping.containsKey(poll)) {
            currentPathSize += 1;
            maxPath = Math.max(maxPath, currentPathSize);
            for (Tuple tuple : directionMapping.get(poll)) {
               queue.offer(tuple);
               currentPathSizeQueue.offer(currentPathSize);
            }
         }
      }

      return maxPath;
   }

   private static Map<Tuple, List<Tuple>> getDirectionMapping(List<List<Tuple>> rules) {
      Map<Tuple, List<Tuple>> mapping = new HashMap<>();
      for (List<Tuple> rule : rules) {
         List<Tuple> list = mapping.getOrDefault(rule.get(0), new ArrayList<>());
         list.add(rule.get(1));
         mapping.put(rule.get(0), list);
      }

      return mapping;
   }

   private static Queue<Tuple> getNoInTuplesQueue(List<List<Tuple>> rules, int[][] matrix) {
      Set<Tuple> set = new HashSet<>();
      for (List<Tuple> rule : rules) {
         set.add(rule.get(1));
      }

      Queue<Tuple> noInTupleQueue = new LinkedList<>();
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
            Tuple tuple = new Tuple(i, j);
            if (!set.contains(tuple)) {
               noInTupleQueue.offer(tuple);
            }
         }
      }

      return noInTupleQueue;
   }

   private static List<List<Tuple>> getRules(int[][] matrix) {
      List<List<Tuple>> list = new ArrayList<>();

      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
            if (i + 1 < matrix.length && matrix[i][j] < matrix[i + 1][j]) {
               list.add(List.of(new Tuple(i, j), new Tuple(i + 1, j)));
            }
            if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) {
               list.add(List.of(new Tuple(i, j), new Tuple(i - 1, j)));
            }
            if (j + 1 < matrix[0].length && matrix[i][j] < matrix[i][j + 1]) {
               list.add(List.of(new Tuple(i, j), new Tuple(i, j + 1)));
            }
            if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) {
               list.add(List.of(new Tuple(i, j), new Tuple(i, j - 1)));
            }
         }
      }

      return list;
   }

   /**
    * Time Limit Exception
    */
//   private static int longestIncreasingPath(int[][] matrix) {
//      if (matrix == null || matrix.length == 0) {
//         return 0;
//      }
//
//      max = Integer.MIN_VALUE;
//
//      for (int i = 0; i < matrix.length; i++) {
//         for (int j = 0; j < matrix[0].length; j++) {
//            dfs(matrix, i, j, new HashSet<>(), null, 0);
//         }
//      }
//
//      return max;
//   }
//
//   private static void dfs(int[][] matrix, int i, int j, Set<Tuple> visited, Integer prevInteger, int currentPath) {
//      if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
//         return;
//      }
//
//      if (prevInteger == null || (!visited.contains(new Tuple(i, j)) && matrix[i][j] > prevInteger)) {
//         Set<Tuple> newSet = new HashSet<>(visited);
//         newSet.add(new Tuple(i, j));
//         currentPath++;
//
//         max = Math.max(max, currentPath);
//
//         dfs(matrix, i + 1, j, newSet, matrix[i][j], currentPath);
//         dfs(matrix, i - 1, j, newSet, matrix[i][j], currentPath);
//         dfs(matrix, i, j + 1, newSet, matrix[i][j], currentPath);
//         dfs(matrix, i, j - 1, newSet, matrix[i][j], currentPath);
//      }
//   }
//
   static class Tuple {

      private int i;
      private int j;

      public Tuple(int i, int j) {
         this.i = i;
         this.j = j;
      }

      public int getI() {
         return this.i;
      }

      public int getJ() {
         return this.j;
      }

      @Override
      public boolean equals(Object obj) {
         Tuple o = (Tuple) obj;
         return o.i == this.i && o.j == this.j;
      }

      @Override
      public int hashCode() {
         return this.i * 31 + this.j;
      }
   }

//   @Getter
//   @Setter
//   @EqualsAndHashCode
//   @AllArgsConstructor
//   static class Tuple {
//
//      private int i;
//      private int j;
//   }
}
