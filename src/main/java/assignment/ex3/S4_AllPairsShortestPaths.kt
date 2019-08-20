package assignment.ex3

/**
 * Created by boileryao on 2018/5/22.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
const val INF = Int.MAX_VALUE

fun floyd(matrix: Array<IntArray>) {
    val n = matrix.size
    val dist: Array<IntArray> = Array(n, { row -> IntArray(n, { col -> matrix[row][col] }) })
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (dist[i][k] != INF &&
                        dist[k][j] != INF &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    run {
        println("============最短路径长度============")
        dist.forEach {
            println(it.joinToString(separator = ", ") { if (it == INF) "INF" else it.toString() })
        }
    }
}

fun main() {
    floyd(graph)
}