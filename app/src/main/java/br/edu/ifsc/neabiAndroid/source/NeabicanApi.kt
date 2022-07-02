package br.edu.ifsc.neabiAndroid.source

import br.edu.ifsc.neabiAndroid.source.model.SourceCampus
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Link para recuperar imagens.
//Ex: https://neabican.pythonanywhere.com/media/fotos_campus/campus-canoinhas.jpg

private const val BASE_URL = "https://neabican.pythonanywhere.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NeabicanApiService{
    @GET("api/campus")
    suspend fun getCampus(): List<SourceCampus>
}

object NeabicanApi{
    val retrofitService: NeabicanApiService by lazy {
        retrofit.create(NeabicanApiService::class.java)
    }
}