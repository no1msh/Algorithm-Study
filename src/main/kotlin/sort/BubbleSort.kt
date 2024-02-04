package sort

object BubbleSort : Sort {
    /**
     * 버블정렬은 비교 기반 정렬 알고리즘으로 양옆에 위치한 두 값을 비교하면서 크기 순으로 정렬합니다.
     *
     * 배열의 맨 앞부터 원소 두개씩 짝을 지어 큰 값을 계속해서 뒤로 보내기 때문에 맨 마지막 인덱스의 값부터 정렬된다는 특징을 가집니다.
     *
     * 위 특징을 기반으로 매번 배열 전체를 순회하며 하는 것이 아닌 n 번째 값을 정렬하려면 n - 1번 순회하게 합니다.
     *
     * (n - 1) + (n - 2) + ... + 2 + 1 = n(n - 1) / 2 이므로 시간 복잡도는 O(n²)입니다.
     *
     * 다른 정렬 알고리즘에 비해 비교적 느린 편이지만, 별도의 메모리 공간을 필요로 하진 않는다는 장점이 있습니다.
     **/
    override fun sort(target: IntArray) {
        if (target.size <= 1) return

        var sortedIndex = 1
        while (!checkSorted(target)) {
            for (index in 0..(target.lastIndex - sortedIndex++)) {
                val nextIndex = (index + 1).coerceAtMost(target.lastIndex)

                if (target[index] > target[nextIndex]) {
                    val temp = target[index]
                    target[index] = target[nextIndex]
                    target[nextIndex] = temp
                }
            }
        }
    }

    /**
     * 정렬이 되었는지 확인하는 메서드입니다.
     *
     * 배열 전체를 순회하며 확인하므로 시간 복잡도는 O(n)입니다.
     *
     * @return: 정렬이 되어있는지 안되었는지 Boolean 값으로 반환
     **/
    private fun checkSorted(target: IntArray): Boolean {
        var previous = target.first()

        target.forEach {
            if (previous > it) return false
            previous = it
        }
        return true
    }
}
