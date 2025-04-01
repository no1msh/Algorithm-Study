package sort.util

fun IntArray.swapElements(leftIndex: Int, rightIndex: Int) {
    val temp = this[leftIndex]
    this[leftIndex] = this[rightIndex]
    this[rightIndex] = temp
}
