package projectName.mongo

import org.mongodb.scala._
import org.mongodb.scala.bson.BsonDocument
import org.mongodb.scala.model.Filters._
import projectName.mongo.MongoHelper._


object Mongo {

// Connect to the default server localhost on port 27017
// Dropping Mongo like this will only work locally, unless you have config for other MongoClients.
// Arguably easier to hit a test-only endpoint in all environments, so no config needed.
  val mongoClient: MongoClient = MongoClient()

  val database: MongoDatabase = mongoClient.getDatabase("database-name")

  val collection: MongoCollection[Document] = database.getCollection("collection-name")

  def insertVerifiedEmail(email: String): Unit = {
    database
      .getCollection("emailCollection")
      .insertOne(BsonDocument(
        "email" -> email,
        "isVerified" -> true))
      .printResults()
  }

  def findVerifiedEmail(email: String): String = {
    database
      .getCollection("emailCollection")
      .find(BsonDocument("email" -> email))
      .headResult().toJson()
  }

  def dropDatabase(): Unit = database.drop().printResults()
}
