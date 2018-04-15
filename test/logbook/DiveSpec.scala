package logbook

import models.Dive
import org.specs2.mutable.Specification

class DiveSpec extends Specification {

  "Logging a dive" should {

    "disallow max depth of less than 1 metre" in {

      Dive(maxDepth = 0.9) must throwA[IllegalArgumentException]
      Dive(maxDepth = -12.5) must throwA[IllegalArgumentException]
    }

    "disallow bottom time of less than 5 minutes" in {

      Dive(bottomTime = 2) must throwA[IllegalArgumentException]
    }

    "disallow oxygen percentage of less than 21" in {

      Dive(oxygenPercentage = 20) must throwA[IllegalArgumentException]
    }

    "disallow oxygen percentage of more than 100" in {

      Dive(oxygenPercentage = 101) must throwA[IllegalArgumentException]
    }

  }

}
