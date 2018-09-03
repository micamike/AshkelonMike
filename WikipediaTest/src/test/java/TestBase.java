import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.navigate().to("https://www.wikipedia.org"); pareil que get("")
        driver.get("https://www.wikipedia.org");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);         // Attente de 3 secondes
        driver.quit();
    }

    public void returnToPreviousPage() {
        driver.navigate().back();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }


    public void getInteractionMenuItemsList() {
        int size = driver.findElements(By.xpath("//*[@id='p-interaction']//li")).size();
        System.out.println(size);

        for (int i = 1; i <= size; i++) {
            List<String> itemsMenu = new ArrayList<>();                                             //Cree un nouveau Array
            WebElement item = driver.findElement(By.xpath("//*[@id='p-interaction']//li[" + i + "]"));
            String itemName = item.getText();
            itemsMenu.add(itemName.toLowerCase());                                                  //Ajoute l'element a la liste en minuscules
            System.out.println(itemsMenu);
        }
    }

    public boolean onTheWelcomePage() {
        return isElementPresent(By.cssSelector("a#js-link-box-en"));

    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoggedin() {
        try {
            driver.findElement(By.id("pt-userpage"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void FillLoginForm(String user, String password) {
        type(By.id("wpName1"), user);
        type(By.id("wpPassword1"), password);
    }

    public void ClickOnLogin() {
        click(By.id("pt-login"));
    }

    public void ClickOnLogOut(){
        click(By.id("pt-logout"));
    }

    public void SubmitLogin() {
        click(By.name("wploginattempt"));
    }
}
