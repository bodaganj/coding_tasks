package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

   public static void main(String[] args) {
      System.out.println(intToRoman(3));
      System.out.println(intToRoman(4));
      System.out.println(intToRoman(12));
      System.out.println(intToRoman(113));
      System.out.println(intToRoman(114));
      System.out.println(intToRoman(1994));
      System.out.println(intToRoman(10));
      System.out.println(intToRoman(20));
      System.out.println(intToRoman(21));
   }

   private static String intToRoman(int num) {
      TreeMap<Integer, String> mapping = new TreeMap<>();
      mapping.put(1, "I");
      mapping.put(5, "V");
      mapping.put(10, "X");
      mapping.put(50, "L");
      mapping.put(100, "C");
      mapping.put(500, "D");
      mapping.put(1000, "M");

      Map<Integer, String> exceptions = new HashMap<>();
      exceptions.put(4, "IV");
      exceptions.put(9, "IX");
      exceptions.put(40, "XL");
      exceptions.put(90, "XC");
      exceptions.put(400, "CD");
      exceptions.put(900, "CM");

      LinkedList<String> list = new LinkedList<>();
      int counter = 1;
      while (num > 0) {
         int curr = num % (int) Math.pow(10, counter);
         while (curr == 0) {
            counter++;
            curr = num % (int) Math.pow(10, counter);
         }

         if (mapping.containsKey(curr)) {
            list.addFirst(mapping.get(curr));
         } else if (exceptions.containsKey(curr)) {
            list.addFirst(exceptions.get(curr));
         } else {
            Integer prevKey = mapping.floorKey(curr);
            StringBuilder tmpVal = new StringBuilder(mapping.get(prevKey));
            int tmpInt = prevKey;
            while (tmpInt != curr) {
               if (tmpInt + prevKey <= curr) {
                  tmpInt += prevKey;
                  tmpVal.append(mapping.get(prevKey));
               } else {
                  prevKey = mapping.floorKey(prevKey - 1);
               }
            }
            list.addFirst(tmpVal.toString());
         }

         num -= curr;
         counter++;
      }

      return String.join("", list);
   }
}
