package com.coding.tasks.leetcode.google.interview_process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueEmailAddresses {

   /**
    * Every valid email consists of a local name and a domain name, separated by the '@' sign.
    * Besides lowercase letters, the email may contain one or more '.' or '+'.
    * <p>
    * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
    * If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.
    * Note that this rule does not apply to domain names.
    * <p>
    * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
    * If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
    * This allows certain emails to be filtered. Note that this rule does not apply to domain names.
    * <p>
    * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
    * It is possible to use both of these rules at the same time.
    * <p>
    * Given an array of strings emails where we send one email to each email[i], return the number of different addresses that actually receive mails.
    */
   public static void main(String[] args) {
      String[] first = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
      String[] second = new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};

      System.out.println(numUniqueEmails(first));
      System.out.println(numUniqueEmails(second));
   }

   private static int numUniqueEmails(String[] emails) {
      Set<String> finalSet = new HashSet<>();

      for (String email : emails) {
         List<String> listOfLetters = Arrays.stream(email.split("")).collect(Collectors.toList());
         int indexOfAt = listOfLetters.indexOf("@");

         List<String> domainName = listOfLetters.subList(indexOfAt, listOfLetters.size());
         List<String> localName = listOfLetters.subList(0, indexOfAt);
         List<String> localNameWithoutPlus = new ArrayList<>();
         if (localName.contains("+")) {
            int indexOf = localName.indexOf("+");
            localNameWithoutPlus = localName.subList(0, indexOf);
         }

         List<String> localNameWithoutDots;
         if (localNameWithoutPlus.isEmpty()) {
            localNameWithoutDots = localName.stream().filter(letter -> !letter.equals(".")).collect(Collectors.toList());
         } else {
            localNameWithoutDots = localNameWithoutPlus.stream().filter(letter -> !letter.equals(".")).collect(Collectors.toList());
         }

         finalSet.add(String.join("", localNameWithoutDots) + String.join("", domainName));
      }

      return finalSet.size();
   }

   // better way to do:
//   public int numUniqueEmails(String[] emails) {
//      // hash set to store all the unique emails
//      Set<String> uniqueEmails = new HashSet<>();
//
//      for (String email : emails) {
//         // split into two parts local and domain
//         String[] parts = email.split("@");
//
//         // split local by '+'
//         String[] local = parts[0].split("\\+");
//
//         // remove all '.', and concatenate '@' and append domain
//         uniqueEmails.add(local[0].replace(".", "") + "@" + parts[1]);
//      }
//
//      return uniqueEmails.size();
//   }
}
