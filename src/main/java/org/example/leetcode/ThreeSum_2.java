package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/description/
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
public class ThreeSum_2 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Сортируем входной массив, чтобы проще обрабатывать дубликаты и использовать двух указателей.

        List<List<Integer>> result = new ArrayList<>(); // Создаем список для хранения найденных уникальных троек.

        for (int i = 0; i < nums.length - 2; i++) {
            // Итерируемся по массиву, оставляя место для двух указателей. -2 потому что минимальная длина тройки - 3 элемента.

            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                // Условие проверяет, что мы работаем с новым уникальным числом (предотвращает дубликаты).

                int target = -nums[i]; // Цель - найти пару чисел, сумма которых равна отрицанию текущего числа.

                int left = i + 1; // Левый указатель - следующий элемент после текущего.
                int right = nums.length - 1; // Правый указатель - последний элемент массива.

                while (left < right) { // Запускаем цикл двух указателей.
                    int sum = nums[left] + nums[right]; // Текущая сумма двух чисел, на которые указывают указатели.

                    if (sum == target) { // Если сумма равна цели (тройка найдена).
                        result.add(Arrays.asList(nums[i], nums[left], nums[right])); // Добавляем тройку в список результатов.

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++; // Пропускаем повторяющиеся элементы, чтобы избежать дубликатов троек.
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--; // Пропускаем повторяющиеся элементы, чтобы избежать дубликатов троек.
                        }

                        left++; // Переходим к следующему уникальному числу в массиве.
                        right--; // Переходим к следующему уникальному числу в массиве.
                    } else if (sum < target) {
                        left++; // Если сумма меньше цели, увеличиваем левый указатель, чтобы увеличить сумму.
                    } else {
                        right--; // Если сумма больше цели, уменьшаем правый указатель, чтобы уменьшить сумму.
                    }
                }
            }
        }

        return result; // Возвращаем список уникальных троек, сумма которых равна нулю.
    }
}
