package classic

import java.util.*

class LruCache<K : Any, V : Any>(private val capacity: Int) {
    private val cacheMap = mutableMapOf<K, CacheNode<K, V>>()

    /*
     * We are assuming the build-in list performs get/remove in O(1) for convenience
     */
    private var dualList = LinkedList<CacheNode<K, V>>()

    init {
        if (capacity < 1) throw IllegalArgumentException("This capacity is not acceptable")
    }

    fun add(key: K, value: V) {
        val cacheNode = CacheNode(key, value)
        if (dualList.size == capacity) {
            remove(if (cacheMap.contains(key)) key else dualList.last.key)
        }
        dualList.addFirst(cacheNode)
        cacheMap[key] = cacheNode
    }

    fun get(key: K): V? {
        val value = cacheMap[key] ?: return null

        dualList.remove(value)
        dualList.addFirst(value)
        return value.value
    }

    fun remove(key: K): V? {
        cacheMap[key]?.let {
            dualList.remove(cacheMap.remove(key))
            return it.value
        } ?: return null
    }

    private class CacheNode<K : Any, V : Any>(var key: K, var value: V)
}
