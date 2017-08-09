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

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Repository
class PlaysRepository(val entityManager: EntityManager) {

    @Transactional
    fun addPlay(play: Play) {
        entityManager.persist(play)
    }

    fun find(id: Long): Play {
        return entityManager.find(Play::class.java, id)
    }

    fun getPlays(): List<Play> {
        val cq = entityManager.criteriaBuilder.createQuery(Play::class.java)
        cq.select(cq.from(Play::class.java))
        return entityManager.createQuery(cq).resultList
    }

    @Transactional
    fun deletePlay(play: Play) {
        entityManager.remove(play)
    }

    @Transactional
    fun updatePlay(play: Play) {
        entityManager.merge(play)
    }
}
