package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.design;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandom {

   /**
    * Your RandomizedSet object will be instantiated and called as such:
    * RandomizedSet obj = new RandomizedSet();
    * boolean param_1 = obj.insert(val);
    * boolean param_2 = obj.remove(val);
    * int param_3 = obj.getRandom();
    */
   static class RandomizedSet {

      private Set<Integer> set;
      private Random random;

      public RandomizedSet() {
         this.set = new LinkedHashSet<>();
         this.random = new Random();
      }

      public boolean insert(int val) {
         return set.add(val);
      }

      public boolean remove(int val) {
         return set.remove(val);
      }

//      public int getRandom() {
//         int counter = random.nextInt(set.size());
//
//      }
   }
}
