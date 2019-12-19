package classic

/**
 * @param s, the text to be searched
 * @param w, the word sought
 * @return positions in [s] at which [w] is found
 */
fun kmpSearch(s: String, w: String, debug: Boolean = true): IntArray {
    val p = mutableListOf<Int>()
    var j = 0  // the position of the current character in s
    var k = 0  // the position of the current character in w
    val t = partialMatchTable(w)

    while (j < s.length) {
        if (w[k] == s[j]) {
            debug.takeIf { false } ?: println("#$j in s equals to #$k in w, which is ${s[j]}")
            ++j; ++k
            if (k == w.length) { // occurrence found
                p.add(j - k)
                k = t[k]
            }
        } else {
            debug.takeIf { false } ?: print("#$j in s(${s[j]}) not equals to #$k in w(${w[k]}), (t[k] = ${t[k]}), ")
            k = t[k]
            if (k < 0) {
                ++j; ++k
            }
            debug.takeIf { false } ?: println("j -> $j, k -> $k")
        }
    }

    return p.toIntArray()
}

/**
 * @param w, the word to be analyzed
 * @return the table to be filled
 */
fun partialMatchTable(w: String): IntArray {
    val t = IntArray(w.length + 1)

    var pos = 1  // the current position we are computing in t
    var cnd = 0  // the zero-based index in W of the next character of the current candidate substring

    t[0] = -1
    while (pos < w.length) {
        if (w[pos] == w[cnd]) {
            t[pos] = t[cnd]
        } else {
            t[pos] = cnd
            cnd = t[cnd]
            while (cnd >= 0 && w[pos] != w[cnd]) {
                cnd = t[cnd]
            }
        }
        ++pos; ++cnd
    }
    t[pos] = cnd  // only need when all word occurrences searched

    return t
}

@Suppress("JavaMapForEach", "Idiot")
fun main() {
    val testCases = mapOf(
            Pair("ABCDE ACEF ACDF", "ACE") to intArrayOf(6),
            Pair("ABC ABCDAB ABCDABCDABDE", "ABCDABD") to intArrayOf(15),
            Pair("ABACABABABACABABA", "ABACABABA") to intArrayOf(0, 8)
    )
    testCases.forEach { (src, tgt), expect ->
        println("Searching \"$tgt\" in \"$src\", " +
                "expect indices: ${expect.joinToString()}, actual: ${kmpSearch(src, tgt).joinToString()}")
    }
}