package com.coding.tasks.leetcode.first_round.google.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

   public static void main(String[] args) {
      System.out.println(isIsomorphic("egg", "add"));
      System.out.println(isIsomorphic("foo", "bar"));
      System.out.println(isIsomorphic("paper", "title"));
   }

   private static boolean isIsomorphic(String s, String t) {
      int[] arr1 = getArr(s);
      int[] arr2 = getArr(t);

      return Arrays.equals(arr1, arr2);
   }

   private static int[] getArr(String str) {
      int[] arr = new int[str.length()];
      Map<Character, Integer> mapping = new HashMap<>();
      char[] chars = str.toCharArray();

      int integer = 0;
      for (int i = 0; i < chars.length; i++) {
         char aChar = chars[i];

         if (mapping.containsKey(aChar)) {
            arr[i] = mapping.get(aChar);
         } else {
            mapping.put(aChar, integer);
            arr[i] = integer;
            integer++;
         }
      }

      return arr;
   }
}
