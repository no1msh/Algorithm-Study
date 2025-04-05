package graph.traversal

import graph.Node
import graph.connect
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DfsTest {
    @Test
    fun `should search deep nodes first`() {
        // given
        val n = 6
        val graph = Array(n + 1) { Node(id = it) }
        val visited = BooleanArray(n + 1)

        graph.connect(1, 2)
        graph.connect(1, 3)
        graph.connect(1, 4)
        graph.connect(2, 5)
        graph.connect(3, 5)
        graph.connect(4, 6)

        // when
        val actual = dfs(graph[1], visited)

        // then
        assertThat(actual).isEqualTo(listOf(1, 2, 5, 3, 4, 6))
    }
}
