package com.octobank.jetpack_3_1.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    suspend fun  saveAppEnter()

    fun readAppEntry(): Flow<Boolean>
}