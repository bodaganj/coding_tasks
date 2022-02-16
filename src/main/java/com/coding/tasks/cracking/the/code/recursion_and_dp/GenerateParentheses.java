package com.coding.tasks.cracking.the.code.recursion_and_dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

   public static void main(String[] args) {
      System.out.println(generateParenthesis(3));
   }

   private static List<String> generateParenthesis(int n) {
      List<String> ans = new ArrayList<>();
      rec("(", 1, 0, n, ans);
      return ans;
   }

   private static void rec(String sb, int amountOfOpen, int amountOfClose, int n, List<String> ans) {
      if (amountOfOpen == n && amountOfClose == n) {
         ans.add(sb);
         return;
      }

      if (amountOfOpen < n) {
         rec(sb + "(", amountOfOpen + 1, amountOfClose, n, ans);
      }
      if (amountOfClose < amountOfOpen) {
         rec(sb + ")", amountOfOpen, amountOfClose + 1, n, ans);
      }
   }
}
