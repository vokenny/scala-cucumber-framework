package scalaCucumberFramework.data

import java.io.{BufferedWriter, FileWriter}

import scala.annotation.tailrec
import scala.util.Random

object StringGenerator extends App with Csv {

  def generateString(): String = Random.alphanumeric.take(10).mkString

  def writeStringsToCsv(filePath: String, num: Int): Unit = {
    val bw: BufferedWriter = new BufferedWriter(new FileWriter(filePath))
    val stringList: List[String] = List.fill(num)(generateString())
    stringList.init.foreach(e => bw.write(e + ",\n"))
    bw.write(stringList.last)
    bw.close()
  }

  writeStringsToCsv(filePath("strings.csv"), 100)
}
