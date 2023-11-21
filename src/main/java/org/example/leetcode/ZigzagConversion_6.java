package org.example.leetcode;


/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Формула 1 + k * 2 * (n - 1) представляет собой арифметическую прогрессию
 * n - номер строки в зигзагообразном представлении (нумерация строк начинается с 0).
 * k - индекс строки в исходной строке "PAYPALISHIRING" (нумерация символов также начинается с 0).
 * Например, для n=3 и k=2, формула будет выглядеть как 1 + 2 * 2 * (3 - 1) = 1 + 4 = 5
 */
public class ZigzagConversion_6 {
    public static void main(String[] args) {
        String inputString = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(inputString, numRows));
    }

    public static String convert(String inputString, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        char[] arr = inputString.toCharArray();
        int n = arr.length;
        int index = 0;

        while (index < n) {
            for (int j = 0; j < numRows && index < n; j++) {
                sbs[j].append(arr[index++]);
            }

            for (int j = numRows - 2; j > 0 && index < n; j--) {
                sbs[j].append(arr[index++]);
            }
        }

        StringBuilder res = sbs[0];
        for (int i = 1; i < numRows; i++) {
            res.append(sbs[i].toString());
        }
        return res.toString();
    }
}
