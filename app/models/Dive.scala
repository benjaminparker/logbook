package models

import java.time.LocalDateTime

case class Dive(when: LocalDateTime = LocalDateTime.now, diveShop: String = "", diveSite: String = "", location: String = "", maxDepth: BigDecimal = 99.9, bottomTime: Int = 99, oxygenPercentage: Int = 21, diveBuddy: String = "", notes: String = "") {
  require(maxDepth >= 1.0)
  require(bottomTime >= 5)
  require(oxygenPercentage >= 21 && oxygenPercentage <= 100)
}
