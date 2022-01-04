package com.coding.tasks.leetcode.google.interview_process;

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

   // Time O(NlogN)
   // Space O(N)
   // best way to solve (DP + TreeMap tricks)
   private static int oddEvenJumps(int[] arr) {
      int initialLength = arr.length;

      // the last index is always "good index"
      int result = 1;

      // array which says if the current index is "good" one, because we are starting with odd step each try
      boolean[] oddBoolArray = new boolean[initialLength];
      // array for even steps. Based on this array we are getting the odd array values
      boolean[] evenBoolArray = new boolean[initialLength];
      oddBoolArray[initialLength - 1] = evenBoolArray[initialLength - 1] = true;

      // TreeMap is a very handy structure here (ceilingEntry and floorEntry methods!!!!! are the magic here)
      TreeMap<Integer, Integer> digitToIndexMapping = new TreeMap<>();
      // add array values which were checked here
      digitToIndexMapping.put(arr[initialLength - 1], initialLength - 1);

      for (int i = initialLength - 2; i >= 0; --i) {
         // do we have ability to make ODD jump and to which index
         Map.Entry<Integer, Integer> hi = digitToIndexMapping.ceilingEntry(arr[i]);
         // do we have ability to make EVEN jump and to which index
         Map.Entry<Integer, Integer> lo = digitToIndexMapping.floorEntry(arr[i]);

         if (hi != null) {
            // if we are able to make odd jump, then check whether the next index where we will make even jump from is a "good index"
            oddBoolArray[i] = evenBoolArray[hi.getValue()];
         }
         if (lo != null) {
            // if we are able to make even jump, then check whether the next index where we will make odd jump from is a "good index"
            evenBoolArray[i] = oddBoolArray[lo.getValue()];
         }

         // if the current index is a "good index" in terms of odd jump (because this is the first one) then we are HAPPY
         if (oddBoolArray[i]) {
            result++;
         }

         // add checked value and index to map
         digitToIndexMapping.put(arr[i], i);
      }
      return result;
   }

   // recursion way will fail with Time Limit error
   // same as brut force method (Time Limit)
//   private static int oddEvenJumps(int[] arr) {
//      int totalCount = 1;
//      List<Integer> input = Arrays.stream(arr).boxed().collect(Collectors.toList());
//
//      for (int index = 0; index < input.size() - 1; index++) {
//         int jumpCounter = 1;
//         totalCount = totalCount + recursion(input.subList(index, input.size()), jumpCounter);
//      }
//      return totalCount;
//   }
//
//   private static int recursion(List<Integer> input, int jumpCounter) {
//      if (input.size() == 1) {
//         return 1;
//      }
//      List<Integer> listToTheLeft = input.subList(1, input.size());
//
//      if (jumpCounter % 2 == 0) {
//         List<Integer> collect = listToTheLeft.stream().filter(value -> value <= input.get(0)).collect(Collectors.toList());
//         if (collect.isEmpty()) {
//            return 0;
//         }
//         Integer maxValue = Collections.max(collect);
//         int indexOf = listToTheLeft.indexOf(maxValue);
//         jumpCounter++;
//         return recursion(listToTheLeft.subList(indexOf, input.size() - 1), jumpCounter);
//      } else {
//         List<Integer> collect = listToTheLeft.stream().filter(value -> value >= input.get(0)).collect(Collectors.toList());
//         if (collect.isEmpty()) {
//            return 0;
//         }
//         Integer minValue = Collections.min(collect);
//         int indexOf = listToTheLeft.indexOf(minValue);
//         jumpCounter++;
//         return recursion(listToTheLeft.subList(indexOf, input.size() - 1), jumpCounter);
//      }
//   }
}
