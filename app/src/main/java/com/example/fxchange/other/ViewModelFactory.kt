package com.example.fxchange.other

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val viewModelMapper: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("FOR_UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var viewModel = viewModelMapper[modelClass]

        if (viewModel == null) {
            for (entry in viewModelMapper) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    viewModel = entry.value
                    break
                }
            }
        }

        if (viewModel == null) throw IllegalArgumentException("Unknown model class $modelClass")
        return viewModel.get() as T
    }
}