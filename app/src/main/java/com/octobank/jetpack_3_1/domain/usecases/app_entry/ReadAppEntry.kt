package com.octobank.jetpack_3_1.domain.usecases.app_entry

import com.octobank.jetpack_3_1.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow


class ReadAppEntry(
    private val localUserManager: LocalUserManager,
) {
     operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}