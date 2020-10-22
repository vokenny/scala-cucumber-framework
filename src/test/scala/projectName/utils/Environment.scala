package projectName.utils

sealed trait Environment

case object LOCAL extends Environment
case object STAGING extends Environment

object Environment {

  private val values: Seq[Environment] = Seq(LOCAL, STAGING)

  def parse(env: String): Environment = values.find(_.toString == env.toUpperCase)
    .fold(throw new RuntimeException(s"No matching Environment found for $env"))(e => e)

}