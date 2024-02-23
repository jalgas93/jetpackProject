package com.octobank.jetpack_3_1.domain.usecases

import com.octobank.jetpack_3_1.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager:LocalUserManager
){
    suspend operator fun invoke(){
        localUserManager.saveAppEnter()
    }
}