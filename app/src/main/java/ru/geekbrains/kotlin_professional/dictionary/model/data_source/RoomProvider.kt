package ru.geekbrains.kotlin_professional.dictionary.model.data_source

import ru.geekbrains.kotlin_professional.dictionary.model.data.SearchResult

class RoomProvider : IDataSource<List<SearchResult>> {
    override suspend fun getData(word: String): List<SearchResult> {
        TODO("Not yet implemented")
    }
}