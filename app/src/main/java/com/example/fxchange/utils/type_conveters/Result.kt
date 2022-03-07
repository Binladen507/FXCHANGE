package com.example.fxchange.utils.type_conveters

import androidx.paging.ExperimentalPagingApi


@ExperimentalPagingApi
sealed class Result <out R> {

    data class Success<out L>(val data: L?) : Result<L>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Loading -> "Loading"
            else -> {
                TODO()
            }
        }
    }
}
