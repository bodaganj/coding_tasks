package com.coding.tasks.leetcode.second_round.google.design;

public class DesignSearchAutocompleteSystem {

   public static void main(String[] args) {
      DesignSearchAutocompleteSystem.AutocompleteSystem o =
         new DesignSearchAutocompleteSystem.AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"},
                                                               new int[]{5, 3, 2, 2});
//      System.out.println(o.input('i'));
//      System.out.println(o.input(' '));
//      System.out.println(o.input('a'));
//      System.out.println(o.input('#'));
   }

   /**
    * HashMap implementation
    */
   static class AutocompleteSystem {

      public AutocompleteSystem(String[] sentences, int[] times) {
      }

//      public List<String> input(char c) {
//      }
   }
}
