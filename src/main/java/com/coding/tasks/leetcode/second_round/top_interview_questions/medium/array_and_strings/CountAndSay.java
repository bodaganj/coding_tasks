package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.array_and_strings;

public class CountAndSay {

   public static void main(String[] args) {
      System.out.println(countAndSay(1));
      System.out.println(countAndSay(2));
      System.out.println(countAndSay(4));
   }

   private static String countAndSay(int n) {
      String str = "1";
      for (int i = 2; i <= n; i++) {
         StringBuilder sb = new StringBuilder();
         int counter = 0;

         for (int j = 0; j < str.length(); j++) {
            if (counter == 0) {
               counter++;
            } else {
               if (str.charAt(j - 1) != str.charAt(j)) {
                  sb.append(counter).append(str.charAt(j - 1));
                  counter = 1;
               } else {
                  counter++;
               }
            }
         }
         sb.append(counter).append(str.charAt(str.length() - 1));
         str = sb.toString();
      }

      return str;
   }
}
