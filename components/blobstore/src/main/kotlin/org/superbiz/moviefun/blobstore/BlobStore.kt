package org.superbiz.moviefun.blobstore

import java.util.*

interface BlobStore {

    fun put(blob: Blob)

    operator fun get(name: String): Optional<Blob>
}
