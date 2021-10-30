package com.coding.tasks.hackerrank;

public class StringPermutations {

   public static void main(String[] args) {
      calculate("ABC");
   }

   private static void calculate(String input) {
      permutation("", input);
   }

   private static void permutation(String prefix, String input) {
      int length = input.length();
      if (length == 0) {
         System.out.println(prefix);
      } else {
         for (int i = 0; i < length; i++) {
            permutation(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1, length));
         }
      }
   }
}

// "" ABC
   // A BC
      // AB C
         // ABC ""
      // AC B
         // ACB ""

   // B AC
      // BA C
         // BAC ""
      // BC A
         // BCA ""

   // C AB
      // CA B
         // CAB ""
      // CB A
         // CBA ""