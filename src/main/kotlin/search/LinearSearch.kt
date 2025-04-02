package search

class LinearSearch(private val array: IntArray) {
    /**
     * Linear search is also known as sequential search.
     *
     * When performing a linear search, it searches for the key from first index of the array to the last.
     *
     * Linear search is efficient for small dataset.
     *
     * Time complexity of linear search
     * - In best case, the key is found at the first index, so the time complexity is O(1).
     * - In worst case, the key is found at the last index, so the time complexity is O(n).
     * - In average case, the time complexity is O(n).
     * */
    fun search(key: Int): Int {
        for ((index, element) in array.withIndex()) {
            if(element == key) {
                return index
            }
        }
        throw IllegalArgumentException("Not found: $key")
    }
}
