package com.coding.tasks.leetcode.third_round.fb.arrays.and.strings;

public class AddBinary {

   public static void main(String[] args) {
      System.out.println(addBinary("1010", "1011"));
   }

   public static String addBinary(String a, String b) {
      StringBuilder sb = new StringBuilder();
      int i = 0;
      int carry = 0;
      StringBuilder asb = new StringBuilder(a);
      asb.reverse();
      StringBuilder bsb = new StringBuilder(b);
      bsb.reverse();
      while (i < a.length() || i < b.length() || carry == 1) {
         int aVal = i < a.length() ? Integer.parseInt(asb.charAt(i) + "") : 0;
         int bVal = i < b.length() ? Integer.parseInt(bsb.charAt(i) + "") : 0;
         int sum = carry + aVal + bVal;
         if (sum < 2) {
            sb.append(sum);
            carry = 0;
         } else if (sum == 2) {
            sb.append(0);
            carry = 1;
         } else {
            sb.append(1);
            carry = 1;
         }
         i++;
      }
      return sb.reverse().toString();
   }
}
