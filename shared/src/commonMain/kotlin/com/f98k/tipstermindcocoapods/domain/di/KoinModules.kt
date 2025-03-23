package com.f98k.tipstermindcocoapods.domain.di


import com.f98k.tipstermindcocoapods.data.repository.HomeRepository
import com.f98k.tipstermindcocoapods.data.repository.UserRepository
import com.f98k.tipstermindcocoapods.domain.usecase.HomeUseCase
import com.f98k.tipstermindcocoapods.domain.usecase.UserUseCase
import com.f98k.tipstermindcocoapods.ui.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}
val repositoryModule = module {
    single { UserRepository() }
    single { HomeRepository() }
}

val useCaseFactory = module {
    singleOf (::HomeUseCase)
    singleOf (::UserUseCase)
}