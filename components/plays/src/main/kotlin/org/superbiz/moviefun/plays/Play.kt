package org.superbiz.moviefun.plays

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import javax.persistence.*


@Entity
data class Play @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,
        //@get:JsonBackReference("charactersInPlay")
        @OneToMany( mappedBy = "play", targetEntity= CharactersInPlay::class, cascade = arrayOf(CascadeType.ALL))
        val charactersInPlay: List<CharactersInPlay>?,
        val title: String? = null,
        val dialogue: String? = null,
        val playSetting: String? = null,
        val stageDirection: String? = null,
        val theme: String? = null,
        val year: Int = 0,
        val rating: Int = 0
) {

    fun hasId(): Boolean {
        return id != null
    }

    fun isEquivalent(other: Play): Boolean {
        if (year != other.year) return false
        if (charactersInPlay == other.charactersInPlay) return false
        if (title != other.title) return false
        if (dialogue != other.dialogue) return false
        if (playSetting != other.playSetting) return false
        if (stageDirection != other.stageDirection) return false
        if (theme != other.theme) return false

        return true
    }

}
