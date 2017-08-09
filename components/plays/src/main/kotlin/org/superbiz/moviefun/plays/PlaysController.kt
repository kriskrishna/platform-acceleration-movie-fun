package org.superbiz.moviefun.plays

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/plays")
class PlaysController(private val playsRepository: PlaysRepository) {

    val logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping
    fun addPlay(@RequestBody play: Play) = playsRepository.addPlay(play)

    @GetMapping
    fun index() = playsRepository.getPlays()

    @GetMapping("/{playId}")
    fun details(@PathVariable playId: Long) = playsRepository.find(playId)
}
