package org.superbiz.moviefun.playsapi

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

@Controller
@RequestMapping("/plays")
class PlaysController @Autowired constructor(val playsClient: PlaysClient, val coverCatalog: PlayCoverCatalog) {

    val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping
    fun index(model: MutableMap<String, Any>): String {
        model.put("plays", playsClient.plays)
        return "plays"
    }

    @GetMapping("/{playId}")
    fun details(@PathVariable playId: Long, model: MutableMap<String, Any>): String {
        model.put("play", playsClient.find(playId))
        return "playDetails"
    }

    @PostMapping("/{playId}/cover")
    fun uploadCover(@PathVariable playId: Long?, @RequestParam("file") uploadedFile: MultipartFile): String {
        if (uploadedFile.size > 0) {
            try {
                coverCatalog.uploadCover(playId!!, uploadedFile.inputStream, uploadedFile.contentType)
            } catch (e: IOException) {
                logger.warn("Error while uploading play cover", e)
            }

        }

        return format("redirect:/plays/%d", playId)
    }

    @GetMapping("/{playId}/cover")
    fun getCover(@PathVariable playId: Long): HttpEntity<ByteArray> {
        val coverBlob = coverCatalog.getCover(playId)

        val imageBytes = IOUtils.toByteArray(coverBlob.inputStream)

        val headers = HttpHeaders()
        headers.contentType = MediaType.parseMediaType(coverBlob.contentType)
        headers.contentLength = imageBytes.size.toLong()

        return HttpEntity(imageBytes, headers)
    }
}
