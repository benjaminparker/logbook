package controllers

import com.google.inject.Inject
import models.Dive
import models.JsonFormats._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json._
import play.api.mvc._
import play.modules.reactivemongo._
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.{ExecutionContext, Future}

class LogbookController @Inject() (messagesAction: MessagesActionBuilder, mcc: MessagesControllerComponents, val reactiveMongoApi: ReactiveMongoApi) extends AbstractController(mcc)
  with MongoController with ReactiveMongoComponents {

  private val logbookForm: Form[Dive] = Form(
    mapping(
      "when" -> localDateTime,
      "diveShop" -> text,
      "diveSite" -> nonEmptyText,
      "location" -> text,
      "maxDepth" -> bigDecimal,
      "bottomTime" -> number,
      "oxygenPercentage" -> number,
      "diveBuddy" -> text,
      "notes" -> text
    )(Dive.apply)(Dive.unapply)
  )

  implicit def ec: ExecutionContext = mcc.executionContext

  def collection: Future[JSONCollection] = database.map(_.collection[JSONCollection]("dives"))
  
  def show = messagesAction { implicit request: MessagesRequest[AnyContent] =>
      Ok(views.html.addDive(logbookForm))
  }

  def add = messagesAction { implicit request: MessagesRequest[AnyContent] =>
      logbookForm.bindFromRequest().fold(
        
        formWithErrors => {
          BadRequest(views.html.addDive(formWithErrors.withGlobalError("Invalid dive")))
        },

        dive => {
            collection.flatMap(_.insert(dive))    //need to return this future result and use it when I understand this messagesAction malarky
//          futureResult.map(_ => Ok("Dive added successfully"))
          Ok("Dive added successfully")
        }
      )
  }
}
