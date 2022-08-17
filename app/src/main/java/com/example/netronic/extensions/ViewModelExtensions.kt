package com.example.netronic.extensions

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.*
import com.example.netronic.App
import com.example.netronic.presentation.base.DefaultFactory

object ViewModelExtensions {

    @MainThread
    inline fun <reified VM : ViewModel> Fragment.viewModels(
        noinline ownerProducer: () -> ViewModelStoreOwner = { this },
        noinline factoryProducer: () -> ViewModelProvider.Factory = { DefaultFactory() }
    ): Lazy<VM> = createViewModelLazy(
        viewModelClass = VM::class,
        storeProducer = { ownerProducer().viewModelStore },
        factoryProducer = factoryProducer
    )
}