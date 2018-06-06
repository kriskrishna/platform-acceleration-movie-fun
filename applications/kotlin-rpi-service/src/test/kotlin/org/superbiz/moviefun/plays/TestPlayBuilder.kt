package org.superbiz.moviefun.plays

import org.superbiz.moviefun.albumsapi.PlayInfo
import org.superbiz.moviefun.playsapi.CharactersInPlay

/**
 * Created by kshitizkriskrishna on 8/9/17.
 */
data class TestPlayBuilder(val tiltle: String = "test", val dialog : String = "testDialog") {
    fun build() = PlayInfo( null, listOf(CharactersInPlay("Ram"), CharactersInPlay("Sita"), CharactersInPlay("Lakshman")) ,
            "Ramayna", "Ram-dialog",null, null,  null, 1997, 9)

}

