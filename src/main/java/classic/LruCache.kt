package classic

import java.util.*

class LruCache<K : Any, V : Any>(private val capacity: Int) {
    private var used: Int = 0

    private val cacheMap = LinkedHashMap<K, CacheNode<K, V>>()
    private var dualList: CacheNode<K, V>? = null

    init {
        if (capacity < 1) throw IllegalArgumentException("This capacity is not acceptable")
        this.used = 0
    }

    fun add(key: K, value: V) {
        // empty
        if (dualList == null) {
            val head = CacheNode<K, V>()
            head.key = key
            head.value = value
            head.pre = head
            head.next = head
            cacheMap[key] = head
            dualList = head
            used++
            return
        }

        // full
        if (used == capacity) {
            val last = dualList!!.pre
            cacheMap.remove(last.key)
            last.key = key
            last.value = value
            cacheMap[key] = last
            return
        }

        // else
        val node = CacheNode<K, V>()
        node.key = key
        node.value = value
        node.pre = dualList!!.pre
        node.next = dualList!!
        node.pre.next = node
        dualList!!.pre = node
        used++
        dualList = node
        cacheMap[key] = node
    }

    operator fun get(key: K): V? {
        add(key, remove(cacheMap[key] ?: return null)!!.value)
        println(cacheMap.values.joinToString())
        return cacheMap[key]!!.value
    }

    fun remove(key: K): V? {
        val nodeToRemove = remove(cacheMap[key] ?: return null)
        return nodeToRemove?.value
    }

    private fun remove(node: CacheNode<K, V>): CacheNode<K, V>? {
        dualList ?: return null
        if (used == 1 && dualList == node) {
            dualList = null
            return node
        }

        val pre = node.pre
        val next = node.next
        pre.next = next
        next.pre = pre
        return node
    }

    private class CacheNode<K : Any, V : Any> {
        lateinit var key: K
        lateinit var value: V
        lateinit var pre: CacheNode<K, V>
        lateinit var next: CacheNode<K, V>

        override fun toString(): String {
            return "CacheNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}'.toString()
        }
    }
}