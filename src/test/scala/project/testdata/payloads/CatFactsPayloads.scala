package project.testdata.payloads

trait CatFactsPayloads {

  object AddNewFact {

    def apply(agentId: String): String = {
      s"""
         |{
         |	"fact": "The pads on cat feet are called 'toe beans'"
         |}
       """.stripMargin
    }
  }
}
