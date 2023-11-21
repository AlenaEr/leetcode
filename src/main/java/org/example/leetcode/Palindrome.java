package org.example.leetcode;

/**
 * https://leetcode.com/problems/palindrome-number/solutions/
 * */
public class Palindrome {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(2345432);
        System.out.println(palindrome);
    }
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }


        int half = 0;
        while (x > half) {
            half = (half * 10) + (x % 10);
            x = x / 10;
        }

        return x == half || x == half / 10;
    }
}
