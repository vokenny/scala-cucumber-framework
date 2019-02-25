package projectName.testdata.models

object Address {

  lazy val valid: String = {
    """10 Test Street,
      |Test City,
      |Florida,
      |32704
    """.stripMargin
  }
}