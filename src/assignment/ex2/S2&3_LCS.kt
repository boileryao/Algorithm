package assignment.ex2

import java.util.*


/**
 * Created by boileryao on 2018/5/1.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

/**
 * https://rosettacode.org/wiki/Longest_common_subsequence
 */
fun lcsA(s1: String, s2: String): List<Char> {
    val num = Array(s1.length + 1) { IntArray(s2.length + 1) }  //2D array, initialized to 0

    //Actual algorithm
    for (i in 1..s1.length)
        for (j in 1..s2.length)
            if (s1[i - 1] == s2[j - 1])
                num[i][j] = 1 + num[i - 1][j - 1]
            else
                num[i][j] = Math.max(num[i - 1][j], num[i][j - 1])

    println("length of LCS = " + num[s1.length][s2.length])

    var s1position = s1.length
    var s2position = s2.length
    val result = LinkedList<Char>()

    while (s1position != 0 && s2position != 0) {
        when {
            s1[s1position - 1] == s2[s2position - 1] -> {
                result.add(s1[s1position - 1])
                s1position--
                s2position--
            }
            num[s1position][s2position - 1] >= num[s1position][s2position] -> {
                s2position--
            }
            else -> {
                s1position--
            }
        }
    }
    result.reverse()
    return result
}


/**
 * Ref: Introduction to Algorithm 3rd, P390~P396
 */
fun lcsB(X: String, Y: String) {
    val m = X.length
    val n = Y.length
    val b = Array(m + 1) { CharArray(n + 1) }
    val c = Array(m + 1) { IntArray(n + 1) }

    for (i in 1..m) {
        for (j in 1..n)
            when {
                X[i - 1] == Y[j - 1] -> {
                    c[i][j] = c[i - 1][j - 1] + 1
                    b[i][j] = '↖'
                }
                c[i - 1][j] >= c[i][j - 1] -> {
                    c[i][j] = c[i - 1][j]
                    b[i][j] = '↑'
                }
                else -> {
                    c[i][j] = c[i][j - 1]
                    b[i][j] = '←'
                }
            }
    }

    var lcsLen = 0
    fun printLCS(i: Int, j: Int) {
        if (i * j == 0) return
        when {
            b[i][j] == '↖' -> printLCS(i - 1, j - 1).also { lcsLen++; print(X[i]) }
            b[i][j] == '↑' -> printLCS(i - 1, j)
            else -> printLCS(i, j - 1)
        }
    }

    printLCS(m, n)
    println(", and it's length is $lcsLen")
}

fun main(args: Array<String>) {
    val shortStringA = "xzyzzyx"
    val shortStringB = "zxyyzxz"

    val longStringA = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD"
    val longStringB = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG"

    lcsA(shortStringA, shortStringB).forEach(::print).also { println() }
    lcsA(longStringA, longStringB).forEach(::print).also { println() }

    lcsB(shortStringA, shortStringB)
    lcsB(longStringA, longStringB)
}