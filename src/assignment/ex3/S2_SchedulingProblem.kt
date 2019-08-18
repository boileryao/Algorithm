package assignment.ex3

/**
 * Created by boileryao on 2018/5/6.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

/**
 * A simple scheduling problem. We are given jobs j1, j2… jn, all with known running times t1, t2… tn, respectively.
 * We have a single processor. What is the best way to schedule these jobs to minimize the average completion time.
 * Assume that it is a non-preemptive scheduling: once a job is started, it must run to completion.
 */

fun echoBestSchedule(endTimes: IntArray) {
    endTimes.sort()
    println(endTimes.contentToString())
}


internal fun justDoIt(endTimes: IntArray) {
    val amountTime = endTimes.reversed().mapIndexed { index, num -> num * (index + 1) }.reduce { a, b -> a + b }
    println(amountTime / endTimes.size)
}

fun main(args: Array<String>) {
    justDoIt(intArrayOf(1))
    justDoIt(intArrayOf(1, 2))
    justDoIt(intArrayOf(3, 8, 10, 15))
    justDoIt(intArrayOf(15, 8, 3, 10))
    justDoIt(intArrayOf(15, 10, 8, 3))
    justDoIt(intArrayOf(15, 10, 8, 3))
    justDoIt(intArrayOf(15, 8, 10, 3))
    justDoIt(intArrayOf(8, 10, 15, 3))

    echoBestSchedule(intArrayOf(15, 8, 3, 10))
}