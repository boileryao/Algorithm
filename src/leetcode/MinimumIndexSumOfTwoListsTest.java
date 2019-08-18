package leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;


/**
 * Created by boileryao on 2018/3/23.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class MinimumIndexSumOfTwoListsTest {

    @Test
    public void testFindRestaurant_Simple1() {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] result = MinimumIndexSumOfTwoLists.findRestaurant(list1, list2);
        assertEquals(result.length, 1);
        assertEquals(result[0], "Shogun");
    }

    @Test
    public void testFindRestaurant_Simple2() {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] result = MinimumIndexSumOfTwoLists.findRestaurant(list1, list2);
        assertEquals(result.length, 1);
        assertEquals(result[0], "Shogun");
    }

    @Test
    public void testFindRestaurant_DoubleCommon() {
        String[] list1 = {"Burger King", "Shogun", "KFC"};
        String[] list2 = {"KFC", "Nop Shogun", "Burger King"};
        String[] result = MinimumIndexSumOfTwoLists.findRestaurant(list1, list2);
        assertEquals(result.length, 2);
        assertEquals(result[0], "KFC");
        assertEquals(result[1], "Burger King");
    }
}