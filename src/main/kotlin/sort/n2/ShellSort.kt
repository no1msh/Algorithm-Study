package sort.n2

object ShellSort {
    /**
     * 삽입정렬 최악의 경우의 단점을 보완한 정렬 알고리즘 입니다.
     *
     * 먼 거리의 요소들끼리 먼저 비교해서 정렬한 다음, 점점 간격을 줄여가며 정렬합니다.
     *
     * gap의 계산 방식에 따라 셀 정렬의 최악의 시간 복잡도는 O(n²)이고,
     *
     * 최선의 경우는 O(nlogn)로 이미 정렬된 경우입니다.
     *
     * 불안정 정렬이며, 제자리 정렬입니다.
     * */
    fun sort(array: IntArray) {
        var gap = array.size

        while (gap >= 1) {
            sort(gap = gap, array = array)
            gap /= 2
        }
    }

    private fun sort(gap: Int, array: IntArray) {
        for (index in gap..array.lastIndex) {
            val numberForSort = array[index]

            var sortedIndex = index

            while (sortedIndex >= gap && array[sortedIndex - gap] > numberForSort) {
                array[sortedIndex] = array[sortedIndex - gap]
                sortedIndex -= gap
            }

            array[sortedIndex] = numberForSort
        }
    }
}
