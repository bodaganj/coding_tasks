package com.coding.tasks.cracking.the.code.recursion_and_dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

   public static void main(String[] args) {
      System.out.println(subsets(new int[]{1, 2, 3}));
   }

   private static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> output = new ArrayList<>();
      output.add(Collections.emptyList());

      for (int num : nums) {
         List<List<Integer>> tmp = new ArrayList<>();
         for (List<Integer> list : output) {
            List<Integer> current = new ArrayList<>(list);
            current.add(num);
            tmp.add(current);
         }
         output.addAll(tmp);
      }

      return output;
   }
}
