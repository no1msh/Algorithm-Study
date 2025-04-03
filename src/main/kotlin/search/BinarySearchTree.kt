package search

class BinarySearchTree {
    /**
     * A binary search tree (BST) follows all properties of a binary tree.
     *
     * For every node, the left subtree contains values less than the node's value,
     * and the right subtree contains values greater than the node's value.
     *
     * Time complexity of binary search tree
     * - Best case: The key is equal to the root node's value, so the time complexity is O(1).
     * - Worst case: The tree is skewed, and the operation takes time proportional to the height of the tree,
     * resulting in a time complexity of O(n).
     * - Average case: The tree is balanced. so the time complexity is O(log n).
     * */

    data class Node(
        val value: Int,
        var left: Node? = null,
        var right: Node? = null,
    )

    var root: Node? = null
        private set

    fun insert(newValue: Int) {
        root = insertRecursion(root, newValue)
    }

    private fun insertRecursion(node: Node?, newValue: Int): Node {
        node ?: return Node(newValue)

        if (newValue < node.value) {
            node.left = insertRecursion(node.left, newValue)
        }
        if (newValue > node.value) {
            node.right = insertRecursion(node.right, newValue)
        }
        return node
    }

    fun search(key: Int): Boolean {
        return searchRecursion(root, key)
    }

    private fun searchRecursion(node: Node?, key: Int): Boolean {
        node ?: return false

        return when {
            node.value == key -> true
            node.value < key -> searchRecursion(node.right, key)
            else -> searchRecursion(node.left, key)
        }
    }
}
