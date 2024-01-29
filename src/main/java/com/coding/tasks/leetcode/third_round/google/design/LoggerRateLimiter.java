package com.coding.tasks.leetcode.third_round.google.design;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

  class Logger {

    private Map<String, Integer> map;

    public Logger() {
      map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
      if (map.containsKey(message)) {
        if (map.get(message) + 10 > timestamp) {
          return false;
        } else {
          map.put(message, timestamp);
          return true;
        }
      } else {
        map.put(message, timestamp);
        return true;
      }
    }
  }
}
