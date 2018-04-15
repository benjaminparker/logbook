package logbook

import models.{LogbookSummary, Dive}
import org.specs2.mutable.Specification

class LogbookSummarySpec extends Specification {

  "A dive summary" should {

    "provide total bottom time" in {

      val diveLogs = List(Dive(bottomTime = 46), Dive(bottomTime = 52))
      val summary = LogbookSummary(diveLogs)
      summary.totalBottomTime must_== 98
    }

    "provide average depth" in {

      val diveLogs = Dive(maxDepth = 15.0) :: Dive(maxDepth = 35.3) :: Dive(maxDepth = 40.6) :: Nil
      val summary = LogbookSummary(diveLogs)
      summary.avgDepth must_== BigDecimal(30.3)
    }

    "provide max depth" in {

      val diveLogs = Dive(maxDepth = 15.0) :: Dive(maxDepth = 35.3) :: Dive(maxDepth = 40.6) :: Nil
      val summary = LogbookSummary(diveLogs)
      summary.maxDepth must_== BigDecimal(40.6)
    }

    "provide average bottom time" in {

      val diveLogs = Dive(bottomTime = 46) :: Dive(bottomTime = 52) :: Dive(bottomTime = 27) :: Nil
      val summary = LogbookSummary(diveLogs)
      summary.avgBottomTime must_== 41
    }

    "provide max bottom time" in {

      val diveLogs = Dive(bottomTime = 46) :: Dive(bottomTime = 52) :: Dive(bottomTime = 27) :: Nil
      val summary = LogbookSummary(diveLogs)
      summary.maxBottomTime must_== 52
    }
  }

}
