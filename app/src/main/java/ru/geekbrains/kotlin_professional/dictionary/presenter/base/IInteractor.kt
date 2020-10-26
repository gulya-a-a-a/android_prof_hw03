package ru.geekbrains.kotlin_professional.dictionary.presenter.base

import ru.geekbrains.kotlin_professional.dictionary.model.data.DataModel

interface IInteractor<T : DataModel> {
    suspend fun getData(word: String, fromRemote: Boolean): T
}