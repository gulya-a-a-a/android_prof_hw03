package ru.geekbrains.kotlin_professional.dictionary.view.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.geekbrains.kotlin_professional.dictionary.model.data.DataModel

abstract class BaseViewModel<T : DataModel>(
    protected open val _mutableLiveData: MutableLiveData<T> = MutableLiveData()
) : ViewModel() {

    abstract fun getData(word: String, isOnline: Boolean)

    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable -> handleError(throwable) })

    abstract fun handleError(throwable: Throwable)

    protected fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }
}