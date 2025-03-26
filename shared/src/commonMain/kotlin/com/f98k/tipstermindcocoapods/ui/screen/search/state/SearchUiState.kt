package com.f98k.tipstermindcocoapods.ui.screen.search.state

import com.f98k.tipstermindcocoapods.commons.StringConstants.EMPTY_STRING

data class SearchUiState(
    val searchText: String = EMPTY_STRING,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val searchResults: List<String> = emptyList(),
    val selectedResult: String? = null,
)

data class SearchUiActions(
    val onSearchTextChanged: (String) -> Unit = {},
    val onSearchButtonClicked: () -> Unit = {},
    val onResultSelected: (String) -> Unit = {},
    val onErrorDismissed: () -> Unit = {}
)
