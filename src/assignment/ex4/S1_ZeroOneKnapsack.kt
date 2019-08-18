package assignment.ex4

import kotlin.test.assertEquals

/**
 * Created by boileryao on 2018/5/13.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 *
 * @see { https://blog.csdn.net/wzq153308/article/details/46366833 }
 */


internal var capacity = 100
internal var values = intArrayOf(65, 20, 30, 60, 40)
internal var weights = doubleArrayOf(30.0, 10.0, 20.0, 50.0, 40.0)
internal var maxValue = 0
internal var tmpValue: Int = 0
internal var tmpWeight: Double = 0.0
internal var tmpWay = IntArray(values.size)
internal var bestWay = IntArray(values.size)

/**
 * do backtrack, be sure `value` and `weight` array are sorted by unit-weight
 */
fun backTrack(depth: Int) {
    // 已经搜索到叶节点
    if (depth >= values.size) {
        if (tmpValue > maxValue) {
            maxValue = tmpValue
            for (i in 0 until values.size)
                bestWay[i] = tmpWay[i]
        }
        return
    }
    // 搜索左边节点: 装下当前节点的物品
    if (tmpWeight + weights[depth] <= capacity) {
        tmpWeight += weights[depth]
        tmpValue += values[depth]
        tmpWay[depth] = 1
        backTrack(depth + 1)

        tmpWeight -= weights[depth]
        tmpValue -= values[depth]
        tmpWay[depth] = 0  // roll back
    }
    // 搜索右边的节点: 不装当前物品
    backTrack(depth + 1)

//    if (bound(depth + 1) >= maxValue) {
//        backTrack(depth + 1)
//    }
}

/**
 * 计算剩余物品的最高价值上界, 模拟fractional背包
 */
fun bound(k: Int): Double {
    var depth = k
    var maxLeft = tmpValue.toDouble()
    var leftWeight = capacity - tmpWeight
    // 尽力依照单位重量价值次序装剩余的物品
    while (k <= values.size - 1 && leftWeight > weights[k]) {
        leftWeight -= weights[k]
        maxLeft += values[k]
        depth++
    }
    // 不能装时，用下一个物品的单位重量价值折算到剩余空间。
    if (k <= values.size - 1) {
        maxLeft += values[k] / weights[k] * leftWeight
    }
    return maxLeft
}

fun main(args: Array<String>) {
    // sort `value and weight`
    assertEquals(values.size, weights.size)
    val tmpArray = Array(values.size, { idx -> Triple(values[idx], weights[idx], values[idx] / weights[idx]) })
    tmpArray.sortedWith(Comparator { o1, o2 -> ((o2.third - o1.third) * Integer.MAX_VALUE).toInt() })
            .withIndex()
            .forEach { values[it.index] = it.value.first; weights[it.index] = it.value.second }

    backTrack(0)
    println("背包能装下的物品最大价值为:$maxValue")
    println("取出的方法为:${bestWay.contentToString()}")

}
