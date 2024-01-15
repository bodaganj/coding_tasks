package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{
         {7, 0},
         {7, 1},
         {4, 4},
         {5, 2},
         {6, 1},
         {5, 0},
      })));
   }

   public static int[][] reconstructQueue(int[][] people) {
      List<int[]> list = new LinkedList<>();
      Arrays.sort(people, (o1, o2) -> {
         if (o1[0] != o2[0]) {
            return o2[0] - o1[0];
         } else {
            return o1[1] - o2[1];
         }
      });

      for (int[] person : people) {
         list.add(person[1], person);
      }
      int[][] ans = new int[people.length][people[0].length];
      for (int i = 0; i < list.size(); i++) {
         ans[i] = list.get(i);
      }
      return ans;
   }
}
