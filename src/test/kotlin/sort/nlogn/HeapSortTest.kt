package sort.nlogn

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class HeapSortTest {
    @Test
    fun `배열의 크기가 홀수일 때 정렬할 수 있다`() {
        // given
        val target = intArrayOf(42, 18, 39, 24, 53)
        HeapSort.sort(target)

        assertThat(target).isEqualTo(intArrayOf(18, 24, 39, 42, 53))
    }

    @Test
    fun `배열의 크기가 짝수일 때 정렬할 수 있다`() {
        // given
        val target = intArrayOf(42, 18, 39, 24, 62, 53)
        HeapSort.sort(target)

        assertThat(target).isEqualTo(intArrayOf(18, 24, 39, 42, 53, 62))
    }

    @Test
    fun `배열의 크기가 1이어도 정렬된다`() {
        // given
        val target = intArrayOf(42)
        HeapSort.sort(target)

        assertThat(target).isEqualTo(intArrayOf(42))
    }

    @ParameterizedTest
    @CsvSource("1, 0", "2, 0", "3, 1", "4, 1", "5, 2", "6, 2", "7, 3", "8, 3")
    fun `자식 노드의 인덱스로 부모노드의 인덱스를 구할 수 있다`(childNodeIndex: Int, expectedParentNodeIndex: Int) {
        // given
        /*
                  0
                /   \
               1     2
              / \   / \
             3   4 5   6
            / \
           7   8
        * */

        // when
        val actual = HeapSort.getParentIndex(childNodeIndex)

        // then
        assertThat(actual).isEqualTo(expectedParentNodeIndex)
    }

    @ParameterizedTest
    @CsvSource("0,1,2", "1,3,4", "2,5,6", "3,7,8")
    fun `부모 노드의 인덱스로 자식 노드의 인덱스를 구할 수 있다`(
        parentNodeIndex: Int,
        expectedLeftChildNodeIndex: Int,
        expectedRightChildNodeIndex: Int,
    ) {
        // given
        /*
                  0
                /   \
               1     2
              / \   / \
             3   4 5   6
            / \
           7   8
        * */

        // when
        val actual = HeapSort.getChildIndices(parentNodeIndex)

        // then
        assertThat(actual).isEqualTo(Pair(expectedLeftChildNodeIndex, expectedRightChildNodeIndex))
    }
}
