package com.coding.tasks.leetcode.first_round.google.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

   public static void main(String[] args) {
      System.out.println(generateParenthesis(2));
      System.out.println(generateParenthesis(3));
   }

   private static List<String> generateParenthesis(int n) {
      List<String> ans = new ArrayList<>();
      rec(new StringBuilder(), ans, n, 0, 0);
      return ans;
   }

   private static void rec(StringBuilder current, List<String> ans, int n, int amountOpen, int amountClose) {
      if (amountOpen == n && amountClose == n) {
         ans.add(current.toString());
         return;
      }

      if (amountOpen < n) {
         current.append("(");
         rec(current, ans, n, amountOpen + 1, amountClose);
         current.deleteCharAt(current.length() - 1);
      }
      if (amountClose < n && amountClose < amountOpen) {
         current.append(")");
         rec(current, ans, n, amountOpen, amountClose + 1);
         current.deleteCharAt(current.length() - 1);
      }
   }
}
