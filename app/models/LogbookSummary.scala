package models

case class LogbookSummary(logbook: List[Dive]) {

  def maxDepth: BigDecimal = logbook.map(_.maxDepth).max

  def maxBottomTime: Int = logbook.map(_.bottomTime).max

  def avgDepth: BigDecimal = logbook.map(_.maxDepth).sum / logbook.length

  def totalBottomTime: Int = logbook.map(_.bottomTime).sum

  def avgBottomTime: Int = (logbook.map(_.bottomTime).sum / logbook.length)

}
