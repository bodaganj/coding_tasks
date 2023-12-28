package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.design;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandom {

   public static void main(String[] args) {
//      RandomizedSet rs = new RandomizedSet();
//      System.out.println(rs.insert(1));
//      System.out.println(rs.remove(2));
//      System.out.println(rs.insert(2));
//      System.out.println(rs.getRandom());
//      System.out.println(rs.remove(1));
//      System.out.println(rs.insert(2));
//      System.out.println(rs.getRandom());

      RandomizedSet rs = new RandomizedSet();
      System.out.println(rs.insert(-1));
      System.out.println(rs.remove(-2));
      System.out.println(rs.insert(-2));
      System.out.println(rs.getRandom());
      System.out.println(rs.remove(-1));
      System.out.println(rs.insert(-2));
      System.out.println(rs.getRandom());
   }

   static class RandomizedSet {

      private final Set<Integer> set;
      private final Map<Integer, Integer> map;
      private final Random random;
      private int[] array;
      private int index;

      public RandomizedSet() {
         array = new int[10];
         index = 0;
         set = new HashSet<>();
         map = new HashMap<>();
         random = new Random();
      }

      public boolean insert(int val) {
         if (set.contains(val)) {
            return false;
         } else {
            map.put(val, index);
            if (index >= array.length) {
               int[] tmp = new int[array.length + array.length / 2];
               System.arraycopy(array, 0, tmp, 0, array.length);
               array = tmp;
            }
            array[index++] = val;
            return set.add(val);
         }
      }

      public boolean remove(int val) {
         if (set.contains(val)) {
            Integer indexToRemove = map.get(val);
            map.remove(val);
            if (indexToRemove != index - 1) {
               // swap
               array[indexToRemove] = array[index - 1];
               map.put(array[indexToRemove], indexToRemove);
            }
            index--;
            return set.remove(val);
         } else {
            return false;
         }
      }

      public int getRandom() {
         Collection<Integer> values = map.values();
         return array[random.nextInt(values.size())];
      }
   }
}
