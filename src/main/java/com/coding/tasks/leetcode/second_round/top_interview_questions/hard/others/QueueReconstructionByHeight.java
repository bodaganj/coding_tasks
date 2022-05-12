package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
   }

   private static int[][] reconstructQueue(int[][] people) {
      Comparator<int[]> byFirst = Comparator.comparingInt(a -> a[0]);
      Comparator<int[]> bySecond = Comparator.comparingInt(a -> a[1]);
      Arrays.sort(people, byFirst.thenComparing(bySecond));

      List<int[]> peopleList = new ArrayList<>(Arrays.asList(people));
      List<int[]> ans = new ArrayList<>();
      int i = 0;
      while (!peopleList.isEmpty()) {
         int[] person = peopleList.get(i);
         if (person[1] <= ans.size()) {
            int amount = 0;
            for (int[] p : ans) {
               if (p[0] >= person[0]) {
                  amount++;
               }
            }
            if (amount == person[1]) {
               ans.add(person);
               peopleList.remove(i);
               i = 0;
            } else {
               i++;
            }
         } else {
            i++;
         }
      }

      for (int j = 0; j < ans.size(); j++) {
         people[j] = ans.get(j);
      }

      return people;
   }
}
