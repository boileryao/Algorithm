package leetcode

import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by boileryao on 2020/2/9.
 * Licensed under WTFPL©2020.
 */
class TrianglesTest {
    private val triangles = Triangles()

    @Test
    fun testMinimumTotal() {
        val triangle = listOf(
                listOf(2),
                listOf(3, 4),
                listOf(6, 5, 7),
                listOf(4, 1, 8, 3)
        )
        Assert.assertEquals(triangles.minimumTotal(triangle), 11)
    }
}
