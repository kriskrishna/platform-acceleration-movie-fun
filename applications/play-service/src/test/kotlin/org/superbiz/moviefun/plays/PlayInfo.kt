package org.superbiz.moviefun.albumsapi

import org.superbiz.moviefun.playsapi.CharactersInPlay


data class PlayInfo(val id: Long?, val charactersInPlay: List<CharactersInPlay>?, val title: String, val dialogue: String?, val playSetting: String?, val stageDirection: String?, val theme: String?, val year: Int, val rating: Int)



