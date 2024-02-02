package com.example.gitrobotdreamsleesonsnewhomeasks

import com.google.gson.annotations.SerializedName //common
import java.lang.invoke.MethodHandleInfo



/*Below are data classes for 'imgflip' site*/
//data class SuperHeroDataResponse(@SerializedName("data") val data:Data)
//data class Data(@SerializedName("memes") val superheroes:List<SuperHero>)
//
//data class SuperHero(
//    @SerializedName("name") val name:String,//)//,
//    @SerializedName("url") val url:String
//) //imgflip with/without images, uncoment Glide in fun onBindViewHolder(SVA)

//for rick@morty
data class SuperHeroDataResponse(
    @SerializedName("info")val info:InfoData?,
    @SerializedName("results") val data:ArrayList<SuperHero> = arrayListOf()
)

//data class Data(var superheroes:List<SuperHero>)
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
//Below are data classes for superheroes site
//data class Data( val superheroes:List<SuperHero>) //not serialized
////data class Data(@SerializedName("") val superheroes:List<SuperHero>) //not serialized
//data class SuperHero(
////    @SerializedName("id") val id:Int,
////    @SerializedName("name") val name:String,
////    @SerializedName("images") val images:Images
////)
////(
//val id: Long,
//    val name: String,
//    val slug: String,
//    val powerstats: Powerstats,
//    val appearance: Appearance,
//    val biography: Biography,
//    val work: Work,
//    val connections: Connections,
//    val images: Images
//)
////data class Images (
////   @SerializedName("xs" ) val xs : String,
////   @SerializedName("sm" ) val sm : String,
////   @SerializedName("md" ) val md : String,
////   @SerializedName("lg" ) val lg : String
////
////)
//data class Images (
//    val xs: String,
//    val sm: String,
//    val md: String,
//    val lg: String
//)
//data class Appearance (
//    val gender: Gender,
//    val race: String? = null,
//    val height: List<String>,
//    val weight: List<String>,
//    val eyeColor: String,
//    val hairColor: String
//)
//
//enum class Gender(val value: String) {
//    Empty("-"),
//    Female("Female"),
//    Male("Male");
//
//    companion object {
//        public fun fromValue(value: String): Gender = when (value) {
//            "-"      -> Empty
//            "Female" -> Female
//            "Male"   -> Male
//            else     -> throw IllegalArgumentException()
//        }
//    }
//}
//
//data class Biography (
//    val fullName: String,
//    val alterEgos: String,
//    val aliases: List<String>,
//    val placeOfBirth: String,
//    val firstAppearance: String,
//    val publisher: String? = null,
//    val alignment: Alignment
//)
//
//enum class Alignment(val value: String) {
//    Bad("bad"),
//    Empty("-"),
//    Good("good"),
//    Neutral("neutral");
//
//    companion object {
//        public fun fromValue(value: String): Alignment = when (value) {
//            "bad"     -> Bad
//            "-"       -> Empty
//            "good"    -> Good
//            "neutral" -> Neutral
//            else      -> throw IllegalArgumentException()
//        }
//    }
//}
//
//data class Connections (
//    val groupAffiliation: String,
//    val relatives: String
//)
//
//data class Powerstats (
//    val intelligence: Long,
//    val strength: Long,
//    val speed: Long,
//    val durability: Long,
//    val power: Long,
//    val combat: Long
//)
//
//data class Work (
//    val occupation: String,
//    val base: String
//)