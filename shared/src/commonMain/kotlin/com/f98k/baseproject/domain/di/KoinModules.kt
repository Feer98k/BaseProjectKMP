package com.f98k.baseproject.domain.di


import com.f98k.baseproject.data.repository.favorite.FavoriteRepository
import com.f98k.baseproject.data.repository.favorite.FavoriteRepositoryImpl
import com.f98k.baseproject.data.repository.home.HomeRepository
import com.f98k.baseproject.data.repository.home.HomeRepositoryImpl
import com.f98k.baseproject.data.repository.iatips.IaTipsRepository
import com.f98k.baseproject.data.repository.iatips.IaTipsRepositoryImpl
import com.f98k.baseproject.data.repository.main.MainRepository
import com.f98k.baseproject.data.repository.main.MainRepositoryImpl
import com.f98k.baseproject.data.repository.remoteconfig.RemoteConfig
import com.f98k.baseproject.data.repository.remoteconfig.RemoteConfigImpl
import com.f98k.baseproject.data.repository.search.SearchRepository
import com.f98k.baseproject.data.repository.search.SearchRepositoryImpl
import com.f98k.baseproject.data.repository.settings.SettingsRepository
import com.f98k.baseproject.data.repository.settings.SettingsRepositoryImpl
import com.f98k.baseproject.data.service.home.HomeApiService
import com.f98k.baseproject.domain.bridge.provideHttpClient
import com.f98k.baseproject.domain.usecase.MainUseCase
import com.f98k.baseproject.domain.usecase.MainUseCaseImpl
import com.f98k.baseproject.domain.usecase.favorite.FavoriteUseCase
import com.f98k.baseproject.domain.usecase.favorite.FavoriteUseCaseImpl
import com.f98k.baseproject.domain.usecase.home.HomeUseCase
import com.f98k.baseproject.domain.usecase.home.HomeUseCaseImpl
import com.f98k.baseproject.domain.usecase.iatips.IaTipsUseCase
import com.f98k.baseproject.domain.usecase.iatips.IaTipsUseCaseImpl
import com.f98k.baseproject.domain.usecase.remoteconfig.RemoteConfigUseCase
import com.f98k.baseproject.domain.usecase.remoteconfig.RemoteConfigUseCaseImpl
import com.f98k.baseproject.domain.usecase.search.SearchUseCase
import com.f98k.baseproject.domain.usecase.search.SearchUseCaseImpl
import com.f98k.baseproject.domain.usecase.settings.SettingsUseCase
import com.f98k.baseproject.domain.usecase.settings.SettingsUseCaseImpl
import com.f98k.baseproject.ui.screen.favorite.viewmodel.FavoriteViewModel
import com.f98k.baseproject.ui.screen.home.viewmodel.HomeViewModel
import com.f98k.baseproject.ui.screen.iatips.viewmodel.IaTipsViewModel
import com.f98k.baseproject.ui.screen.main.MainViewModel
import com.f98k.baseproject.ui.screen.search.viewmodel.SearchViewModel
import io.ktor.client.HttpClient
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { IaTipsViewModel(get()) }
    viewModel { MainViewModel(get()) }
}
val repositoryModule = module {
    single<RemoteConfig> { RemoteConfigImpl() }
    single<HomeRepository> { HomeRepositoryImpl() }
    single<SearchRepository> { SearchRepositoryImpl() }
    single<FavoriteRepository> { FavoriteRepositoryImpl() }
    single<IaTipsRepository> { IaTipsRepositoryImpl() }
    single<SettingsRepository> { SettingsRepositoryImpl() }
    single<MainRepository> { MainRepositoryImpl() }
}

val useCaseFactory = module {
    single<HomeUseCase> { HomeUseCaseImpl(get(), get()) }
    single<SearchUseCase> { SearchUseCaseImpl(get()) }
    single<FavoriteUseCase> { FavoriteUseCaseImpl(get(), get()) }
    single<IaTipsUseCase> { IaTipsUseCaseImpl(get(), get()) }
    single<SettingsUseCase> { SettingsUseCaseImpl(get(), get()) }
    single<RemoteConfigUseCase> { RemoteConfigUseCaseImpl(get()) }
    single<MainUseCase> { MainUseCaseImpl(get(), get()) }
}

val service = module {
    single<HttpClient> { provideHttpClient() }
    single<HomeApiService> { HomeApiService(get())}
}