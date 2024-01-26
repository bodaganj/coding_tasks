package com.coding.tasks.leetcode.third_round.google.arrays.and.strings;

public class BackspaceStringCompare {

   public static void main(String[] args) {
      System.out.println(backspaceCompare("ab#c", "ad#c")); // true
      System.out.println(backspaceCompare("ab##", "d#c#")); // true
      System.out.println(backspaceCompare("a##c", "#a#c")); // true
      System.out.println(backspaceCompare("bxj##tw", "bxo#j##tw")); // true

      System.out.println(backspaceCompare("a#b", "c")); // false
      System.out.println(backspaceCompare("bxj##tw", "bxj###tw")); // false
   }

   public static boolean backspaceCompare(String s, String t) {
      int sIndex = s.length() - 1;
      int tIndex = t.length() - 1;

      while (sIndex >= 0 || tIndex >= 0) {
         sIndex = getLetterIndex(sIndex, s);
         tIndex = getLetterIndex(tIndex, t);

         if (sIndex >= 0 && tIndex >= 0) {
            if (s.charAt(sIndex) != t.charAt(tIndex)) {
               return false;
            }
         }

         tIndex--;
         sIndex--;
      }

      return tIndex == sIndex;
   }

   private static int getLetterIndex(int index, String str) {
      int counter = 0;
      while (index >= 0) {
         if (counter == 0 && str.charAt(index) != '#') {
            return index;
         } else {
            if (str.charAt(index) == '#') {
               counter++;
            } else {
               counter--;
            }
            index--;
         }
      }
      return index;
   }
}
