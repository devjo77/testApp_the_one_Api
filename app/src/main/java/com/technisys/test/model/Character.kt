package com.technisys.test.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    @field:SerializedName("_id") val id: String = "",
    @field:SerializedName("height") val height: String = "",
    @field:SerializedName("race") val race: String = "",
    @field:SerializedName("gender") val gender: String = "",
    @field:SerializedName("birth") val birth: String = "",
    @field:SerializedName("spouse") val spouse: String = "",
    @field:SerializedName("death") val death: String = "",
    @field:SerializedName("realm") val realm: String = "",
    @field:SerializedName("hair") val hair: String = "",
    @field:SerializedName("name") val name: String = "",
    @field:SerializedName("wikiUrl") val wikiUrl: String = ""
): Parcelable {}