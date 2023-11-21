package org.example.leetcode;

import java.util.Arrays;

/**
 * You are given a 0-indexed integer array nums and an integer pivot.
 * Rearrange nums such that the following conditions are satisfied:
 * <p>
 * Every element less than pivot appears before every element greater than pivot.
 * Every element equal to pivot appears in between the elements less than and greater than pivot.
 * The relative order of the elements less than pivot and the elements greater than pivot is maintained.
 * More formally, consider every pi, pj where pi is the new position of the ith element and pj
 * is the new position of the jth element.
 * For elements less than pivot, if i < j and nums[i] < pivot and nums[j] < pivot, then pi < pj.
 * Similarly for elements greater than pivot, if i < j and nums[i] > pivot and nums[j] > pivot, then pi < pj.
 * Return nums after the rearrangement.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [9,12,5,10,14,3,10], pivot = 10
 * Output: [9,5,3,10,10,12,14]
 * Explanation:
 * The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
 * The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
 * The relative ordering of the elements less than and greater than pivot is also maintained.
 * [9, 5, 3] and [12, 14] are the respective orderings.
 */
public class PartitionArrayAccordingToGivenPivot_2161 {
    public static void main(String[] args) {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 5;
        System.out.println(Arrays.toString(pivotArray(nums, pivot)));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[nums.length - 1 - i] > pivot) {
                result[right--] = nums[nums.length - 1 - i];
            }
        }

        while (left <= right) {
            result[left++] = pivot;
            result[right--] = pivot;
        }

        return result;
    }

 /*   int[] result = new int[nums.length];
    int left = 0, right = nums.length - 1;

        for (int num : nums) {
        if (num < pivot) {
            result[left++] = num;
        }
    }

        for (int num : nums) {
        if (num == pivot) {
            result[left++] = num;
        }
    }

        for (int i = nums.length - 1; i >= 0; i--) {
        if (nums[i] > pivot) {
            result[right--] = nums[i];
        }
    }
        return result;
}*/
}
