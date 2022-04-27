package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

   public static void main(String[] args) {
      System.out.println(generateParenthesis(2));
      System.out.println(generateParenthesis(3));
   }

   private static List<String> generateParenthesis(int n) {
      List<String> ans = new ArrayList<>();
      rec(0, 0, "", n, ans);
      return ans;
   }

   private static void rec(int open, int close, String current, int n, List<String> ans) {
      if (close == n) {
         ans.add(current);
         return;
      }
      if (open < n) {
         rec(open + 1, close, current + "(", n, ans);
      }
      if (close < open) {
         rec(open, close + 1, current + ")", n, ans);
      }
   }
}
