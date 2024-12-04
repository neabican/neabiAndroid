package br.edu.ifsc.aquilombar.data.remote

import br.edu.ifsc.aquilombar.data.remote.dto.DBVersionDto
import br.edu.ifsc.aquilombar.data.remote.dto.InstitutionDto
import br.edu.ifsc.aquilombar.util.Adapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Link para recuperar imagens.
//Ex: https://neabican.pythonanywhere.com/media/fotos_campus/campus-canoinhas.jpg

object BaseURL{
    const val BASE_URL = "https://www.aquilombar.app.br"
}

private val moshi = Moshi.Builder()
    .add(Adapter.NULL_TO_EMPTY_STRING_ADAPTER)
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BaseURL.BASE_URL)
    .build()

interface NeabicanApiService{
    @GET("api/instituicoes")
    suspend fun getInitialData(): List<InstitutionDto>

    //Criar end point na API
    @GET("api/DBVersion???")
    suspend fun getDatabaseVersion(): DBVersionDto
}

object NeabicanApi{
    val retrofitService: NeabicanApiService by lazy {
        retrofit.create(NeabicanApiService::class.java)
    }
}