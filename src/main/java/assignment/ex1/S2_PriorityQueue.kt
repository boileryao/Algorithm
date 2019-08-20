package assignment.ex1

import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

/**
 * Created by boileryao on 2018/4/30.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

/** PriorityQueue */
class PriorityQueue {
    private val queue = arrayListOf<QueueNode>()
    fun max(): QueueNode {
        return queue.first()
    }

    fun extractMax(): QueueNode {
        val max = queue.first()
        queue.remove(max)
        rebuildMaxHeap()
        return max
    }

    fun increase(node: QueueNode) {
        node.inc()
        adaptSingleNodeChange(queue.indexOf(node))
    }

    fun insert(node: QueueNode) {
        queue.add(node)
        adaptSingleNodeChange(queue.size - 1)
    }

    fun size(): Int = queue.size

    private fun rebuildMaxHeap() = (0..queue.size / 2).forEach { heapMaximize(it) }

    private fun adaptSingleNodeChange(idx: Int) {
        var parent = idx.parent()
        while (parent != -1) {
            heapMaximize(parent)
            parent = parent.parent()
        }
    }

    private fun heapMaximize(idx: Int) {
        val l = idx.left()
        val r = idx.right()
        var largest = if (l < queue.size && queue[l] > queue[idx]) l else idx
        largest = if (r < queue.size && queue[r] > queue[largest]) r else largest
        if (largest != idx) {
            val tmp = queue[largest]
            queue[largest] = queue[idx]
            queue[idx] = tmp
            heapMaximize(largest)
        }

    }

    private fun Int.parent() = if (this == 0) -1 else (this - 1) / 2
    private fun Int.left() = this * 2 + 1
    private fun Int.right() = this * 2 + 2

    class QueueNode(var value: Int) : Comparable<QueueNode> {
        override fun compareTo(other: QueueNode): Int {
            return value - other.value
        }

        operator fun inc(): QueueNode = this.also { value++ }

    }

}

fun main() {
    val priorityQueue = PriorityQueue()
    val node = PriorityQueue.QueueNode(2)
    priorityQueue.insert(node)
    assertEquals(node, priorityQueue.max())

    priorityQueue.insert(PriorityQueue.QueueNode(12))
    assertNotEquals(node, priorityQueue.max())

    priorityQueue.extractMax()
    assertEquals(node, priorityQueue.max())

    val newNode = PriorityQueue.QueueNode(1)
    priorityQueue.insert(newNode)
    priorityQueue.increase(newNode)
    priorityQueue.increase(newNode) // now is 3
    assertEquals(2, priorityQueue.size())
    assertNotEquals(node, priorityQueue.max())
}