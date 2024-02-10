package com.coding.tasks.leetcode.third_round.google.design;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

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
