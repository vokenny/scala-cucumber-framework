package scalaCucumberFramework.testdata.models.PokeApi

import play.api.libs.json._
import scalaCucumberFramework.testdata.models.pokeApi.Abilities

// pokeApi returns a lot of data that I don't care about
// so I only take what I want to assert
case class AbridgedPokeProfile(id: Int, name: String, abilitiesSeq: Seq[Abilities])

object AbridgedPokeProfile {

  implicit val reads: Reads[AbridgedPokeProfile] = (json: JsValue) => {
    for {
      abilities <- (json \ "abilities").validate[Seq[Abilities]]
      id <- (json \ "id").validate[Int]
      name <- (json \ "name").validate[String]
    } yield AbridgedPokeProfile(id, name, abilities)
  }
}
