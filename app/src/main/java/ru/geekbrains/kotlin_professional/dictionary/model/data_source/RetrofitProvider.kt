package ru.geekbrains.kotlin_professional.dictionary.model.data_source

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.kotlin_professional.dictionary.model.data.SearchResult

class RetrofitProvider : IDataSource<List<SearchResult>> {

    companion object {
        private val BASE_URL = "https://dictionary.skyeng.ru/api/public/v1/"
    }

    private val _api: SkyEngApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
        .create(SkyEngApi::class.java)

    override suspend fun getData(word: String): List<SearchResult> {
        return _api.search(word).await()
    }

}