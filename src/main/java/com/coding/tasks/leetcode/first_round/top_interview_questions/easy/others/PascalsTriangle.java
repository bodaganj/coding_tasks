package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.others;

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

      for (int i = 1; i < numRows; i++) {
         List<Integer> tmp = new ArrayList<>();
         tmp.add(1);

         List<Integer> last = ans.get(ans.size() - 1);
         for (int index = 1; index < last.size(); index++) {
            tmp.add(last.get(index - 1) + last.get(index));
         }

         tmp.add(1);

         ans.add(tmp);
      }

      return ans;
   }
}
