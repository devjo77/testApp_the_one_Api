/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.technisys.test.network

import com.technisys.test.network.models.CharacterDTO.CharacterDTOResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://the-one-api.dev/v2/"
private const val BEREARER_TOKEN = "MNo8cNQS7PqG_4nmKvQZ"

private val logger = HttpLoggingInterceptor()//only test
//logger.level = HttpLoggingInterceptor.Level.BASIC

private val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .addInterceptor{ chain ->
        val request = chain.request().newBuilder().addHeader("Authorization", "Bearer $BEREARER_TOKEN").build()
        chain.proceed(request)
    }
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface OneApiService {
    @GET("character")
    suspend fun getCharacterByPage(): CharacterDTOResponse
}


object OneApi {
    val retrofitService: OneApiService by lazy { retrofit.create(OneApiService::class.java) }
}



