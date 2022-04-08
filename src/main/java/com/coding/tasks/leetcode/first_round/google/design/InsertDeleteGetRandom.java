package com.coding.tasks.leetcode.first_round.google.design;

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

   /**
    * Your RandomizedSet object will be instantiated and called as such:
    * RandomizedSet obj = new RandomizedSet();
    * boolean param_1 = obj.insert(val);
    * boolean param_2 = obj.remove(val);
    * int param_3 = obj.getRandom();
    */
   static class RandomizedSet {

      public Map<Integer, Integer> mapValToIndex;
      public List<Integer> list;
      private Random random;

      public RandomizedSet() {
         mapValToIndex = new HashMap<>();
         list = new ArrayList<>();
         random = new Random();
      }

      public boolean insert(int val) {
         if (mapValToIndex.containsKey(val)) {
            list.remove((int) mapValToIndex.get(val));
            mapValToIndex.remove(val);
            list.add(val);
            mapValToIndex.put(val, list.size() - 1);
            return false;
         } else {
            list.add(val);
            mapValToIndex.put(val, list.size() - 1);
            return true;
         }
      }

      public boolean remove(int val) {
         if (mapValToIndex.containsKey(val)) {
            list.remove((int) mapValToIndex.get(val));
            mapValToIndex.remove(val);
            return true;
         } else {
            return false;
         }
      }

      public int getRandom() {
         return list.get(random.nextInt(list.size() - 1));
      }
   }
}
