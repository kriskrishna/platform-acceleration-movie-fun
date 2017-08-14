package org.superbiz.moviefun.playsapi

import org.springframework.stereotype.Component
import java.util.Arrays.asList

@Component
class PlayFixtures {

    fun load(): List<PlayInfo> {
        return asList(
                PlayInfo(null, listOf(CharactersInPlayInfo("Ram"), CharactersInPlayInfo("Sita"),CharactersInPlayInfo("Lakshman")) ,
                        "Ramayna", "Ram-dialog",null, null,  null, 1997, 9),

                PlayInfo(null, listOf(CharactersInPlayInfo("Achilles"), CharactersInPlayInfo("Hector"),CharactersInPlayInfo("Zeus")) ,
                        "Troy", "Troy-dialog",null, null,  null, 1997, 9),


                PlayInfo(null, listOf(CharactersInPlayInfo("Protagonist"), CharactersInPlayInfo("Antagonist"),CharactersInPlayInfo("Foil")) ,
                        "Hamlet", "Hamlet-dialog",null, null,  null, 1997, 9)

        )
    }

}
