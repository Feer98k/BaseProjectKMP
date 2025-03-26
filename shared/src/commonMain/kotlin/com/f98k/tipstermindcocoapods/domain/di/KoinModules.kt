package com.f98k.tipstermindcocoapods.domain.di


import com.f98k.tipstermindcocoapods.data.repository.HomeRepository
import com.f98k.tipstermindcocoapods.data.repository.HomeRepositoryImpl
import com.f98k.tipstermindcocoapods.data.repository.RemoteConfig
import com.f98k.tipstermindcocoapods.data.repository.RemoteConfigImpl
import com.f98k.tipstermindcocoapods.domain.usecase.HomeUseCase
import com.f98k.tipstermindcocoapods.domain.usecase.HomeUseCaseImpl
import com.f98k.tipstermindcocoapods.ui.home.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}
val repositoryModule = module {
    single<RemoteConfig> { RemoteConfigImpl() }
    single<HomeRepository> { HomeRepositoryImpl() }
}

val useCaseFactory = module {
    single<HomeUseCase> { HomeUseCaseImpl(get(), get()) }
}