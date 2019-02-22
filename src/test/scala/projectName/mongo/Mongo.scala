package projectName.mongo

import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import projectName.mongo.MongoHelper._


object Mongo {

// Connect to the default server localhost on port 27017
  val mongoClient: MongoClient = MongoClient()

  val database: MongoDatabase = mongoClient.getDatabase("projectName")

  val collection: MongoCollection[Document] = database.getCollection("collection-name")

  def getRecord(token: String): String = collection.find(equal("_id", token)).toString

  def deleteRecord(token: String): Unit = collection.deleteOne(equal("_id", token)).printResults()

  def dropDatabase(): Unit = database.drop().printResults()
}
