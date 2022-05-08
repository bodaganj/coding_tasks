package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {

   public static void main(String[] args) {
      RandomizedSet o = new RandomizedSet();
      System.out.println(o.insert(0));
      System.out.println(o.insert(1));
      System.out.println(o.remove(0));
      System.out.println(o.insert(2));
      System.out.println(o.remove(1));
      System.out.println(o.getRandom());

      System.out.println(o.insert(3));
      System.out.println(o.insert(3));
      System.out.println(o.getRandom());
      System.out.println(o.getRandom());
      System.out.println(o.insert(1));
      System.out.println(o.remove(3));
      System.out.println(o.getRandom());
      System.out.println(o.getRandom());
      System.out.println(o.insert(0));
      System.out.println(o.remove(0));
   }

   static class RandomizedSet {

      private Map<Integer, Integer> map;
      private List<Integer> list;
      private Random rand = new Random();

      public RandomizedSet() {
         map = new HashMap<>();
         list = new ArrayList<>();
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
            int indexToRemove = map.get(val);
            int lastElement = list.get(list.size() - 1);
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
