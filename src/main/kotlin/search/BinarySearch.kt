package search

class BinarySearch(private val array: IntArray) {
    /**
     * To perform binary search, the array must be sorted, and the search interval in half each time.
     *
     * The logic below was written using recursion.
     *
     * Time complexity of binary search
     * - In best case, the key is found at the first index, so the time complexity is O(1).
     * - In worst case, the key is found at the first or last index, so the time complexity is O(logn).
     * - In average case, the time complexity is O(logn).
     * */
    fun search(key: Int, startIndex: Int = 0, endIndex: Int = array.lastIndex): Int {
        if (endIndex >= startIndex) {
            val mid = startIndex + (endIndex - startIndex) / 2

            if (array[mid] == key) return mid

            if (array[mid] > key) {
                return search(key = key, startIndex = startIndex, endIndex = mid - 1)
            }
            if (array[mid] < key) {
                return search(key = key, startIndex = mid + 1, endIndex = endIndex)
            }
        }

        throw IllegalArgumentException("Not found: $key")
    }
}
