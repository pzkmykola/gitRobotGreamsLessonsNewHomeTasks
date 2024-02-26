package com.example.gitrobotdreamsleesonsnewhomeasks

typealias SuperHeroDataResponse = List<SuperHero>;

abstract class SuperHero(
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
    val url: String,
    val md: String,
    val lg: String,
)

data object DataExample:SuperHero (
     id = 1,
     name ="A-Bomb",
     slug = "1-a-bomb",
     powerstats = Powerstats(
         intelligence = 38,
         strength = 100,
        speed = 17,
         durability = 80,
         power = 24,
         combat = 64
     ),
     appearance = Appearance(
         gender= "Male",
         race= "Human",
         height = listOf("6'8","203 cm"),
         weight = listOf("weight","441 kg"),
         eyeColor= "Yellow",
         hairColor="No Hair",
     ),
     biography = Biography(
         fullName = "Richard Milhouse Jones",
         alterEgos = "No alter egos found.",
         aliases = listOf("Rick Jones",),
         placeOfBirth = "Scarsdale, Arizona",
         firstAppearance = "Hulk Vol 2 #2 (April, 2008) (as A-Bomb)",
         publisher= "Marvel Comics",
         alignment= "good"
     ),
     work = Work(
         occupation = "Musician, adventurer, author; formerly talk show host",
         base = "-"
     ),
     connections = Connections(
         groupAffiliation = "Hulk Family; Excelsior (sponsor), Avengers (honorary member); formerly partner of the Hulk, Captain America and Captain Marvel; Teen Brigade; ally of Rom",
         relatives = "Marlo Chandler-Jones (wife); Polly (aunt); Mrs. Chandler (mother-in-law); Keith Chandler, Ray Chandler, three unidentified others (brothers-in-law); unidentified father (deceased); Jackie Shorr (alleged mother; unconfirmed)"
     ),
     images = Images(
         xs = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/xs/1-a-bomb.jpg",
         url = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/1-a-bomb.jpg",
         md = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/1-a-bomb.jpg",
         lg = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/1-a-bomb.jpg",
     ),
)