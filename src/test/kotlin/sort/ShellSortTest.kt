package sort

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ShellSortTest {
    @Test
    fun `셸 정렬 알고리즘을 이용하여 정렬할 수 있다`() {
        // given
        val target = intArrayOf(3, 2, 5, 4, 1)

        // when
        ShellSort.sort(target)

        // then
        Assertions.assertThat(target).isEqualTo(intArrayOf(1, 2, 3, 4, 5))
    }

    @Test
    fun `셸 정렬 알고리즘을 이용하여 10만개의 원소를 가진 배열을 정렬할 수 있다`() {
        // given
        val expect = IntArray(100_000) { it }
        val target = expect.reversed().toIntArray()

        // when
        ShellSort.sort(target)

        // then
        Assertions.assertThat(target).isEqualTo(expect)
    }
}
