package assignment.ex2

/**
 * Created by boileryao on 2018/5/5.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

val Z = Integer.MAX_VALUE  /* infinite */
internal val graph = arrayOf(
        //                0  1  2  3  4  5  6  7  8  9  A  B  C  D  E  F
        /* 0 */intArrayOf(0, 5, 3, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z),
        /* 1 */intArrayOf(5, 0, Z, 1, 3, 6, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z),
        /* 2 */intArrayOf(3, Z, 0, Z, 8, 7, 6, Z, Z, Z, Z, Z, Z, Z, Z, Z),
        /* 3 */intArrayOf(Z, 1, Z, 0, Z, Z, Z, 6, 8, Z, Z, Z, Z, Z, Z, Z),
        /* 4 */intArrayOf(Z, 3, 8, Z, 0, Z, Z, 3, 5, Z, Z, Z, Z, Z, Z, Z),
        /* 5 */intArrayOf(Z, 6, 7, Z, Z, 0, Z, Z, 3, 3, Z, Z, Z, Z, Z, Z),
        /* 6 */intArrayOf(Z, Z, 6, Z, Z, Z, 0, Z, 8, 4, Z, Z, Z, Z, Z, Z),
        /* 7 */intArrayOf(Z, Z, Z, 6, 3, Z, Z, 0, Z, Z, 2, 2, Z, Z, Z, Z),
        /* 8 */intArrayOf(Z, Z, Z, 8, 5, 3, 8, Z, 0, Z, Z, 1, 2, Z, Z, Z),
        /* 9 */intArrayOf(Z, Z, Z, Z, Z, 3, 4, Z, Z, 0, Z, 3, 3, Z, Z, Z),
        /* A */intArrayOf(Z, Z, Z, Z, Z, Z, Z, 2, Z, Z, 0, Z, Z, 3, 5, Z),
        /* B */intArrayOf(Z, Z, Z, Z, Z, Z, Z, 2, 1, 3, Z, 0, Z, 5, 2, Z),
        /* C */intArrayOf(Z, Z, Z, Z, Z, Z, Z, Z, 2, 3, Z, Z, 0, 6, 6, Z),
        /* D */intArrayOf(Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, 3, 5, 6, 0, Z, 4),
        /* E */intArrayOf(Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, 5, 2, 6, Z, 0, 3),
        /* F */intArrayOf(Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, 4, 3, 0)
)


fun dijkstra() {
    val setS = HashSet<Int>()
    val setQ = HashSet<Int>(graph.size)
    val d = IntArray(graph.size)
    val previous = IntArray(graph.size)

    setQ.addAll(0..15)
    d.fill(Z, 1, d.size)

    fun extractMin(): Int {
        var minD = Z
        var minVertex = 0
        for (vertex in setQ) {
            if (d[vertex] < minD) {
                minD = d[vertex]
                minVertex = vertex
            }
        }
        setQ.remove(minVertex)
        return minVertex
    }

    while (setQ.isNotEmpty()) {
        val curMinVertex = extractMin()
        setS.add(curMinVertex)
        for (i in 0 until graph[curMinVertex].size) {
            val len = graph[curMinVertex][i]
            if (len != 0 && len != Z && d[i] > d[curMinVertex] + len) {
                d[i] = d[curMinVertex] + len
                previous[i] = curMinVertex
            }
        }
    }

    //  print minimum distance path
    run {
        println("Minimum distance is: ${d[graph.lastIndex]}")

        var pre = graph.lastIndex
        print(graph.lastIndex)
        do {
            pre = previous[pre]
            print(" <-- $pre")
        } while (pre != 0)
        println()
    }
}

fun bellmanFord(graph: Array<IntArray>) {
    val dists = IntArray(graph.size, { idx -> if (idx == 0) 0 else Z })
    val preNodes = IntArray(graph.size)
    for (i in 0..graph.lastIndex) {
        for (j in 0..graph[i].lastIndex) {
            if (graph[i][j] == Z) continue

            val newDist = if (dists[i] == Z) 0 else dists[i] + graph[i][j]
            if (newDist < dists[j]) {
                dists[j] = newDist
                preNodes[j] = i
            }
        }
    }

    println(dists.contentToString())
    println(preNodes.contentToString())
}

fun main() {
    dijkstra()
    bellmanFord(graph)
}