package com.example.webservice

import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {
    @GET("pokemon")
    fun listPokemons():Call<PokemonApiResult>
}