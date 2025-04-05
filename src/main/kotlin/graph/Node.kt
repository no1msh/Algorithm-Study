package graph

data class Node(
    val id: Int,
    val neighbors: MutableList<Node> = mutableListOf(),
)

fun Array<Node>.connect(a: Int, b: Int) {
    this[a].neighbors.add(this[b])
    this[b].neighbors.add(this[a])
}
