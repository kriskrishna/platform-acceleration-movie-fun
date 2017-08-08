package org.superbiz.moviefun.albums

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/albums")
class AlbumsController(private val albumsRepository: AlbumsRepository) {

    val logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping
    fun addAlbum(@RequestBody album: Album) = albumsRepository.addAlbum(album)

    @GetMapping
    fun index() = albumsRepository.getAlbums()

    @GetMapping("/{albumId}")
    fun details(@PathVariable albumId: Long) = albumsRepository.find(albumId)
}
