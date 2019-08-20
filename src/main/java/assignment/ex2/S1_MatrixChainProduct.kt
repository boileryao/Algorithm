package assignment.ex2

/**
 * Created by boileryao on 2018/4/30.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

/**
 * Bottom-up Dynamic Planning
 * Start by setting m[i,i]=0 for i = 1,…,n. Then compute m[1,2], m[2,3],…,m[n-1,n].
 * Then m[1,3], m[2,4],…,m[n-2,n], … so on till we can compute m[1,n].
 * @param p eg. [1, 2, 4] means matrix 1*2 and matrix 2*4
 */
fun matrixChainProduct(p: IntArray) {
    val n = p.size - 1
    val m = Array(p.size) { IntArray(p.size) }
    val s = Array(p.size) { IntArray(p.size) }
    for (l in 2..n) {
        for (i in 1..n - l + 1) {
            val j = i + l - 1
            m[i][j] = Int.MAX_VALUE
            for (k in i until j) {
                val q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]
                if (q < m[i][j]) {
                    m[i][j] = q
                    s[i][j] = k
                }
            }
        }
    }
    printOptimal(s, 1, n)
    print(", ${m[1][n]} steps in all")
    println()
}

internal fun printOptimal(s: Array<IntArray>, i: Int, j: Int) {
    if (i == j) {
        print("A$i")
    } else {
        print("(")
        printOptimal(s, i, s[i][j])
        printOptimal(s, s[i][j] + 1, j)
        print(")")
    }
}

fun main() {
    matrixChainProduct(intArrayOf(3, 5, 2, 1, 10))
    matrixChainProduct(intArrayOf(2, 7, 3, 6, 10))
    matrixChainProduct(intArrayOf(10, 3, 15, 12, 7, 2))
    matrixChainProduct(intArrayOf(7, 2, 4, 15, 20, 5))
}