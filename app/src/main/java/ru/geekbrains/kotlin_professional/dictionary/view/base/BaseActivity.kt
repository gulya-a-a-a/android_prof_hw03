package ru.geekbrains.kotlin_professional.dictionary.view.base

import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.kotlin_professional.dictionary.model.data.DataModel

abstract class BaseActivity<T : DataModel> : AppCompatActivity() {

    abstract val _model: BaseViewModel<T>

    abstract fun showData(dataModel: DataModel)


}