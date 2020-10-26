package ru.geekbrains.kotlin_professional.dictionary.model.data_source

interface IDataSource<T> {
    suspend fun getData(word: String): T
}