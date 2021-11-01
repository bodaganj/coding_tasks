package com.coding.tasks.leetcode.google.interview_process;

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

   // recursion way will fail with Time Limit error
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

   // Time O(NlogN)
   // Space O(N)
   // better way to solve
   private static int oddEvenJumps(int[] arr) {
      int lengthOfInitialArray = arr.length;
      int result = 1;

      boolean[] higherBoolArray = new boolean[lengthOfInitialArray];
      boolean[] lowerBoolArray = new boolean[lengthOfInitialArray];
      higherBoolArray[lengthOfInitialArray - 1] = lowerBoolArray[lengthOfInitialArray - 1] = true;

      TreeMap<Integer, Integer> digitToIndexMapping = new TreeMap<>();
      digitToIndexMapping.put(arr[lengthOfInitialArray - 1], lengthOfInitialArray - 1);

      for (int i = lengthOfInitialArray - 2; i >= 0; --i) {
         Integer hi = digitToIndexMapping.ceilingKey(arr[i]);
         Integer lo = digitToIndexMapping.floorKey(arr[i]);

         if (hi != null) {
            higherBoolArray[i] = lowerBoolArray[digitToIndexMapping.get(hi)];
         }
         if (lo != null) {
            lowerBoolArray[i] = higherBoolArray[digitToIndexMapping.get(lo)];
         }

         if (higherBoolArray[i]) {
            result++;
         }
         digitToIndexMapping.put(arr[i], i);
      }
      return result;
   }
}
