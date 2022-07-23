package br.edu.ifsc.neabiAndroid.data.remote

import br.edu.ifsc.neabiAndroid.data.remote.dto.CampusDto
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Link para recuperar imagens.
//Ex: https://neabican.pythonanywhere.com/media/fotos_campus/campus-canoinhas.jpg

private const val BASE_URL = "https://neabican.pythonanywhere.com"

//Objeto para evitar armazenar NULL no Json
object NULL_TO_EMPTY_STRING_ADAPTER {
    @FromJson
    fun fromJson(reader: JsonReader): String {
        if (reader.peek() != JsonReader.Token.NULL) {
            return reader.nextString()
        }
        reader.nextNull<Unit>()
        return ""
    }
}

private val moshi = Moshi.Builder()
    .add(NULL_TO_EMPTY_STRING_ADAPTER)
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NeabicanApiService{
    @GET("api/campus")
    suspend fun getCampus(): List<CampusDto>
}

object NeabicanApi{
    val retrofitService: NeabicanApiService by lazy {
        retrofit.create(NeabicanApiService::class.java)
    }
}