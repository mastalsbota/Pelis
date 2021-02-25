package com.mastalsbota.data.source

interface LocationDataSource {
    suspend fun findLastRegion(): String?
}
