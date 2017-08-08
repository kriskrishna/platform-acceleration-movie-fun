package org.superbiz.moviefun.albumsapi

import org.apache.tika.io.IOUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.lang.String.format
import java.net.URISyntaxException

@Controller
@RequestMapping("/albums")
class AlbumsController @Autowired constructor(val albumsClient: AlbumsClient, val coverCatalog: CoverCatalog) {

    val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping
    fun index(model: MutableMap<String, Any>): String {
        model.put("albums", albumsClient.albums)
        return "albums"
    }

    @GetMapping("/{albumId}")
    fun details(@PathVariable albumId: Long, model: MutableMap<String, Any>): String {
        model.put("album", albumsClient.find(albumId))
        return "albumDetails"
    }

    @PostMapping("/{albumId}/cover")
    fun uploadCover(@PathVariable albumId: Long?, @RequestParam("file") uploadedFile: MultipartFile): String {
        if (uploadedFile.size > 0) {
            try {
                coverCatalog.uploadCover(albumId!!, uploadedFile.inputStream, uploadedFile.contentType)
            } catch (e: IOException) {
                logger.warn("Error while uploading album cover", e)
            }

        }

        return format("redirect:/albums/%d", albumId)
    }

    @GetMapping("/{albumId}/cover")
    @Throws(IOException::class, URISyntaxException::class)
    fun getCover(@PathVariable albumId: Long): HttpEntity<ByteArray> {
        val coverBlob = coverCatalog.getCover(albumId)

        val imageBytes = IOUtils.toByteArray(coverBlob.inputStream)

        val headers = HttpHeaders()
        headers.contentType = MediaType.parseMediaType(coverBlob.contentType)
        headers.contentLength = imageBytes.size.toLong()

        return HttpEntity(imageBytes, headers)
    }
}
