package search

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BinarySearchTreeTest {
    @ParameterizedTest
    @CsvSource("1, true", "2, true", "3, true", "4, true", "5, true", "0, false", "6, false")
    fun `should return true when key exists`(value: Int, isExist: Boolean) {
        // given
        val binarySearchTree = BinarySearchTree().apply {
            insert(3)
            insert(2)
            insert(1)
            insert(5)
            insert(4)
        }

        // when
        val actual = binarySearchTree.search(value)

        // then
        assertThat(actual).isEqualTo(isExist)
    }
}
