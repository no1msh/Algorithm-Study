package sort.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SwapElementsTest {
    @Test
    fun `인자로 받은 두 인덱스에 해당하는 값들을 서로 교환한다`() {
        // given
        val array = intArrayOf(1, 2, 4, 3, 5)

        // when
        array.swapElements(leftIndex = 2, rightIndex = 3)

        // then
        assertThat(array).isEqualTo(intArrayOf(1, 2, 3, 4, 5))
    }
}
