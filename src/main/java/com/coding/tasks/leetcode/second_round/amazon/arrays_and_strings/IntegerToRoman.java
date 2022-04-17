package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

   public static void main(String[] args) {
//      System.out.println(intToRoman(3));
//      System.out.println(intToRoman(4));
//      System.out.println(intToRoman(12));
//      System.out.println(intToRoman(113));
//      System.out.println(intToRoman(114));
//      System.out.println(intToRoman(1994));
      System.out.println(intToRoman(10));
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
      int counter = 0;
      do {
         int curr = num % 10;
         curr = curr * (int) Math.pow(10, counter);

         if (mapping.containsKey(curr)) {
            list.addFirst(mapping.get(curr));
         } else if (exceptions.containsKey(curr)) {
            list.addFirst(exceptions.get(curr));
         } else {
            Integer prevKey = mapping.floorKey(curr);
            Integer prevOfPrev = mapping.floorKey(prevKey - 1);
            StringBuilder tmpVal;
            if (prevOfPrev == null) {
               int tmpInt = prevKey + prevKey;
               tmpVal = new StringBuilder(mapping.get(prevKey) + mapping.get(prevKey));
               while (tmpInt != curr) {
                  tmpInt += prevKey;
                  tmpVal.append(mapping.get(prevKey));
               }
            } else {
               int tmpInt = prevKey + prevOfPrev;
               tmpVal = new StringBuilder(mapping.get(prevKey) + mapping.get(prevOfPrev));
               while (tmpInt != curr) {
                  tmpInt += prevOfPrev;
                  tmpVal.append(mapping.get(prevOfPrev));
               }
            }

            list.addFirst(tmpVal.toString());
         }

         num /= 10;
         counter++;
      } while (num > 0);

      return String.join("", list);
   }
}
