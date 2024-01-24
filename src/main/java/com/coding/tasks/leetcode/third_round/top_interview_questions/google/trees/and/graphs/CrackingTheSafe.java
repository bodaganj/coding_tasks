package com.coding.tasks.leetcode.third_round.top_interview_questions.google.trees.and.graphs;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {

   private static String ans = null;

   public static void main(String[] args) {
      System.out.println(crackSafe(2, 2));
      System.out.println(crackSafe(1, 2));
      System.out.println(crackSafe(1, 3));
      System.out.println(crackSafe(1, 8));
      System.out.println(crackSafe(1, 10));
      System.out.println(crackSafe(2, 4));
   }

   public static String crackSafe(int n, int k) {
      ans = null;
      Set<String> set = new HashSet<>();
      Set<String> allCombinations = getAllCombinations(n, k);
      for (int j = 0; j < k; j++) {
         rec("" + j, set, allCombinations, n, k);
      }
      return ans;
   }

   private static void rec(String currentPass, Set<String> set, Set<String> allCombinations, int n, int k) {
      if (currentPass.length() > allCombinations.size() * n) {
         return;
      }

      if (ans != null && ans.length() < currentPass.length()) {
         return;
      }

      Set<String> newSet = new HashSet<>(set);
      if (currentPass.length() >= n) {
         String combina = currentPass.substring(currentPass.length() - n);
         if (allCombinations.contains(combina) && !set.contains(combina)) {
            newSet.add(combina);
            if (newSet.size() == allCombinations.size()) {
               ans = currentPass;
            }
         } else {
            return;
         }
      }

      for (int j = 0; j < k; j++) {
         rec(currentPass + j, newSet, allCombinations, n, k);
      }
   }

   private static Set<String> getAllCombinations(int n, int k) {
      Set<String> ans = new HashSet<>();
      for (int i = 0; i < k; i++) {
         comb("" + i, ans, n, k);
      }
      return ans;
   }

   private static void comb(String curr, Set<String> ans, int n, int k) {
      if (curr.length() == n) {
         ans.add(curr);
      } else {
         for (int i = 0; i < k; i++) {
            comb(curr + i, ans, n, k);
         }
      }
   }
}
