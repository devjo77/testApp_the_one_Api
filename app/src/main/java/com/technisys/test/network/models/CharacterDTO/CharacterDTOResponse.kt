package com.technisys.test.network.models.CharacterDTO

import com.google.gson.annotations.SerializedName
import com.technisys.test.model.Character

data class CharacterDTOResponse(
    @SerializedName("docs") val items: List<Character> = emptyList(),
    @SerializedName("total") val total: Int = 0,
    @SerializedName("limit") val limit: Int = 0,
    @SerializedName("offset") val offset: Int = 0,
    @SerializedName("page") val page: Int = 0,
    val nextPage: Int? = null
)