package com.coding.tasks.leetcode.second_round.google.design;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

   public static void main(String[] args) {
      Logger obj = new Logger();
      System.out.println(obj.shouldPrintMessage(1, "foo")); // true
      System.out.println(obj.shouldPrintMessage(2, "bar")); // true
      System.out.println(obj.shouldPrintMessage(3, "foo")); // false
      System.out.println(obj.shouldPrintMessage(8, "bar")); // false
      System.out.println(obj.shouldPrintMessage(10, "foo")); // false
      System.out.println(obj.shouldPrintMessage(11, "foo")); // true
   }

   static class Logger {

      private Map<String, Integer> map;

      public Logger() {
         map = new HashMap<>();
      }

      public boolean shouldPrintMessage(int timestamp, String message) {
         if (map.containsKey(message)) {
            if (timestamp < map.get(message)) {
               return false;
            } else {
               map.put(message, timestamp + 10);
               return true;
            }
         } else {
            map.put(message, timestamp + 10);
            return true;
         }
      }
   }
}
