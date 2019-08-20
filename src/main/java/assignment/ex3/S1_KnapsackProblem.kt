package assignment.ex3

/**
 * Created by boileryao on 2018/5/5.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

internal val values = intArrayOf(20, 30, 65, 40, 60)
internal val weights = intArrayOf(10, 20, 30, 40, 50)
internal val vpws = floatArrayOf(2.0f, 1.5f, 2.1f, 1.0f, 1.2f)

fun zeroOneKnapsack(volume: Int, debug: Boolean = false): Int {
    val maxValues = IntArray(volume + 1)
    val weightDetail = Array<HashSet<Int>>(volume + 1, { HashSet() })
    for (vol in 0 until volume + 1) {
        for (i in 0 until values.size) {
            val weight = weights[i]
            val value = values[i]
            if (vol - weight < 0) continue
            if (weightDetail[vol - weight].contains(weight)) continue
            if (value + maxValues[vol - weight] > maxValues[vol]) {
                maxValues[vol] = value + maxValues[vol - weight]
                weightDetail[vol].clear()
                weightDetail[vol].addAll(weightDetail[vol - weight])
                weightDetail[vol].add(weight)
            }
        }
    }

    if (debug) {
        weightDetail.withIndex().forEach {
            println("#${it.index} \t${it.value} ${maxValues[it.index]}")
        }
    }
    return maxValues.last()
}

fun fractionalKnapsack(volume: Float): Float {
    val tmpWeights = floatArrayOf(10.0f, 20.0f, 30.0f, 40.0f, 50.0f)
    val taken = FloatArray(values.size)
    var inPack = 0.0f
    while (inPack < volume) {
        var maxIdx = 0
        var maxVpw = 0.0f
        for (i in 0 until values.size) {
            if (tmpWeights[i] <= 0) continue
            if (vpws[i] > maxVpw) {
                maxIdx = i
                maxVpw = vpws[i]
            }
        }
        if (tmpWeights[maxIdx] + inPack <= volume) {
            taken[maxIdx] = tmpWeights[maxIdx]
            inPack += tmpWeights[maxIdx]
            tmpWeights[maxIdx] = 0.0f
        } else {
            taken[maxIdx] = volume - inPack
            tmpWeights[maxIdx] -= volume - inPack
            inPack = volume
        }
    }

    return taken.mapIndexed { index, fl -> fl * vpws[index] }.reduce { a, b -> a + b }
}

fun main() {
    println("0/1 Knapsack: ${zeroOneKnapsack(100, debug = false)}")
    println("Fractional Knapsack: ${fractionalKnapsack(100.0f)}")
}