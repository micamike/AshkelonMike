import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchMainPageTest extends TestBase {

    @Test
    public void SearchFromMain() {
        type(By.name("search"), "Deadpool");
        click(By.cssSelector("i.svg-search-icon"));
        String ActualSearch = driver.getCurrentUrl();
        String ExpectedSearch = "https://en.wikipedia.org/wiki/Deadpool";
        Assert.assertEquals(ActualSearch, ExpectedSearch);
        returnToPreviousPage();
    }

    @Test
    public void SearchAfterLangSel() {
        click(By.cssSelector("a#js-link-box-en"));
        type(By.name("search"), "Deadpool");
        String ActualSearch = driver.getCurrentUrl();
        String ExpectedSearch = "https://en.wikipedia.org/wiki/Main_Page";
        Assert.assertEquals(ActualSearch, ExpectedSearch);
        returnToPreviousPage();
    }

}
