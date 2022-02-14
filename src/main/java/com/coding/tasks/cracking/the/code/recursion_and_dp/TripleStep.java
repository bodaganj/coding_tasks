package com.coding.tasks.cracking.the.code.recursion_and_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripleStep {

   private static Set<List<Integer>> combinations;

   public static void main(String[] args) {
      System.out.println(getDifferentWays(3));
   }

   private static int getDifferentWays(int n) {
      combinations = new HashSet<>();
      claim(n, new ArrayList<>());
      return combinations.size();
   }

   private static void claim(int n, List<Integer> currentSteps) {
      if (n == 0) {
         combinations.add(currentSteps);
      } else {
         if (n - 1 >= 0) {
            List<Integer> tmp = new ArrayList<>(currentSteps);
            tmp.add(1);
            claim(n - 1, tmp);
         }
         if (n - 2 >= 0) {
            List<Integer> tmp = new ArrayList<>(currentSteps);
            tmp.add(2);
            claim(n - 2, tmp);
         }
      }
   }
}
