package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.others;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

   public static void main(String[] args) {
      System.out.println(generate(3));
      System.out.println(generate(5));
   }

   private static List<List<Integer>> generate(int numRows) {
      List<List<Integer>> ans = new ArrayList<>();
      ans.add(List.of(1));
      if (numRows == 1) {
         return ans;
      }

      for (int i = 2; i <= numRows; i++) {
         List<Integer> list = new ArrayList<>();
         list.add(1);

         List<Integer> lastList = ans.get(ans.size() - 1);
         for (int j = 0; j < lastList.size() - 1; j++) {
            list.add(lastList.get(j) + lastList.get(j + 1));
         }

         list.add(1);
         ans.add(list);
      }

      return ans;
   }
}
