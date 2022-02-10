package com.coding.tasks.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

   public static void main(String[] args) {
      System.out.println(subsets(new int[]{1, 2, 3}));
   }

   // O(N * 2^N)
   // N - size of nums
   // [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]
   private static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(Collections.emptyList());

      List<List<Integer>> current;
      for (int num : nums) {
         current = new ArrayList<>();
         for (List<Integer> list : result) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(num);
            current.add(newList);
         }
         result.addAll(current);
      }

      return result;
   }
}
