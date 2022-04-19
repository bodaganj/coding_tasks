package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.string;

public class ReverseInteger {

   public static void main(String[] args) {
      System.out.println(reverse(234));
      System.out.println(reverse(-20));
      System.out.println(reverse(0));
      System.out.println(reverse(1534236469));
   }

   private static int reverse(int x) {
      StringBuilder sb = new StringBuilder();
      if (x < 0) {
         String xstr = x + "";
         int counter = 1;
         while (counter < xstr.length()) {
            sb.append(xstr.charAt(counter));
            counter++;
         }
         String finalStr = sb.reverse().toString();
         try {
            return Integer.parseInt(finalStr) * -1;
         } catch (NumberFormatException exception) {
            return 0;
         }
      } else {
         String finalStr = sb.append(x + "").reverse().toString();
         try {
            return Integer.parseInt(finalStr);
         } catch (NumberFormatException exception) {
            return 0;
         }
      }
   }
}
