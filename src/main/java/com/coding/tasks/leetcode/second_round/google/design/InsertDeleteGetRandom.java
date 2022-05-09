package com.coding.tasks.leetcode.second_round.google.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {

   public static void main(String[] args) {
      RandomizedSet o = new RandomizedSet();
      System.out.println(o.insert(1)); // true
      System.out.println(o.remove(2)); //
      System.out.println(o.insert(2));
      System.out.println(o.getRandom());
      System.out.println(o.remove(1));
      System.out.println(o.insert(2));
      System.out.println(o.getRandom());
   }

   static class RandomizedSet {

      private Map<Integer, Integer> map;
      private List<Integer> list;
      private Random rand;

      public RandomizedSet() {
         map = new HashMap<>();
         list = new ArrayList<>();
         rand = new Random();
      }

      public boolean insert(int val) {
         if (map.containsKey(val)) {
            return false;
         } else {
            map.put(val, list.size());
            list.add(val);
            return true;
         }
      }

      public boolean remove(int val) {
         if (map.containsKey(val)) {
            Integer indexToRemove = map.get(val);
            Integer lastElement = list.get(list.size() - 1);
            list.set(indexToRemove, lastElement);
            map.put(lastElement, indexToRemove);

            list.remove(list.size() - 1);
            map.remove(val);
            return true;
         } else {
            return false;
         }
      }

      public int getRandom() {
         return list.get(rand.nextInt(list.size()));
      }
   }
}
