package com.f98k.baseproject.ui.screen.iatips.state

data class IaTipsUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val tips: List<String> = emptyList(),
)

data class IaTipsUiActions(
    val onTipSelected: (String) -> Unit = {},
    val onErrorDismissed: () -> Unit = {},
)
