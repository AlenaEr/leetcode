package org.example.leetcode;

import java.util.*;
import java.util.function.Function;

/**
 * https://leetcode.com/problems/group-by/
 * Write code that enhances all arrays such that you can call the array.groupBy(fn)
 * method on any array and it will return a grouped version of the array.
 * A grouped array is an object where each key is the output of fn(arr[i])
 * and each value is an array containing all items in the original array with that key.
 * The provided callback fn will accept an item in the array and return a string key.
 * The order of each value list should be the order the items appear in the array. Any order of keys is acceptable.
 * Please solve it without lodash's _.groupBy function.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * array = [
 * {"id":"1"},
 * {"id":"1"},
 * {"id":"2"}
 * ],
 * fn = function (item) {
 * return item.id;
 * }
 * Output:
 * {
 * "1": [{"id": "1"}, {"id": "1"}],
 * "2": [{"id": "2"}]
 * }
 * Explanation:
 * Output is from array.groupBy(fn).
 * The selector function gets the "id" out of each item in the array.
 * There are two objects with an "id" of 1. Both of those objects are put in the first array.
 * There is one object with an "id" of 2. That object is put in the second array
 */
public class GroupBy_2631 {
    public static void main(String[] args) {
        List<Map<String, String>> array1 = new ArrayList<>();
        array1.add(Map.of("id", "1"));
        array1.add(Map.of("id", "1"));
        array1.add(Map.of("id", "2"));

        Function<Map<String, String>, String> fn1 = item -> item.get("id");

        Map<String, List<Map<String, String>>> groupedArray1 = groupBy(array1, fn1);
        System.out.println(groupedArray1);

        List<Integer[]> array2 = new ArrayList<>();
        array2.add(new Integer[]{1, 2, 3});
        array2.add(new Integer[]{1, 3, 5});
        array2.add(new Integer[]{1, 5, 9});

        Function<Integer[], Integer> fn2 = item -> item[0];

        Map<Integer, List<Integer[]>> groupedArray2 = groupBy(array2, fn2);
        printMap(groupedArray2);
    }

    private static <T, K> Map<K, List<T>> groupBy(List<T> array1, Function<T, K> fn1) {
        Map<K, List<T>> result = new HashMap<>();

        for (T item : array1) {
            K key = fn1.apply(item);
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
        }
        return result;
    }

    private static void printMap(Map<Integer, List<Integer[]>> groupedArray2) {
        for (Map.Entry<Integer, List<Integer[]>> entry : groupedArray2.entrySet()) {
            Integer key = entry.getKey();
            List<Integer[]> value = entry.getValue();

            System.out.print(key + ": [");
            for (Integer[] subArray : value) {
                System.out.print(Arrays.toString(subArray) + ", ");
            }
            System.out.println("]");
        }
    }
}



