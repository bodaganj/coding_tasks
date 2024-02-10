package com.coding.tasks.leetcode.third_round.amazon.arrays.and.strings;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {

   private static Map<Integer, String> map = new HashMap<>();

   static {
      map.put(0, "Zero");
      map.put(1, "One");
      map.put(2, "Two");
      map.put(3, "Three");
      map.put(4, "Four");
      map.put(5, "Five");
      map.put(6, "Six");
      map.put(7, "Seven");
      map.put(8, "Eight");
      map.put(9, "Nine");
      map.put(10, "Ten");
      map.put(11, "Eleven");
      map.put(12, "Twelve");
      map.put(13, "Thirteen");
      map.put(14, "Fourteen");
      map.put(15, "Fifteen");
      map.put(16, "Sixteen");
      map.put(17, "Seventeen");
      map.put(18, "Eighteen");
      map.put(19, "Nineteen");
      map.put(20, "Twenty");
      map.put(30, "Thirty");
      map.put(40, "Forty");
      map.put(50, "Fifty");
      map.put(60, "Sixty");
      map.put(70, "Seventy");
      map.put(80, "Eighty");
      map.put(90, "Ninety");
   }

   public static void main(String[] args) {
      System.out.println(numberToWords(123));
      System.out.println(numberToWords(0));
      System.out.println(numberToWords(507));
      System.out.println(numberToWords(1507));
      System.out.println(numberToWords(504707));
      System.out.println(numberToWords(1234567));
      System.out.println(numberToWords(12345));
      System.out.println(numberToWords(1234567891));
      System.out.println(numberToWords(1000000));
   }

   public static String numberToWords(int num) {
      if (num == 0) {
         return "Zero";
      }
      String sb = getBillions(num) +
         getMillions(num) +
         getThousands(num) +
         getSmall(num);
      return sb.trim().replace("  ", " ");
   }

   private static String getBillions(int num) {
      if (num <= 999999999) {
         return "";
      } else {
         StringBuilder sb = new StringBuilder();
         String str = String.valueOf(num);
         StringBuilder billions = new StringBuilder();
         int i = str.length() - 10;
         while (i >= 0 && i >= str.length() - 12) {
            billions.append(str.charAt(i));
            i--;
         }
         int parseInt = Integer.parseInt(billions.reverse().toString());
         sb.append(getSmall(parseInt));
         sb.append(" Billion ");
         return sb.toString();
      }
   }

   private static String getMillions(int num) {
      if (num <= 999999) {
         return "";
      } else {
         StringBuilder sb = new StringBuilder();
         String str = String.valueOf(num);
         StringBuilder millions = new StringBuilder();
         int i = str.length() - 7;
         while (i >= 0 && i >= str.length() - 9) {
            millions.append(str.charAt(i));
            i--;
         }
         int parseInt = Integer.parseInt(millions.reverse().toString());
         if (parseInt == 0) {
            return "";
         }
         sb.append(getSmall(parseInt));
         sb.append(" Million ");
         return sb.toString();
      }
   }

   private static String getThousands(int num) {
      if (num <= 999) {
         return "";
      } else {
         StringBuilder sb = new StringBuilder();
         String str = String.valueOf(num);
         StringBuilder thousands = new StringBuilder();
         int i = str.length() - 4;
         while (i >= 0 && i >= str.length() - 6) {
            thousands.append(str.charAt(i));
            i--;
         }
         int parseInt = Integer.parseInt(thousands.reverse().toString());
         if (parseInt == 0) {
            return "";
         }
         sb.append(getSmall(parseInt));
         sb.append(" Thousand ");
         return sb.toString();
      }
   }

   private static String getSmall(int num) {
      if (num > 999) {
         num %= 1000;
      }
      StringBuilder sb = new StringBuilder();
      if (num >= 100) {
         sb.append(map.get(num / 100));
         sb.append(" Hundred ");
      }
      num %= 100;
      if (num != 0) {
         if (map.containsKey(num)) {
            sb.append(map.get(num));
         } else {
            sb.append(map.get(num / 10 * 10));
            sb.append(" ");
            sb.append(map.get(num % 10));
         }
      }

      return sb.toString();
   }
}
