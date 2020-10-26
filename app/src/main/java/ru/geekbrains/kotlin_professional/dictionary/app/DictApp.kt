package ru.geekbrains.kotlin_professional.dictionary.app

import android.app.Application
import org.koin.core.context.startKoin
import ru.geekbrains.kotlin_professional.dictionary.koin.application
import ru.geekbrains.kotlin_professional.dictionary.koin.mainScreen

class DictApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}