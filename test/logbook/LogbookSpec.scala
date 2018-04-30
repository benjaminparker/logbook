package logbook

import models.Dive
import org.scalatest.WordSpec

class LogbookSpec extends WordSpec {

  /*
  Removed until I work out a way of auto starting mongo or perhaps using a stub?
   */

//  val myRasMohammedDive: Dive = Dive(diveSite = "Ras Mohammed", maxDepth = 35.6, bottomTime = 43)
//  val myThistlegormDive: Dive = Dive(diveSite = "Thistlegorm", maxDepth = 27.4, bottomTime = 35)
//
//  "Logbook" should {
//
//    "add a new dive" in {
//      val id: Option[String] = Logbook.insert(myRasMohammedDive)
//      id must beSome
//    }
//
//    "retrieve a dive by dive site" in {
//      Logbook.insert(myRasMohammedDive)
//      Logbook.insert(myThistlegormDive)
//      Logbook.findBySite("Thistlegorm") mustEqual List(myThistlegormDive)
//    }
//
//
//  }
//
//  override def map(fs: => Fragments) = fs ^ Step(tearDown)
//
//  def tearDown {
//    Logbook.remove(myRasMohammedDive)
//    Logbook.remove(myThistlegormDive)
//  }

}
