package org.superbiz.moviefun.plays

import com.fasterxml.jackson.databind.ObjectReader
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema.ColumnType
import com.fasterxml.jackson.dataformat.csv.CsvSchema.builder
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.superbiz.moviefun.CsvUtils
import org.superbiz.moviefun.blobstore.BlobStore

@Service
class PlaysUpdater(private val blobStore: BlobStore, private val playsRepository: PlaysRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val objectReader: ObjectReader

    init {

        val schema = builder()
                .addColumn("playCharacters")
                .addColumn("title")
                .addColumn("dialogue")
                .addColumn("playSetting")
                .addColumn("stageDirection")
                .addColumn("theme")
                .addColumn("year", ColumnType.NUMBER)
                .addColumn("rating", ColumnType.NUMBER)
                .build()

        objectReader = CsvMapper().readerFor(Play::class.java).with(schema)
    }


    fun update() {
        val maybeBlob = blobStore.get("plays.csv")

        if (!maybeBlob.isPresent) {
            logger.info("No plays.csv found when running PlaysUpdater!")
            return
        }

        val playsToHave = CsvUtils.readFromCsv<Play>(objectReader, maybeBlob.get().inputStream)
        val playsWeHave = playsRepository.getPlays()

        createNewPlays(playsToHave, playsWeHave)
        deleteOldPlays(playsToHave, playsWeHave)
        updateExistingPlays(playsToHave, playsWeHave)
    }


    private fun createNewPlays(playsToHave: List<Play>, playsWeHave: List<Play>) {
        val playsToCreate = playsToHave
                .filter { play -> playsWeHave.stream().noneMatch({ play.isEquivalent(it) }) }

        playsToCreate.forEach({ playsRepository.addPlay(it) })
    }

    private fun deleteOldPlays(playsToHave: List<Play>, playsWeHave: List<Play>) {
        val playsToDelete = playsWeHave
                .filter { play -> playsToHave.stream().noneMatch({ play.isEquivalent(it) }) }

        playsToDelete.forEach({ playsRepository.deletePlay(it) })
    }

    private fun updateExistingPlays(playsToHave: List<Play>, playsWeHave: List<Play>) {
        val playsToUpdate = playsToHave
                .map { play -> addIdToPlayIfExists(playsWeHave, play) }
                .filter({ it.hasId() })

        playsToUpdate.forEach({ playsRepository.updatePlay(it) })
    }

    private fun addIdToPlayIfExists(existingPlays: List<Play>, play: Play): Play {
        val maybeExisting = existingPlays.filter({ play.isEquivalent(it) }).firstOrNull()

        if (maybeExisting != null) {
            play.id = maybeExisting.id
        }

        return play
    }
}
