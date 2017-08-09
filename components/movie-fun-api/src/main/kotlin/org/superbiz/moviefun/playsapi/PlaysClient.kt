package org.superbiz.moviefun.albumsapi

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod.GET
import org.springframework.web.client.RestOperations

class PlaysClient(private val playsUrl: String, private val restOperations: RestOperations) {

    fun addPlay(play: PlayInfo) {
        restOperations.postForEntity<PlayInfo>(playsUrl, play, PlayInfo::class.java)
    }

    fun find(id: Long): PlayInfo {
        return restOperations.getForEntity<PlayInfo>(playsUrl + "/" + id, PlayInfo::class.java).body
    }

    val plays: List<PlayInfo>
        get() {
            val playListType = object : ParameterizedTypeReference<List<PlayInfo>>() {

            }

            return restOperations.exchange(playsUrl, GET, null, playListType).body
        }
}
