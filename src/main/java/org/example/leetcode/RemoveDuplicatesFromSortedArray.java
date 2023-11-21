package org.example.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * <p>
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the unique elements in the order
 * they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * <p>
 * int k = removeDuplicates(nums); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int uniqueArrayLength = removeDuplicates(nums);

        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("New unique array length: " + uniqueArrayLength);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] result = new int[nums.length];
        int k = 1;
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != result[k - 1]) {
                result[k] = nums[i];
                k++;
            }
        }

        int[] uniqueArray = new int[k];
        System.arraycopy(result, 0, uniqueArray, 0, k);
        System.out.println("New unique array " + Arrays.toString(uniqueArray));
        return uniqueArray.length;
    }
}
