package org.superbiz.moviefun.plays

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import javax.sql.DataSource

@Configuration
@EnableAsync
@EnableScheduling
class PlaysUpdateScheduler(dataSource: DataSource, private val albumsUpdater: PlaysUpdater) {

    private val jdbcTemplate: JdbcTemplate = JdbcTemplate(dataSource)
    private val logger = LoggerFactory.getLogger(javaClass)


    @Scheduled(initialDelay = 5_000, fixedRate = 15_000)
    fun run() {
        try {
            logger.debug("Checking for plays task to start")

            if (startPlaySchedulerTask()) {
                logger.debug("Starting plays update")

                albumsUpdater.update()

                logger.debug("Finished plays update")
            } else {
                logger.debug("Nothing to start")
            }

        } catch (e: Throwable) {
            logger.error("Error while updating plays", e)
        }

    }

    private fun startPlaySchedulerTask(): Boolean {
        val updatedRows = jdbcTemplate.update(
                "UPDATE play_scheduler_task" +
                        " SET started_at = now()" +
                        " WHERE started_at IS NULL" +
                        " OR started_at < date_sub(now(), INTERVAL 2 MINUTE)"
        )

        return updatedRows > 0
    }
}
