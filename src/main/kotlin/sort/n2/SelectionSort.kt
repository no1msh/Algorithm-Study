package sort.n2

import sort.util.swapElements

object SelectionSort {
    /**
     * 선택정렬은 비교 기반 정렬 알고리즘으로 배열 전체를 돌며 최소값을 찾아 오름차순으로 정렬합니다.
     *
     * 매번 배열 전체를 순회하며 하는 것이 아닌 n 번째 값을 정렬하려면 n - 1번 순회하게 합니다.
     *
     * (n - 1) + (n - 2) + ... + 2 + 1 = n(n - 1) / 2 이므로 시간 복잡도는 O(n²)입니다.
     *
     * 다른 정렬 알고리즘에 비해 비교적 느린 편이지만, 별도의 메모리 공간을 필요로 하진 않는다는 장점이 있습니다.
     *
     * 최소값을 찾으면 검색하던 인덱스 값을 교환을 하는 방식을 사용하여 불안정 정렬입니다.
     **/
    fun sort(array: IntArray) {
        var indexForSort = 0
        while (indexForSort < array.size) {
            var minIndex = indexForSort

            for (index in indexForSort..array.lastIndex) {
                if (array[minIndex] > array[index]) {
                    minIndex = index
                }
            }

            array.swapElements(indexForSort, minIndex)

            indexForSort++
        }
    }
}
