package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

   public static void main(String[] args) {
      System.out.println(generateParenthesis(3));
   }

   public static List<String> generateParenthesis(int n) {
      List<String> ans = new ArrayList<>();
      rec(n, n, "", ans);
      return ans;
   }

   private static void rec(int open, int close, String res, List<String> ans) {
      if (open == 0 && close == 0) {
         ans.add(res);
      } else {
         if (open > 0) {
            rec(open - 1, close, res + "(", ans);
         }
         if (close > 0 && close > open) {
            rec(open, close - 1, res + ")", ans);
         }
      }
   }
}
