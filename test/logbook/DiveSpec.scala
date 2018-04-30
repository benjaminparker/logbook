package logbook

import models.Dive
import org.scalatest.WordSpec
import org.scalatest.Matchers._


class DiveSpec extends WordSpec {

  "Logging a dive" should {

    "disallow max depth of less than 1 metre" in {

      an [IllegalArgumentException] should be thrownBy Dive(maxDepth = 0.9)
      an [IllegalArgumentException] should be thrownBy Dive(maxDepth = -12.5)
    }

    "disallow bottom time of less than 5 minutes" in {

      an [IllegalArgumentException] should be thrownBy Dive(bottomTime = 2)
    }

    "disallow oxygen percentage of less than 21" in {

      an [IllegalArgumentException] should be thrownBy Dive(oxygenPercentage = 20)
    }

    "disallow oxygen percentage of more than 100" in {

      an [IllegalArgumentException] should be thrownBy Dive(oxygenPercentage = 101)
    }

  }

}
