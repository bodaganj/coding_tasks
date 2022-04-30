package com.coding.tasks.leetcode.second_round.google.recursion;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumber2 {

   private static List<String> same = List.of("1", "8", "0", "6", "9");

   public static void main(String[] args) {
      System.out.println(findStrobogrammatic(1));
      System.out.println(findStrobogrammatic(2));
      System.out.println(findStrobogrammatic(3));
   }

   private static List<String> findStrobogrammatic(int n) {
      List<String> ans = new ArrayList<>();
      String[] current = new String[n];
      rec(current, 0, n, ans);
      return ans;
   }

   private static void rec(String[] current, int index, int n, List<String> ans) {
      if (index >= n - index) {
         ans.add(String.join("", current));
      } else {
         if (index + 1 < n - index) {
            for (String s : same) {
               if (index == 0 && s.equals("0")) {
                  continue;
               }
               if (s.equals("6")) {
                  current[n - index - 1] = "9";
               } else if (s.equals("9")) {
                  current[n - index - 1] = "6";
               } else {
                  current[n - index - 1] = s;
               }
               current[index] = s;
               rec(current, index + 1, n, ans);
            }
         } else {
            for (String s : same) {
               if (!s.equals("6") && !s.equals("9")) {
                  current[index] = s;
                  rec(current, index + 1, n, ans);
               }
            }
         }
      }
   }
}
