package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.others;

public class SumOfTwoIntegers {

   public static void main(String[] args) {
      System.out.println(getSum(2, 3));
      System.out.println(getSum(-12, -8));
   }

   public static int getSum(int a, int b) {
      if (a == 0) {
         return b;
      }
      if (b == 0) {
         return a;
      }
      if (Math.abs(a) == Math.abs(b)) {
         return 0;
      }
      StringBuilder binary = new StringBuilder();
      int carry = 0;
      while (a != 0 || b != 0) {
         int aLast = (a & 1) == 0 ? 0 : 1;
         int bLast = (b & 1) == 0 ? 0 : 1;
         int sum = aLast + bLast + carry;
         if (sum == 0) {
            binary.append(0);
         } else if (sum == 1) {
            binary.append(1);
            carry = 0;
         } else if (sum == 2) {
            carry = 1;
            binary.append(0);
         } else {
            carry = 1;
            binary.append(1);
         }
         a >>= 1;
         b >>= 1;
      }

      if (carry == 1) {
         binary.append(carry);
      }
      String s = binary.reverse().toString();
      return Integer.parseInt(s, 2);
   }
}
