package sort.nlogn

object QuickSort {
    /**
     * 비교 기반 정렬 알고리즘인 퀵 정렬(quick sort)은 합병 정렬과 마찬가지로 분할 정복 알고리즘 입니다.
     *
     * 배열에서 피벗(pivot)이라는 특정 값을 선택해 피벗보다 작은 값으로 구성된 배열과
     * 피벗보다 큰 값으로 구성된 배열로 분할해 정렬하는 방식입니다.
     *
     * 퀵 정렬의 평균적인 시간 복잡도는 O(nlogn)이며, 최악의 경우 O(n²) 입니다.
     *
     * 추가적인 저장공간을 필요로 하지 않기 때문에 제자리 정렬입니다.
     *
     * 값을 교환하는 과정에서 동일한 값의 순서가 바뀔 수 있기에 불안정 정렬입니다.
     *
     * 피벗을 어떻게 정하느냐에 따라 성능차이가 크게 납니다.
     * */

    fun sort(
        array: IntArray,
        startIndex: Int = 0,
        endIndex: Int = array.lastIndex,
    ) {
        if (startIndex < endIndex) {
            // 1. 피벗을 기준으로 두 부분배열로 분할
            // pivotIndex는 제자리를 잡은 피벗의 인덱스를 표시
            val pivotIndex = partition(array, startIndex, endIndex)

            // 2. 왼쪽 부분배열에 대한 퀵 정렬의 순환 호출
            sort(array, startIndex, pivotIndex - 1)

            // 3. 오른쪽 부분배열에 대한 퀵 정렬의 순환 호출
            sort(array, pivotIndex + 1, endIndex)
        }
    }

    private fun partition(array: IntArray, startIndex: Int, endIndex: Int): Int {
        val pivotValue = array[startIndex] // 피벗은 배열의 제일 처음 원소
        var smallerItemIndex = startIndex + 1

        for (currentIndex in (startIndex + 1)..endIndex) {
            if (array[currentIndex] < pivotValue) { // 피벗 값보다 작은 값들은
                if (currentIndex != smallerItemIndex) {
                    swap(array, currentIndex, smallerItemIndex)
                }
                smallerItemIndex++
            }
        }

        val finalPivotIndex = smallerItemIndex - 1 // 피벗보다 작은 값들의 맨 뒤
        swap(array, startIndex, finalPivotIndex) // 피벗 값이 있던 자리의 값과 피벗이 정렬된 자리의 값을 바꿈
        return finalPivotIndex // 반환된 피벗 값을 기준으로 왼쪽 부분배열과 오른쪽 부분배열을 정렬
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}
