package graph.traversal

import graph.Node
import java.util.Stack

/**
 * DFS is a graph traversal algorithm that explores deeply before backtracking.
 *
 * The time complexity of DFS is O(V + E), where V is the number of vertices and E is the number of edges.
 * */
fun dfs(startNode: Node, visited: BooleanArray): List<Int> {
    val stack: Stack<Node> = Stack<Node>()
    stack.push(startNode)
    val pathRecord = mutableListOf<Int>()

    while (stack.isNotEmpty()) {
        val currentNode = stack.pop()
        if (visited[currentNode.id]) continue
        visited[currentNode.id] = true
        pathRecord.add(currentNode.id)

        // lower vertex first
        for (neighbor in currentNode.neighbors.sortedByDescending { it.id }) {
            if (visited[neighbor.id].not()) {
                stack.push(neighbor)
            }
        }
    }

    return pathRecord
}
