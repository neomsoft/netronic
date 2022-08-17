package com.example.netronic.presentation.base

import androidx.lifecycle.ViewModel
import com.example.netronic.App.Companion.appComponent

object ModelsProvider {

    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModelProducerMap = appComponent.viewModelProducerSet.toMap()

        return viewModelProducerMap[modelClass.name]?.let { it() as T } ?: modelClass.newInstance()
    }
}

