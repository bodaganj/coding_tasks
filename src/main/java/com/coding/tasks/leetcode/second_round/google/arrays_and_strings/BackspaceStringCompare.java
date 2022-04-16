package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

public class BackspaceStringCompare {

   public static void main(String[] args) {
      System.out.println(backspaceCompare("ab##", "c#d#"));
   }

   private static boolean backspaceCompare(String s, String t) {
      String first = getStringToCompare(s);
      String second = getStringToCompare(t);
      return first.equals(second);
   }

   private static String getStringToCompare(String str) {
      int sCounter = str.length() - 1;
      StringBuilder finalS = new StringBuilder();
      int sRemove = 0;
      while (sCounter >= 0) {
         char curr = str.charAt(sCounter);
         if (curr != '#' && sRemove == 0) {
            finalS.append(curr);
         } else if (curr == '#') {
            sRemove++;
         } else {
            sRemove--;
         }
         sCounter--;
      }
      return finalS.reverse().toString();
   }
}
