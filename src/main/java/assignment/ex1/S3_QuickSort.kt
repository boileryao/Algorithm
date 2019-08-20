package assignment.ex1

/**
 * Created by boileryao on 2018/4/30.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

fun quickSort(arr: IntArray, start: Int, end: Int) {
    if (start < end) {
        val mid = partition(arr, start, end)
        quickSort(arr, start, mid - 1)
        quickSort(arr, mid + 1, end)
    }
}


/**
 * A partition implementation in "Introduction to Algorithms"
 * @param arr the array to be sort
 * @param start the start position of this arr
 * @param end same as above
 * note that index begins at '0'
 */
internal fun partition(arr: IntArray, start: Int, end: Int): Int {
    var head = start - 1
    for (i in start until end) {
        if (arr[i] <= arr[end]) {
            head++
            val tmp = arr[head]
            arr[head] = arr[i]
            arr[i] = tmp
        }
    }
    val tmp = arr[head + 1]
    arr[head + 1] = arr[end]
    arr[end] = tmp
    return head + 1
}

fun main() {
    val arr = intArrayOf(3, 2, 3, -1, 5, 2, 9, 3, 0, 7)
    quickSort(arr, 0, arr.size - 1)
    println(arr.contentToString())
}