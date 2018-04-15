import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneServerPerSuite

class AddADivePageSpec extends PlaySpec with OneBrowserPerSuite with GuiceOneServerPerSuite with HtmlUnitFactory  {

  "Add a dive" should {

    "have the correct page title" in {
      go to "http://localhost:" + port
      pageTitle mustEqual "Add a dive"
    }

//    "permit a dive site to be entered" in new WithBrowser {
//      browser.goTo("http://localhost:" + port)
//      browser.$("#diveSite").write("Monad Shoal")
//      browser.$("#add").click
//    }
  }
}
