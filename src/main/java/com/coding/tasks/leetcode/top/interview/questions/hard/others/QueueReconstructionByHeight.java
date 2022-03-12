package com.coding.tasks.leetcode.top.interview.questions.hard.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QueueReconstructionByHeight {

   public static void main(String[] args) {
//      System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{
//         {7, 0},
//         {4, 4},
//         {7, 1},
//         {5, 0},
//         {6, 1},
//         {5, 2}
//      })));
//
//      System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{
//         {6, 0},
//         {5, 0},
//         {4, 0},
//         {3, 2},
//         {2, 2},
//         {1, 4}
//      })));

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

      int position = 0;
      while (ans[people.length - 1][0] == 0 && ans[people.length - 1][1] == 0) {
         int[] toBeAdded = new int[1];
         int minHeight = Integer.MAX_VALUE;

         for (int[] person : people) {
            if (seen.isEmpty() || !seen.contains(person)) {
               // get people with i <= position and minimum height
               if (person[1] <= position && person[0] < minHeight) {
                  toBeAdded = person;
                  minHeight = person[0];
               }
            }
         }

         seen.add(toBeAdded);
         ans[position] = toBeAdded;
         position++;
      }

      return ans;
   }
}
