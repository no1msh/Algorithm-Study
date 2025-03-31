package sort.nlogn

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MergeSortTest {
    @Test
    fun `배열의 크기가 홀수일 때 정렬할 수 있다`() {
        // given
        val target = intArrayOf(42, 18, 39, 24, 53)
        MergeSort.sort(target, 0, target.lastIndex)

        assertThat(target).isEqualTo(intArrayOf(18, 24, 39, 42, 53))
    }

    @Test
    fun `배열의 크기가 짝수일 때 정렬할 수 있다`() {
        // given
        val target = intArrayOf(42, 18, 39, 24, 62, 53)
        MergeSort.sort(target, 0, target.lastIndex)

        assertThat(target).isEqualTo(intArrayOf(18, 24, 39, 42, 53, 62))
    }

    @Test
    fun `배열의 크기가 1이어도 정렬된다`() {
        // given
        val target = intArrayOf(42)
        MergeSort.sort(target, 0, target.lastIndex)

        assertThat(target).isEqualTo(intArrayOf(42))
    }
}
