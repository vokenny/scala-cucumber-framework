package scalaCucumberFramework.utils

import java.io.File

object FileSys {

  def getListOfFiles(dir: File, extensions: List[String]): List[File] = {
    dir.listFiles.filter(_.isFile).filter { file =>
      extensions.exists(file.getName.endsWith(_))
    }.toList
  }

}
