package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by boileryao on 2018/3/23.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class MinimumIndexSumOfTwoLists {
    @LeetCode(id = 599, problemName = "minimum-index-sum-of-ex2-lists")
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < list1.length; i++) {
            hashtable.put(list1[i], list1[i].hashCode() - i);
        }

        List<String> result = new ArrayList<>();
        int currentMinSum = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            Integer mapValue = hashtable.get(list2[j]);
            if (mapValue == null) continue;
            int hashcode = list2[j].hashCode();
            int i = hashcode - mapValue;
            if (i + j < currentMinSum) {
                result.clear();
                currentMinSum = i + j;
                result.add(list2[j]);
            } else if (i + j == currentMinSum) {
                result.add(list2[j]);
            }
        }

        return result.toArray(new String[]{});
    }
}
