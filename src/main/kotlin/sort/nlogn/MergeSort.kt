package sort.nlogn

object MergeSort {
    /**
     * 비교기반 알고리즘인 합병 정렬은 재귀를 사용한 분할 정복을 이용한 정렬입니다.
     *
     * 정렬하려는 배열의 크기가 1이하가 되게끔 분할된 각각의 배열은 다시 정렬을 거치며 하나의 배열로 합쳐집니다.
     *
     * 배열이 정렬되는데 O(n), 분할 또는 합병되는데 O(logn)이 걸리기 때문에 시간 복잡도는 O(nlogn)입니다.
     *
     * 배열을 분할하면서 생기는 임시 배열들이 필요하기에 공간 복잡도는 O(n)입니다.
     *
     * 어떤 데이터 순서를 가지던 최선, 최악 평균의 시간 복잡도가 모두 O(nlogn)입니다.
     *
     * LinkedList 정렬에 적합합니다.
     * LinkedList의 느린 접근 성능으로 퀵 정렬은 성능이 저하되며, 힙 정렬은 사용할 수도 없습니다.
     *
     * 안정 정렬입니다.
     **/
    fun sort(array: IntArray, startIndex: Int, endIndex: Int) {
        if (startIndex < endIndex) {
            val midIndex = (startIndex + endIndex) / 2

            sort(array, startIndex, midIndex)
            sort(array, midIndex + 1, endIndex)
            merge(array, startIndex, midIndex, endIndex)
        }
    }

    private fun merge(target: IntArray, startIndex: Int, midIndex: Int, endIndex: Int) {
        val left: List<Int> = target.slice(startIndex..midIndex)
        val right: List<Int> = target.slice((midIndex + 1)..endIndex)

        var i = 0
        var j = 0
        var indexForSort = startIndex

        while (i < left.size && j < right.size) {
            if (left[i] <= right[j]) {
                target[indexForSort] = left[i]
                i++
            } else {
                target[indexForSort] = right[j]
                j++
            }
            indexForSort++
        }

        while (i < left.size) {
            target[indexForSort] = left[i]
            i++
            indexForSort++
        }
        while (j < right.size) {
            target[indexForSort] = right[j]
            j++
            indexForSort++
        }
    }
}
