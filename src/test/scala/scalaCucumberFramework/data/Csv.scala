package scalaCucumberFramework.data

import java.io.File

import scala.io.Source

trait Csv {

  def filePath(fileName: String): String = new File(s"src/test/resources/$fileName").getCanonicalPath

  def readLines(fileName: String): List[String] = Source.fromFile(fileName).getLines().toList
}
