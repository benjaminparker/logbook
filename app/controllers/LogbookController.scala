package controllers

import com.google.inject.Inject
import models.Dive
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

class LogbookController @Inject() (val cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {

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

  def show = Action {
    implicit request =>
      Ok(views.html.addDive(logbookForm))
  }

  def add = Action {
    implicit request =>
      logbookForm.bindFromRequest().fold(
        formWithErrors => BadRequest(views.html.addDive(formWithErrors.withGlobalError("Invalid dive"))),

        dive => {
          Ok("All good")
        }
      )
  }
}
