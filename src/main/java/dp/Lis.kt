package dp

/**
 * Created by boileryao on 2018/4/6.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

fun lengthOfLIS(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    val allLis = IntArray(nums.size)
    nums.withIndex().forEach {
        allLis[it.index] = 1
        for (i in it.index - 1 downTo 0) {
            if (nums[i] < it.value && allLis[i] + 1 > allLis[it.index]) {
                allLis[it.index] = allLis[i] + 1
            }
        }
    }
    return allLis.max()!!
}

fun main() {
    lengthOfLIS(intArrayOf(1, 46, 78, 8)).apply(::println)  // 3
    lengthOfLIS(intArrayOf(1, 2, 3, 2, 5, 4, 5)).apply(::println)  // 5
    lengthOfLIS(intArrayOf(6, 4, 8, 2, 17)).apply(::println)  // 3
}