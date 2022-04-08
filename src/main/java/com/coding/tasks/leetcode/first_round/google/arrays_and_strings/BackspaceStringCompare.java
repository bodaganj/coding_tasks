package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

public class BackspaceStringCompare {

   public static void main(String[] args) {
      System.out.println(backspaceCompare("ab##", "c#d#"));
   }

   private static boolean backspaceCompare(String s, String t) {
      return getFinalString(s).equals(getFinalString(t));
   }

   private static String getFinalString(String str) {
      int i = str.length() - 1;
      int backSpaceCounter = 0;
      StringBuilder sb1 = new StringBuilder();
      while (i >= 0) {
         if (str.charAt(i) != '#') {
            if (backSpaceCounter == 0) {
               sb1.append(str.charAt(i));
               i--;
            } else {
               i--;
               backSpaceCounter--;
            }
         } else {
            backSpaceCounter++;
            i--;
         }
      }
      return sb1.toString();
   }

   // This one is smaller!!!
//   public boolean backspaceCompare(String S, String T) {
//      return build(S).equals(build(T));
//   }
//
//   public String build(String S) {
//      Stack<Character> ans = new Stack();
//      for (char c: S.toCharArray()) {
//         if (c != '#')
//            ans.push(c);
//         else if (!ans.empty())
//            ans.pop();
//      }
//      return String.valueOf(ans);
//   }
}
