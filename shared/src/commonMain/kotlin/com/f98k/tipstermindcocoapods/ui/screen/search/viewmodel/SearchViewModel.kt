package com.f98k.tipstermindcocoapods.ui.screen.search.viewmodel

import androidx.lifecycle.ViewModel
import com.f98k.tipstermindcocoapods.domain.usecase.home.HomeUseCase
import com.f98k.tipstermindcocoapods.ui.screen.search.state.SearchUiActions
import com.f98k.tipstermindcocoapods.ui.screen.search.state.SearchUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel(private val searchUseCase: HomeUseCase) : ViewModel() {

    private val _state = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _state.asStateFlow()

    val uiActions : SearchUiActions
        get() = SearchUiActions()
}