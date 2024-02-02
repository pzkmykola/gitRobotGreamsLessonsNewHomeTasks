package com.example.gitrobotdreamsleesonsnewhomeasks

import com.google.gson.annotations.SerializedName
import java.lang.invoke.MethodHandleInfo


/*Below are data classes for rick@morty site*/
//data class SuperHeroDataResponse(
//    @SerializedName("info")val info:InfoData?,
//    @SerializedName("results") val data:ArrayList<SuperHero> = arrayListOf()
//)

//data class SuperHero(
//    @SerializedName("name") val name: String? = null,
//    @SerializedName("image") val url: String? = null
//)
//data class InfoData (
//    @SerializedName("count" ) val count : Int?    = null,
//    @SerializedName("pages" ) val pages : Int?    = null,
//    @SerializedName("next"  ) val next  : String? = null,
//    @SerializedName("prev"  ) val prev  : String? = null
//)

/*Below are data classes for 'imgflip' site*/
//data class SuperHeroDataResponse(@SerializedName("data") val data:Data)
//data class Data(@SerializedName("memes") val superheroes:List<SuperHero>)
//
//data class SuperHero(
//    @SerializedName("name") val name:String,
//    @SerializedName("url") val url:String
//)

/*Below are data classes for 'akabab.github.io' site*/
typealias SuperHeroDataResponse = List<SuperHero>;

data class SuperHero(
    val id: Long,
    val name: String,
    val slug: String,
    val powerstats: Powerstats,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val connections: Connections,
    val images: Images,
)

data class Powerstats(
    val intelligence: Long,
    val strength: Long,
    val speed: Long,
    val durability: Long,
    val power: Long,
    val combat: Long,
)

data class Appearance(
    val gender: String,
    val race: String?,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String,
)

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String?,
    val alignment: String,
)

data class Work(
    val occupation: String,
    val base: String,
)

data class Connections(
    val groupAffiliation: String,
    val relatives: String,
)

data class Images(
    val xs: String,
    @SerializedName("sm")    val url: String,
    val md: String,
    val lg: String,
)

