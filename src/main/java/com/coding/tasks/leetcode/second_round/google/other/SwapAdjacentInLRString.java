package com.coding.tasks.leetcode.second_round.google.other;

public class SwapAdjacentInLRString {

   public static void main(String[] args) {
      System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
      System.out.println(canTransform("X", "L"));
      System.out.println(canTransform("XRLXXRRXL", "XRLXXRRLX"));
      System.out.println(canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
   }

   // Only START can be modified!!!! The task description is bad!!!
   // "XL" -> "LX" and "RX" -> "XR"
   private static boolean canTransform(String start, String end) {
      if (start.equals(end)) {
         return true;
      } else {
         for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
               if (start.startsWith("XL", i) || start.startsWith("RX", i)) {
                  start = swap(start, i);
                  return canTransform(start, end);
               }
            }
         }
      }
      return false;
   }

   private static String swap(String str, int index) {
      char[] chars = str.toCharArray();
      char tmp = chars[index];
      chars[index] = chars[index + 1];
      chars[index + 1] = tmp;
      return new String(chars);
   }
}
