package com.coding.tasks.leetcode.amazon.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {

   private static Map<Integer, String> wordsMapping = new HashMap<>();

   static {
      wordsMapping.put(0, "Zero");
      wordsMapping.put(1, "One");
      wordsMapping.put(2, "Two");
      wordsMapping.put(3, "Three");
      wordsMapping.put(4, "Four");
      wordsMapping.put(5, "Five");
      wordsMapping.put(6, "Six");
      wordsMapping.put(7, "Seven");
      wordsMapping.put(8, "Eight");
      wordsMapping.put(9, "Nine");
      wordsMapping.put(10, "Ten");
      wordsMapping.put(11, "Eleven");
      wordsMapping.put(12, "Twelve");
      wordsMapping.put(13, "Thirteen");
      wordsMapping.put(14, "Fourteen");
      wordsMapping.put(15, "Fifteen");
      wordsMapping.put(16, "Sixteen");
      wordsMapping.put(17, "Seventeen");
      wordsMapping.put(18, "Eighteen");
      wordsMapping.put(19, "Nineteen");
      wordsMapping.put(20, "Twenty");
      wordsMapping.put(30, "Thirty");
      wordsMapping.put(40, "Forty");
      wordsMapping.put(50, "Fifty");
      wordsMapping.put(60, "Sixty");
      wordsMapping.put(70, "Seventy");
      wordsMapping.put(80, "Eighty");
      wordsMapping.put(90, "Ninety");
   }

   public static void main(String[] args) {
      System.out.println(numberToWords(30));
      System.out.println(numberToWords(100));
      System.out.println(numberToWords(123));
      System.out.println(numberToWords(12345));
      System.out.println(numberToWords(1234567));
   }

   private static String numberToWords(int num) {
      if (num / 1000000000 > 0) {
         StringBuilder sb = new StringBuilder();
         String hundreds = "";
         if (num % 1000 > 0) {
            hundreds = getHundreds(num % 1000);
         }
         String thousands = "";
         if ((num / 1000) % 1000 > 0) {
            thousands = getThousands((num / 1000) % 1000);
         }
         String millions = "";
         if ((num / 1000000) % 1000 > 0) {
            millions = getMillions((num / 1000000) % 1000);
         }
         String billions = getBillions((num / 1000000000) % 1000);
         return sb.append(billions).append(millions).append(thousands).append(hundreds).toString().trim();
      } else if (num / 1000000 > 0) {
         StringBuilder sb = new StringBuilder();
         String hundreds = "";
         if (num % 1000 > 0) {
            hundreds = getHundreds(num % 1000);
         }
         String thousands = "";
         if ((num / 1000) % 1000 > 0) {
            thousands = getThousands((num / 1000) % 1000);
         }
         String millions = getMillions((num / 1000000) % 1000);
         return sb.append(millions).append(thousands).append(hundreds).toString().trim();
      } else if (num / 1000 > 0) {
         StringBuilder sb = new StringBuilder();
         String hundreds = "";
         if (num % 1000 > 0) {
            hundreds = getHundreds(num % 1000);
         }
         String thousands = getThousands((num / 1000) % 1000);
         return sb.append(thousands).append(hundreds).toString().trim();
      } else {
         return getHundreds(num % 1000).trim();
      }
   }

   private static String getHundreds(int num) {
      if (num == 0) {
         return wordsMapping.get(num);
      }
      String result = "";
      if (num / 100 > 0) {
         result = result + " " + wordsMapping.get(num / 100) + " Hundred";
      }
      if (num % 100 > 19 && num % 10 != 0) {
         result = result + " " + wordsMapping.get(num % 100 - num % 10) + " " + wordsMapping.get(num % 10);
      } else {
         if (num % 100 != 0) {
            result = result + " " + wordsMapping.get(num % 100);
         }
      }
      return result;
   }

   private static String getThousands(int num) {
      return getHundreds(num) + " Thousand";
   }

   private static String getMillions(int num) {
      return getHundreds(num) + " Million";
   }

   private static String getBillions(int num) {
      return getHundreds(num) + " Billion";
   }
}
