package com.example.newsify.domain.usecase.app_entry

import com.example.newsify.domain.manager.LocalUserManager

class SaveAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() = localUserManager.saveAppEntry()
}