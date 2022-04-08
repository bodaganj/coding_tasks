package com.coding.tasks.leetcode.first_round.amazon.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

   public static void main(String[] args) {
      System.out.println(generateParenthesis(2));
      System.out.println(generateParenthesis(3));
   }

   private static List<String> generateParenthesis(int n) {
      List<String> ans = new ArrayList<>();
      rec("", ans, n, 0, 0);
      return ans;
   }

   private static void rec(String current, List<String> ans, int n, int amountOpen, int amountClose) {
      if (amountOpen == n && amountClose == n) {
         ans.add(current);
         return;
      }

      if (amountOpen < n) {
         rec(current + "(", ans, n, amountOpen + 1, amountClose);
      }
      if (amountClose < n && amountClose < amountOpen) {
         rec(current + ")", ans, n, amountOpen, amountClose + 1);
      }
   }
}
