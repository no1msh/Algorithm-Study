package sort

object InsertionSort : ON2Sort {
    /**
     * 삽입정렬은 비교 기반 정렬 알고리즘으로 배열의 앞에서부터 순회하며 정렬된 부분에
     *
     * 최악의 경우 매번 배열 전체를 순회하며 하는 것이 아닌 n 번째 값을 정렬하려면 n - 1번 순회하게 됩니다.
     *
     * (n - 1) + (n - 2) + ... + 2 + 1 = n(n - 1) / 2 이므로 시간 복잡도는 O(n²)입니다.
     *
     * 다른 정렬 알고리즘에 비해 비교적 느린 편이지만, 같은 O(n²) 시간복잡도를 가진 정렬 알고리즘에 비해 상대적으로 빠릅니다.
     *
     * 별도의 메모리 공간을 필요로 하진 않는다는 장점이 있습니다.
     *
     * 안정정렬입니다.
     **/
    override fun sort(array: IntArray) {
        // 1번 인덱스 부터 시작
        for (indexForSort in 1..array.lastIndex) {
            val numberForSort = array[indexForSort] // 정렬을 할 값

            var sortedIndex = indexForSort - 1 // 정렬된 인덱스의 최대 값 == 정렬할 값의 인덱스 - 1

            while (sortedIndex >= 0 && array[sortedIndex] > numberForSort) { // 정렬된 값이 정렬을 할 값보다 크다면
                array[sortedIndex + 1] = array[sortedIndex] // 정렬된 값을 한칸 뒤로 보낸다.
                sortedIndex-- // 이전 값도 정렬을 할 값보다 크고 작음을 확인해야하니 정렬된 값 인덱스를 하나 감소한다.
            }

            array[sortedIndex + 1] = numberForSort // 정렬 할 값의 위치를 찾았다면 정렬된 인덱스 바로 뒤에 할당한다.
        }
    }
}
