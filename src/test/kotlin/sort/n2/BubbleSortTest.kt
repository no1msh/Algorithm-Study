package sort.n2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BubbleSortTest {
    @Test
    fun `버블 정렬 알고리즘을 이용하여 정렬할 수 있다`() {
        // given
        val target = intArrayOf(3, 2, 5, 4, 1)

        // when
        BubbleSort.sort(target)

        // then
        assertThat(target).isEqualTo(intArrayOf(1, 2, 3, 4, 5))
    }

    @Test
    fun `버블 정렬 알고리즘을 이용하여 10만개의 원소를 가진 배열을 정렬할 수 있다`() {
        // given
        val expect = IntArray(100_000) { it }
        val target = expect.reversed().toIntArray()

        // when
        BubbleSort.sort(target)

        // then
        assertThat(target).isEqualTo(expect)
    }
}
