package org.superbiz.moviefun.playsapi

import org.springframework.stereotype.Component
import org.superbiz.moviefun.albumsapi.PlayInfo
import java.util.Arrays.asList

@Component
class PlayFixtures {

    fun load(): List<PlayInfo> {
        return asList(
                PlayInfo(null, CharactersInPlayInfo(null,"Ram", "Ramayna"),  "Ramayna", "Ram-dialog",null, null,  null, 1997, 9),
                PlayInfo(null, CharactersInPlayInfo(null,"Sita", "Ramayna"),  "Ramayna", "Sita-dialog",null, null,  null, 1997, 9),
                PlayInfo(null, CharactersInPlayInfo(null,"Lakshman", "Ramayna"),  "Ramayna", "Lakshman-dialog",null, null,  null, 1997, 9),
                PlayInfo(null, CharactersInPlayInfo(null,"Achilles", "Troy"),  "Troy", "Achilles-dialog",null, null,  null, 1997, 9),
                PlayInfo(null, CharactersInPlayInfo(null,"Hector", "Troy"),  "Troy", "Hector-dialog",null, null,  null, 1997, 9),
                PlayInfo(null, CharactersInPlayInfo(null,"Zeus", "Troy"),  "Troy", "Zeus-dialog",null, null,  null, 1997, 9),
                PlayInfo(null, CharactersInPlayInfo(null,"Protagonist", "Hamlet"),  "Hamlet", "Protagonist-dialog",null, null,  null, 1997, 9),
                PlayInfo(null, CharactersInPlayInfo(null,"Antagonist", "Hamlet"),  "Hamlet", "Antagonist-dialog",null, null,  null, 1997, 9),
                PlayInfo(null, CharactersInPlayInfo(null,"Foil", "Hamlet"),  "Hamlet", "Foil-dialog",null, null,  null, 1997, 9)
        )
    }
}
