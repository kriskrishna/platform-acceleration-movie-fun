package org.superbiz.moviefun.playsapi

import org.superbiz.moviefun.playsapi.CharactersInPlayInfo


data class PlayInfo(val id: Long?, val charactersInPlay: List<CharactersInPlayInfo>?, val title: String, val dialogue: String?, val playSetting: String?, val stageDirection: String?, val theme: String?, val year: Int, val rating: Int)



