package com.coding.tasks.leetcode.second_round.amazon.design;

public class DesignSearchAutocompleteSystem {

   public static void main(String[] args) {
      AutocompleteSystem o = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"},
                                                    new int[]{5, 3, 2, 2});
//      System.out.println(o.input('i'));
//      System.out.println(o.input(' '));
//      System.out.println(o.input('a'));
//      System.out.println(o.input('#'));
   }

   /**
    * Your AutocompleteSystem object will be instantiated and called as such:
    * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
    * List<String> param_1 = obj.input(c);
    */
   static class AutocompleteSystem {

      public AutocompleteSystem(String[] sentences, int[] times) {
      }

//      public List<String> input(char c) {
//      }
   }
}
