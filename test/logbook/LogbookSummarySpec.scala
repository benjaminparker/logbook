package logbook

import models.{Dive, LogbookSummary}
import org.scalatest.WordSpec
import org.scalatest.Matchers._

class LogbookSummarySpec extends WordSpec {

  "A dive summary" should {

    "provide total bottom time" in {

      val diveLogs = List(Dive(bottomTime = 46), Dive(bottomTime = 52))
      val summary = LogbookSummary(diveLogs)
      summary.totalBottomTime shouldEqual 98
    }

    "provide average depth" in {

      val diveLogs = Dive(maxDepth = 15.0) :: Dive(maxDepth = 35.3) :: Dive(maxDepth = 40.6) :: Nil
      val summary = LogbookSummary(diveLogs)
      summary.avgDepth shouldEqual BigDecimal(30.3)
    }

    "provide max depth" in {

      val diveLogs = Dive(maxDepth = 15.0) :: Dive(maxDepth = 35.3) :: Dive(maxDepth = 40.6) :: Nil
      val summary = LogbookSummary(diveLogs)
      summary.maxDepth shouldEqual BigDecimal(40.6)
    }

    "provide average bottom time" in {

      val diveLogs = Dive(bottomTime = 46) :: Dive(bottomTime = 52) :: Dive(bottomTime = 27) :: Nil
      val summary = LogbookSummary(diveLogs)
      summary.avgBottomTime shouldEqual 41
    }

    "provide max bottom time" in {

      val diveLogs = Dive(bottomTime = 46) :: Dive(bottomTime = 52) :: Dive(bottomTime = 27) :: Nil
      val summary = LogbookSummary(diveLogs)
      summary.maxBottomTime shouldEqual 52
    }
  }

}
