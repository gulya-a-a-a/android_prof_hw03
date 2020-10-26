package ru.geekbrains.kotlin_professional.dictionary.model.data_source

import ru.geekbrains.kotlin_professional.dictionary.model.data.SearchResult

class RemoteDataSource(private val remoteProvider: RetrofitProvider = RetrofitProvider()) :
    IDataSource<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return remoteProvider.getData(word)
    }
}