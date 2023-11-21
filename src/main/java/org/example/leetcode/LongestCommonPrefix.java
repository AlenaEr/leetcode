package org.example.leetcode;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * https://leetcode.com/problems/longest-common-prefix/
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int idx = 0;
        stringValidation(strs);
        while (idx < first.length() && idx < last.length()) {
            if (first.charAt(idx) == last.charAt(idx)) {
                idx++;
            } else {
                return first.substring(0, idx);
            }
        }
        return first.substring(0, idx);
    }

    private static void stringValidation(String[] strs) {
        if (strs == null || strs.length < 1 || strs.length > 200) {
            throw new IllegalArgumentException("Invalid input: strs length must be between 1 and 200.");
        }
        for (String s : strs) {
            if (s == null || s.length() < 0 || s.length() > 200) {
                throw new IllegalArgumentException("Invalid input: strs elements must have length between 0 and 200.");
            } else if (!areAllLowerCaseLetters(s)) {
                throw new IllegalArgumentException("Invalid input: strs elements must contain only lowercase English letters" + s);
            } else if (!s.isEmpty() && !s.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Invalid input: strs elements must contain only Latin letters.");
            }
        }
    }

    private static boolean areAllLowerCaseLetters(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}

