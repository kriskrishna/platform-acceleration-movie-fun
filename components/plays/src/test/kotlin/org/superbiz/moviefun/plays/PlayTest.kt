package org.superbiz.moviefun.plays

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class PlayTest {

    @Test
    fun testIsEquivalent() {
        val persisted = Play(id = 10, playCharacters = arrayOf("Ram", "Lakshman", "Sita"), title = "Ramayana", year = 1997, rating = 8)

        val sameFromCsv = Play(playCharacters = arrayOf("Ram", "Lakshman", "Sita"), title = "Ramayana", year = 1997, rating = 9)
        assertThat(persisted.isEquivalent(sameFromCsv), `is`(true))

        val otherFromCsv = Play(id = 10, playCharacters = arrayOf("Achilles", "Hector", "Zeus"), title = "Troy", year = 1997, rating = 8)
        assertThat(persisted.isEquivalent(otherFromCsv), `is`(false))
    }
}
