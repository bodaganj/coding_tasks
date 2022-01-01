package com.coding.tasks.leetcode.amazon.arrays_and_strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IntegerToRoman {

   public static void main(String[] args) {
      System.out.println(intToRoman(3));
      System.out.println(intToRoman(4));
      System.out.println(intToRoman(12));
      System.out.println(intToRoman(113));
      System.out.println(intToRoman(114));
      System.out.println(intToRoman(1994));
   }

   private static String intToRoman(int num) {
      List<Integer> integers = new ArrayList<>();
      integers.add(1);
      integers.add(4);
      integers.add(5);
      integers.add(9);
      integers.add(10);
      integers.add(40);
      integers.add(50);
      integers.add(90);
      integers.add(100);
      integers.add(400);
      integers.add(500);
      integers.add(900);
      integers.add(1000);

      Map<Integer, String> mapping = new LinkedHashMap<>();
      mapping.put(1, "I");
      mapping.put(4, "IV");
      mapping.put(5, "V");
      mapping.put(9, "IX");
      mapping.put(10, "X");
      mapping.put(40, "XL");
      mapping.put(50, "L");
      mapping.put(90, "XC");
      mapping.put(100, "C");
      mapping.put(400, "CD");
      mapping.put(500, "D");
      mapping.put(900, "CM");
      mapping.put(1000, "M");

      StringBuilder sb = new StringBuilder();

      int i = 1;
      while (num != 0 && i < integers.size()) {
         if (num > integers.get(i) && i == (integers.size() - 1)) {
            num = num - integers.get(i);
            sb.append(mapping.get(integers.get(i)));
            i = 1;
         } else if (num > integers.get(i)) {
            i++;
         } else if (num == integers.get(i)) {
            sb.append(mapping.get(integers.get(i)));
            num = 0;
         } else {
            num = num - integers.get(i - 1);
            sb.append(mapping.get(integers.get(i - 1)));
            i = 1;
         }
      }
      return sb.toString();
   }
}
