package ru.geekbrains.kotlin_professional.dictionary.view.view_model

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.geekbrains.kotlin_professional.dictionary.model.data.DataModel
import ru.geekbrains.kotlin_professional.dictionary.presenter.MainInteractor
import ru.geekbrains.kotlin_professional.dictionary.view.base.BaseViewModel

class MainViewModel constructor(private val _interactor: MainInteractor) :
    BaseViewModel<DataModel>() {

    private var _dataModel: DataModel? = null

    private val _liveDataForView: LiveData<DataModel> = _mutableLiveData

    fun subscribe(): LiveData<DataModel> = _liveDataForView

    override fun handleError(throwable: Throwable) {
        _mutableLiveData.postValue(DataModel.Error(throwable))
    }

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = DataModel.Loading(null)
        cancelJob()

        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO)
        {
            _mutableLiveData.postValue(_interactor.getData(word, isOnline))
        }
}