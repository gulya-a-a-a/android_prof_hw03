package ru.geekbrains.kotlin_professional.dictionary.presenter

import ru.geekbrains.kotlin_professional.dictionary.model.data.DataModel
import ru.geekbrains.kotlin_professional.dictionary.model.data.SearchResult
import ru.geekbrains.kotlin_professional.dictionary.model.repository.IRepository
import ru.geekbrains.kotlin_professional.dictionary.presenter.base.IInteractor

class MainInteractor constructor(
    private val remoteRepo: IRepository<List<SearchResult>>,
    private val localRepo: IRepository<List<SearchResult>>
) : IInteractor<DataModel> {

    override suspend fun getData(word: String, fromRemote: Boolean): DataModel {
        return DataModel.Success(
            if (fromRemote) {
                remoteRepo
            } else {
                localRepo
            }.getData(word)
        )
    }
}