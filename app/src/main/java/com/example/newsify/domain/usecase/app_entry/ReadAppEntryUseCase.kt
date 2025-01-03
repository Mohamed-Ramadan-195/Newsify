package com.example.newsify.domain.usecase.app_entry

import com.example.newsify.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke() : Flow<Boolean> = localUserManager.readAppEntry()
}