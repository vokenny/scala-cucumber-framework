package projectName.testdata.payloads

trait PirateTranslatorPayloads {

  case class TranslationBody(english: String) {
    val jsonString: String = {
      s"""{
         |    "text": "$english"
         |}
       """.stripMargin
    }
  }
}
