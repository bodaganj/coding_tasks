package com.coding.tasks.leetcode.third_round.top_interview_questions.google.interview.process;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

   public static void main(String[] args) {

   }

   public static int numUniqueEmails(String[] emails) {
      Set<String> emailsSet = new HashSet<>();
      for (String email : emails) {
         String[] split = email.split("@");
         String[] splitByPlusSign = split[0].split("\\+");
         String localName = splitByPlusSign[0].replaceAll("\\.", "");
         emailsSet.add(localName + "@" + split[1]);
      }

      return emailsSet.size();
   }
}
