package leetcode

/**
 * Created by boileryao on 2019/12/26.
 * Licensed under WTFPL©2019.
 */
@LeetCode(id = 89, problemName = "gray-code", level = LeetCode.Level.MEDIUM)
fun grayCode(n: Int): List<Int> {
    return List(1 shl n) { idx -> idx xor (idx shr 1) }
}

fun main() {
    println(grayCode(3).joinToString())
}
