package com.coding.tasks.leetcode.top.interview.questions.easy.string;

public class CountAndSay {

   //   countAndSay(1) = "1"
//   countAndSay(2) = say "1" = one 1 = "11"
//   countAndSay(3) = say "11" = two 1's = "21"
//   countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

   public static void main(String[] args) {
      System.out.println(countAndSay(1));
      System.out.println(countAndSay(2));
      System.out.println(countAndSay(5));
   }

   // do while + counter
   private static String countAndSay(int n) {
      String result = "";
      for (int i = 1; i <= n; i++) {
         if (i == 1) {
            result = "1";
         } else {
            StringBuilder sb = new StringBuilder();
            int counter = 1;
            int j = 1;
            char[] chars = result.toCharArray();
            Character tmp = chars[0];
            while (j < chars.length) {
               if (tmp == chars[j]) {
                  counter++;
               } else {
                  sb.append(counter).append(tmp);
                  counter = 1;
                  tmp = chars[j];
               }
               j++;
            }
            if (counter > 0) {
               sb.append(counter).append(tmp);
            }
            result = sb.toString();
         }
      }
      return result;
   }
}
