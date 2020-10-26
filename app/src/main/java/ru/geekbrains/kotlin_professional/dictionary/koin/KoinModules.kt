package ru.geekbrains.kotlin_professional.dictionary.koin

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.geekbrains.kotlin_professional.dictionary.di.LOCAL_SOURCE
import ru.geekbrains.kotlin_professional.dictionary.di.REMOTE_SOURCE
import ru.geekbrains.kotlin_professional.dictionary.model.data.SearchResult
import ru.geekbrains.kotlin_professional.dictionary.model.data_source.LocalDataSource
import ru.geekbrains.kotlin_professional.dictionary.model.data_source.RemoteDataSource
import ru.geekbrains.kotlin_professional.dictionary.model.repository.IRepository
import ru.geekbrains.kotlin_professional.dictionary.model.repository.Repository
import ru.geekbrains.kotlin_professional.dictionary.presenter.MainInteractor
import ru.geekbrains.kotlin_professional.dictionary.view.view_model.MainViewModel

val application = module {
    single<IRepository<List<SearchResult>>>(named(REMOTE_SOURCE)) {
        Repository(RemoteDataSource())
    }

    single<IRepository<List<SearchResult>>>(named(LOCAL_SOURCE)) {
        Repository(LocalDataSource())
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named(REMOTE_SOURCE)), get(named(LOCAL_SOURCE))) }
    factory { MainViewModel(get()) }
}