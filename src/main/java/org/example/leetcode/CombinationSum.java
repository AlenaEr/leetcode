package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/combination-sum/
 * Given an array of distinct integers candidates and a target integer target, return a list
 * of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.
 * Example: Input: candidates = [2,3,6,7], target = 7  Output: [[2,2,3],[7]]
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        Random rand = new Random();
//        int target = rand.nextInt(10);
        int target = 6;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println("target = " + target);
        System.out.println("result size = " + result.size() + "\nresult " + result);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(candidates, target, 0, current, result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start,
                                  List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                currentCombination.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
