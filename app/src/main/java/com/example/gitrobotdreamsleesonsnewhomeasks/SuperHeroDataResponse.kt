package com.example.gitrobotdreamsleesonsnewhomeasks

import com.google.gson.annotations.SerializedName
import java.lang.invoke.MethodHandleInfo


/*Below are data classes for rick@morty site*/
data class SuperHeroDataResponse(
    @SerializedName("info")val info:InfoData?,
    @SerializedName("results") val data:ArrayList<SuperHero> = arrayListOf()
)

data class SuperHero(
    @SerializedName("name") val name: String? = null,
    @SerializedName("image") val url: String? = null
)
data class InfoData (
    @SerializedName("count" ) val count : Int?    = null,
    @SerializedName("pages" ) val pages : Int?    = null,
    @SerializedName("next"  ) val next  : String? = null,
    @SerializedName("prev"  ) val prev  : String? = null
)

/*Below are data classes for 'imgflip' site*/
//data class SuperHeroDataResponse(@SerializedName("data") val data:Data)
//data class Data(@SerializedName("memes") val superheroes:List<SuperHero>)
//
//data class SuperHero(
//    @SerializedName("name") val name:String,
//    @SerializedName("url") val url:String
//)

