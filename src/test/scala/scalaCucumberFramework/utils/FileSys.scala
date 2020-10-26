package scalaCucumberFramework.utils

import java.io.File

import scala.annotation.tailrec

object FileSys {

  def getAllFilesUnderDir(dir: File, extensions: List[String]): List[File] = {
    @tailrec
    def extractFiles(files: List[File], result: List[File]): List[File] = {
      files match {
        case Nil => result
        case h :: tail if h.isDirectory => extractFiles(tail, result ::: getAllFilesUnderDir(h, extensions))
        case h :: tail if h.isFile =>
          if (extensions.exists(h.getName.endsWith(_))) extractFiles(tail, result :+ h)
          else extractFiles(tail, result)
      }
    }

    extractFiles(dir.listFiles.toList, List())
  }

}
