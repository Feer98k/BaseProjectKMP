package com.f98k.baseproject.domain.usecase

import com.f98k.baseproject.data.model.bottombar.BottomBarList
import com.f98k.baseproject.data.model.settings.SettingsItem
import com.f98k.baseproject.data.repository.main.MainRepository
import com.f98k.baseproject.domain.usecase.remoteconfig.RemoteConfigUseCase

class MainUseCaseImpl(
    private val remoteConfigUseCase: RemoteConfigUseCase,
    private val mainRepository: MainRepository
) : MainUseCase {

    override suspend fun fetchBottomBarList(): BottomBarList {
//        return when (val result =
//            remoteConfigUseCase.fetchRemoteConfigData(RemoteConfigEnum.BOTTOM_BAR_LIST)) {
//            is ResponseResource.Success -> result.data.fromJsonOrNull<BottomBarList>()
//                ?: getDefaultBottomBar()
//
//            is ResponseResource.Error -> getDefaultBottomBar()
//            is ResponseResource.Exception -> getDefaultBottomBar()
//        }
        return getDefaultBottomBar()
    }

    override suspend fun fetchSettingsList(): List<SettingsItem> {
        return mainRepository.fetchSettingsList()
    }

    private suspend fun getDefaultBottomBar(): BottomBarList {
        return mainRepository.getDefaultBottomBar()
    }
}