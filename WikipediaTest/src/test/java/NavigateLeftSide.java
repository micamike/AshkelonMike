import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateLeftSide extends TestBase {

    @Test
    //Comparaison selon URL
    public void CurrentEventsBtn() {
        click(By.cssSelector("a#js-link-box-en"));
        click(By.id("n-currentevents"));
        String ActualSearch = driver.getCurrentUrl();
        String ExpectedSearch = "https://en.wikipedia.org/wiki/Portal:Current_events";
        Assert.assertEquals(ActualSearch, ExpectedSearch);
        returnToPreviousPage();
    }

    @Test
    //Comparaison selon URL
    public void FeatureContentsBtn() {
        click(By.cssSelector("a#js-link-box-en"));
        click(By.id("n-featuredcontent"));
        String ActualSearch = driver.getCurrentUrl();
        String ExpectedSearch = "https://en.wikipedia.org/wiki/Portal:Featured_content";
        Assert.assertEquals(ActualSearch, ExpectedSearch);
        returnToPreviousPage();
    }

    @Test
    //Comparaison selon objet
    public void CurrentEventsBtn2() {
        click(By.cssSelector("a#js-link-box-en"));
        click(By.id("n-currentevents"));
        //driver.findElement(By.cssSelector("h1#firstHeading"));
        Assert.assertTrue(isElementPresent(By.cssSelector("h1#firstHeading")));
        returnToPreviousPage();
    }

    @Test
    //Comparaison selon objet
    public void donate() throws InterruptedException {
        click(By.cssSelector("a#js-link-box-en"));
        click(By.id("n-sitesupport"));
        //driver.findElement(By.cssSelector("a.mw-wiki-logo"));
        Assert.assertTrue(isElementPresent(By.cssSelector("a.mw-wiki-logo")));
        Thread.sleep(3000);
        returnToPreviousPage();
    }

}
