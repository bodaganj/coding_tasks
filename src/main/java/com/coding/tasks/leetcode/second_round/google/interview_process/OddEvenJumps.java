package com.coding.tasks.leetcode.second_round.google.interview_process;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {

   public static void main(String[] args) {
      int[] first = new int[]{10, 13, 12, 14, 15};
      int[] second = new int[]{2, 3, 1, 1, 4};
      int[] third = new int[]{5, 1, 3, 4, 2};

      System.out.println(oddEvenJumps(first));
      System.out.println(oddEvenJumps(second));
      System.out.println(oddEvenJumps(third));
   }

   private static int oddEvenJumps(int[] arr) {
      int ans = 1;
      boolean[] oddFlag = new boolean[arr.length];
      boolean[] evenFlag = new boolean[arr.length];
      oddFlag[oddFlag.length - 1] = true;
      evenFlag[evenFlag.length - 1] = true;

      for (int i = arr.length - 2; i >= 0; i--) {
         TreeMap<Integer, Integer> tree = new TreeMap<>();
         for (int j = i + 1; j < arr.length; j++) {
            tree.put(arr[j], j);
         }

         Map.Entry<Integer, Integer> oddEntry = tree.ceilingEntry(arr[i]);
         if (oddEntry != null && evenFlag[oddEntry.getValue()]) {
            oddFlag[i] = true;
            ans++;
         }

         Map.Entry<Integer, Integer> evenEntry = tree.floorEntry(arr[i]);
         if (evenEntry != null && oddFlag[evenEntry.getValue()]) {
            evenFlag[i] = true;
         }
      }
      return ans;
   }
}
