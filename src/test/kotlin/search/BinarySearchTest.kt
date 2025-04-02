package search

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BinarySearchTest {
    @ParameterizedTest
    @CsvSource("1, 0", "2, 1", "5, 4", "9, 8")
    fun `should return index when element exists`(key: Int, expectedIndex: Int) {
        // given
        val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val binarySearch = BinarySearch(array)

        // when
        val actual = binarySearch.search(key)

        // then
        assertThat(actual).isEqualTo(expectedIndex)
    }

    @Test
    fun `should throw exception when element doesn't exists`() {
        // given
        val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val binarySearch = BinarySearch(array)

        // when
        val actual = assertThrows<IllegalArgumentException> { binarySearch.search(0) }

        // then
        assertThat(actual.message).isEqualTo("Not found: 0")
    }
}
