package sort.nlogn

private const val ROOT_INDEX = 0

object HeapSort {
    fun sort(array: IntArray) {
        // 1. 입력 배열을 초기 힙으로 만드는 과정
        buildHeapByInsertion(array)

        // 2. 최댓값 삭제와 힙으로 재구성하는 과정을 데이터의 개수만큼 반복
        var heapSize = array.size
        for (endIndex in array.lastIndex downTo 1) { // 한번 반복할 때마다 맨 뒤의 값이 정렬됨
            swap(array = array, index1 = endIndex, index2 = ROOT_INDEX)
            heapSize--
            siftDown(array = array, heapSize = heapSize)
        }
    }

    private fun buildHeapByInsertion(array: IntArray) {
        for (index in array.indices) {
            var currentIndex = index
            var parentNodeIndex = getParentIndex(currentIndex)

            while (parentNodeIndex >= ROOT_INDEX && array[currentIndex] > array[parentNodeIndex]) {
                swap(array, currentIndex, parentNodeIndex)
                currentIndex = parentNodeIndex
                parentNodeIndex = getParentIndex(currentIndex)
            }
        }
    }

    private fun siftDown(array: IntArray, heapSize: Int) { // 말단 노드와 루트 노드를 바꿨으므로 힙 재정렬
        var currentParentIndex = ROOT_INDEX

        while (true) {
            val childIndices = getChildIndices(currentParentIndex)
            val leftChildIndex = childIndices.first
            val rightChildIndex = childIndices.second
            var largestValueIndex = currentParentIndex

            if (leftChildIndex < heapSize && array[leftChildIndex] > array[largestValueIndex]) {
                largestValueIndex = leftChildIndex
            }

            if (rightChildIndex < heapSize && array[rightChildIndex] > array[largestValueIndex]) {
                largestValueIndex = rightChildIndex
            }

            if (largestValueIndex != currentParentIndex) { // 부모 노드의 값이 자식 노드들과 비교해 제일 큰 값이 아니라면
                swap(array, largestValueIndex, currentParentIndex) // 제일 큰 값인 자식 노드를 부모 노드의 값과 교체
                currentParentIndex = largestValueIndex // 값을 교체 했으니 부모 노드 재할당
                continue
            }
            break
        }
    }

    fun getParentIndex(childNodeIndex: Int): Int {
        return (childNodeIndex - 1) / 2
    }

    fun getChildIndices(parentNodeIndex: Int): Pair<Int, Int> {
        return Pair(parentNodeIndex * 2 + 1, parentNodeIndex * 2 + 2)
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}
