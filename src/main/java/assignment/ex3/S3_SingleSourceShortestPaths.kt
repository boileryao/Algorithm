package assignment.ex3

import assignment.ex2.Z
import assignment.ex2.bellmanFord

/**
 * Created by boileryao on 2018/5/22.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

val graph = arrayOf(
        intArrayOf(Z, -1, 3, Z, Z),
        intArrayOf(Z, Z, 3, 2, 2),
        intArrayOf(Z, Z, Z, Z, Z),
        intArrayOf(Z, 1, 5, Z, Z),
        intArrayOf(Z, Z, Z, -3, Z)
)

fun main() {
    bellmanFord(graph)
}