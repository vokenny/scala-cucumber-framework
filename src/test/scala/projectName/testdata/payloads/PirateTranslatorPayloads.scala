package projectName.testdata.payloads

trait PirateTranslatorPayloads {

  object GetTranslationBody {
    def apply(english: String): String = {
      s"""{
         |    "text": "$english"
         |}
       """.stripMargin
    }
  }
}
