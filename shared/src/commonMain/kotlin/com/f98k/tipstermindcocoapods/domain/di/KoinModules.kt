package com.f98k.tipstermindcocoapods.domain.di


import com.f98k.tipstermindcocoapods.data.repository.home.HomeRepository
import com.f98k.tipstermindcocoapods.data.repository.home.HomeRepositoryImpl
import com.f98k.tipstermindcocoapods.data.repository.remoteconfig.RemoteConfig
import com.f98k.tipstermindcocoapods.data.repository.remoteconfig.RemoteConfigImpl
import com.f98k.tipstermindcocoapods.data.repository.search.SearchRepository
import com.f98k.tipstermindcocoapods.data.repository.search.SearchRepositoryImpl
import com.f98k.tipstermindcocoapods.domain.usecase.home.HomeUseCase
import com.f98k.tipstermindcocoapods.domain.usecase.home.HomeUseCaseImpl
import com.f98k.tipstermindcocoapods.domain.usecase.search.SearchUseCase
import com.f98k.tipstermindcocoapods.domain.usecase.search.SearchUseCaseImpl
import com.f98k.tipstermindcocoapods.ui.home.viewmodel.HomeViewModel
import com.f98k.tipstermindcocoapods.ui.search.viewmodel.SearchViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}
val repositoryModule = module {
    single<RemoteConfig> { RemoteConfigImpl() }
    single<HomeRepository> { HomeRepositoryImpl() }
    single<SearchRepository> { SearchRepositoryImpl() }
}

val useCaseFactory = module {
    single<HomeUseCase> { HomeUseCaseImpl(get(), get()) }
    single<SearchUseCase> { SearchUseCaseImpl(get()) }
}