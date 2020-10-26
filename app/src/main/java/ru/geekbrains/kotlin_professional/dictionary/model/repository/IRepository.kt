package ru.geekbrains.kotlin_professional.dictionary.model.repository

interface IRepository<T> {
    suspend fun getData(word: String): T
}