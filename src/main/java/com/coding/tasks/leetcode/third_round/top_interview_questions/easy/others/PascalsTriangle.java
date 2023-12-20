package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.others;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

   public static void main(String[] args) {
      System.out.println(generate(5));
   }

   public static List<List<Integer>> generate(int numRows) {
      List<List<Integer>> ans = new ArrayList<>();
      ans.add(List.of(1));
      for (int i = 1; i < numRows; i++) {
         List<Integer> tmp = new ArrayList<>();
         tmp.add(1);
         List<Integer> prevList = ans.get(i - 1);
         for (int j = 0; j < prevList.size() - 1; j++) {
            tmp.add(prevList.get(j) + prevList.get(j + 1));
         }
         tmp.add(1);
         ans.add(tmp);
      }
      return ans;
   }
}
