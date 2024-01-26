package com.coding.tasks.leetcode.third_round.google.interview.process;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {

   public static void main(String[] args) {

   }

   public static int oddEvenJumps(int[] arr) {
      int length = arr.length;
      boolean[] odd = new boolean[length];
      boolean[] even = new boolean[length];
      odd[length - 1] = even[length - 1] = true;

      TreeMap<Integer, Integer> map = new TreeMap();
      map.put(arr[length - 1], length - 1);

      for (int i = length - 2; i >= 0; i--) {
         Map.Entry<Integer, Integer> oddEntry = map.ceilingEntry(arr[i]);
         Map.Entry<Integer, Integer> evenEntry = map.floorEntry(arr[i]);

         if (oddEntry != null && even[oddEntry.getValue()]) {
            odd[i] = true;
         }
         if (evenEntry != null && odd[evenEntry.getValue()]) {
            even[i] = true;
         }

         map.put(arr[i], i);
      }

      int count = 0;
      for (boolean b : odd) {
         if (b) {
            count++;
         }
      }
      return count;
   }
}
