package projectName.testdata.payloads

trait PirateTranslatorPayloads {

  object TranslationBody {
    def apply(english: String): String = {
      s"""{
         |    "text": "$english"
         |}
       """.stripMargin
    }
  }
}
