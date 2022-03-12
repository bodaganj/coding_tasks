package com.coding.tasks.leetcode.top.interview.questions.hard.others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class QueueReconstructionByHeight {

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{
         {7, 0},
         {4, 4},
         {7, 1},
         {5, 0},
         {6, 1},
         {5, 2}
      })));

      System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{
         {6, 0},
         {5, 0},
         {4, 0},
         {3, 2},
         {2, 2},
         {1, 4}
      })));

      System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{
         {7, 0},
         {4, 4},
         {7, 1},
         {5, 0},
         {6, 1},
         {5, 2}
      })));
   }

   private static int[][] reconstructQueue(int[][] people) {
      int[][] ans = new int[people.length][2];
      Set<int[]> seen = new HashSet<>();

      for (int i = 0; i < people.length; i++) {
         int finalI = i;
         int[] toBeAdded = Arrays.stream(people)
                                 .filter(p -> !seen.contains(p))
                                 .filter(p -> p[1] <= finalI)
                                 .filter(p -> p[1] == seen.stream().filter(s -> s[0] >= p[0]).count())
                                 .min(Comparator.comparingInt(p -> p[0]))
                                 .get();

         seen.add(toBeAdded);
         ans[i] = toBeAdded;
      }

      return ans;
   }
}
