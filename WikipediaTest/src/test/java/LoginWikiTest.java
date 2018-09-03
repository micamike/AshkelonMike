import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginWikiTest extends TestBase {

@BeforeMethod
public void Preconditions() {
    if (onTheWelcomePage()) {
        click(By.cssSelector("a#js-link-box-en"));
    }
    if (isLoggedin()) {
        ClickOnLogOut();
    }
}

    @Test
    public void LoginTest() {

        ClickOnLogin();
        FillLoginForm("micamike", "telran55");
        SubmitLogin();

        Assert.assertTrue(isElementPresent(By.id("pt-userpage")));

    }



    @Test
    public void LoginTestNegative() {

        ClickOnLogin();
        FillLoginForm("micamike", "telran");
        SubmitLogin();

        Assert.assertTrue(isElementPresent(By.cssSelector("div.mw-parser-output")));
    }
}
