package projectName.mongo

import java.util.concurrent.TimeUnit

import com.typesafe.scalalogging.LazyLogging
import org.mongodb.scala._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object MongoHelper extends LazyLogging {

  implicit class DocumentObservable[C](val observable: Observable[Document]) extends ImplicitObservable[Document] {
    override val converter: Document => String = doc => doc.toJson
  }

  implicit class GenericObservable[C](val observable: Observable[C]) extends ImplicitObservable[C] {
    override val converter: C => String = doc => doc.toString
  }

  trait ImplicitObservable[C] {
    val observable: Observable[C]
    val converter: C => String

    def results(): Seq[C] = Await.result(observable.toFuture(), Duration(10, TimeUnit.SECONDS))

    def headResult(): C = Await.result(observable.head(), Duration(10, TimeUnit.SECONDS))

    def printResults(initial: String = ""): Unit = {
      if (initial.length > 0) print(initial)
      results().foreach(res => logger.info(converter(res)))
    }

    def printHeadResult(initial: String = ""): Unit = logger.info(s"$initial${converter(headResult())}")
  }
}
