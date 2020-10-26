package ru.geekbrains.kotlin_professional.dictionary.model.repository

import ru.geekbrains.kotlin_professional.dictionary.model.data.SearchResult
import ru.geekbrains.kotlin_professional.dictionary.model.data_source.IDataSource

class Repository(val dataSource: IDataSource<List<SearchResult>>) :
    IRepository<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return dataSource.getData(word)
    }
}