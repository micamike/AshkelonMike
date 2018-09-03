import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InteractionMenuTest extends TestBase {

    @Test
    public void NavigInteraction() {

        if(onTheWelcomePage()){
            click(By.cssSelector("a#js-link-box-en"));
        }                //si sur la WelcomePage alors click sinon commence le test a la prochaine etape.

        int size = driver.findElements(By.xpath("//*[@id='p-interaction']//li")).size();  // Determiner la taille dans le menu.
        System.out.println(size);                                                          // imprime le nombre d'elements

        for (int i = 1; i <= size; i++)                                                   // cherche de 1 a size les elements contenus dans le menu
        {

            WebElement item = driver.findElement(By.xpath("//*[@id='p-interaction']//li[" + i + "]"));     // trouve chaque element par incrementation
            String itemName = item.getText();                                                              // recupere le nom dans le menu
            System.out.println(itemName);                                                                  // imprime
        }
    }

    @Test
    public void NavigInteraction2() // le meme test mais d'une autre maniere
    {
        if(onTheWelcomePage()){
            click(By.cssSelector("a#js-link-box-en"));
        }
        getInteractionMenuItemsList();

    }
}
