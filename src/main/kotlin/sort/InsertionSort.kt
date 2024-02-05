package sort

object InsertionSort : Sort {
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
    override fun sort(target: IntArray) {
        // 1번 인덱스 부터 시작
        for (i in 1..target.lastIndex) {
            val targetNumber = target[i]

            var j = i - 1

            while (j >= 0 && target[j] > targetNumber) {
                target[j + 1] = target[j]
                j--
            }

            target[j + 1] = targetNumber
        }
    }
}
