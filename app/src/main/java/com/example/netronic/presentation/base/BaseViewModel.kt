package com.example.netronic.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    /**
     * Метод для створення [LiveData] з можливістю публікувати нові значення за допомогою метода
     * [postValue].
     * Публікувати та встановлювати нові значення можуть тільки потомки класу [BaseViewModel].
     */
    protected fun <T> liveDataOf(initializer: T): LiveData<T> {
        return MutableLiveData(initializer)
    }

    /**
     * Метод використовується коли [LiveData] було створено методом [liveDataOf], для того, щоб
     * публікувати нові значення. Публікувати нові значення можуть тільки потомки класу
     * [BaseViewModel].
     */
    protected fun <T> LiveData<T>.postValue(value: T) {
        (this as MutableLiveData<T>).postValue(value)
    }


    private class MutableLiveData<T>(value: T) : LiveData<T>(value) {

        public override fun postValue(value: T) {
            super.postValue(value)
        }
    }
}