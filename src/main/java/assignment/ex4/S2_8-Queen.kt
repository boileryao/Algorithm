package assignment.ex4

/**
 * Created by boileryao on 2018/5/13.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

fun nQueue(n: Int) {
    val cols = IntArray(n + 1, { 0 })  // which column should be put for every row
    var solutionCount = 0
    fun place(row: Int): Boolean {
        var lineIdx = 1
        while (lineIdx < row) {
            if (cols[lineIdx] == cols[row] ||
                    Math.abs(cols[lineIdx] - cols[row]) == Math.abs(lineIdx - row)) {
                return false
            }
            lineIdx++
        }
        return true
    }

    fun printSolution() {
        Array(n, { row ->
            IntArray(n, { col ->
                if (cols[row + 1] == col + 1) cols[row + 1] else 0
            })
        }).forEach { println(it.contentToString()) }
    }

    var curRow = 1
    while (curRow > 0) {
        cols[curRow]++
        while (cols[curRow] <= n && !place(curRow)) {
            cols[curRow]++
        }
        if (cols[curRow] <= n) {
            if (curRow == n) {
                println("Solution#${"%02d".format(++solutionCount)}: ${cols.sliceArray(1..n).contentToString()}")
                printSolution()
            } else {
                curRow++
                cols[curRow] = 0
            }
        } else {
            curRow--
        }
    }

    println(solutionCount)
}

fun main() {
    nQueue(8)
}