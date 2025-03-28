package com.f98k.tipstermindcocoapods.domain.usecase

import com.f98k.tipstermindcocoapods.data.model.BottomBarList

interface MainUseCase {
    suspend fun fetchBottomBarList(): BottomBarList
}