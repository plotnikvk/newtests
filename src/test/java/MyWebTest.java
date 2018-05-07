import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.reflect.generics.tree.Tree;

/**
 * Created by plotnikvk  .
 */


public class MyWebTest {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sberbank.ru/ru/person/");
    }

    @Test
    public void test ()throws InterruptedException, NullPointerException, IllegalStateException{

        WebElement webElement = driver.findElement(By.xpath("//span[@class='region-list__arrow']"));
        new Actions(driver).moveToElement(webElement);
        webElement.click();

        WebElement region = driver.findElement(By.xpath("//input[@placeholder='Введите название региона']"));
        new Actions(driver).moveToElement(region);
        region.sendKeys("Нижегородская область");

        WebElement choiceElement = driver.findElement(By.xpath("//span[@class='region-search-box__option']/u"));
        new Actions(driver).moveToElement(choiceElement);
        choiceElement.click();

        WebElement selectedRegion = driver.findElement(By.xpath("//span[@class='region-list__name']"));
        String factRegion = selectedRegion.getText();

        WebElement footerElement =driver.findElement(By.xpath("//div[@class='footer-info']"));
        new Actions(driver).moveToElement(footerElement);
        footerElement.click();

        WebElement facebookSocialElement = driver.findElement(By.cssSelector("span[class*=fb]"));
        WebElement twitterSocialElement = driver.findElement(By.cssSelector("span[class*=tw]"));
        WebElement youtubeSocialElement = driver.findElement(By.cssSelector("span[class*=yt]"));
        WebElement instagramSocialElement = driver.findElement(By.cssSelector("span[class*=ins]"));
        WebElement odnoklassnikiSocialElement =driver.findElement(By.cssSelector("span[class*=ok]"));


        Assert.assertEquals("Выбранная область соответствует заданной","Нижегородская область",
                factRegion );
        Assert.assertTrue(facebookSocialElement.isDisplayed());
        Assert.assertTrue(twitterSocialElement.isDisplayed());
        Assert.assertTrue(youtubeSocialElement.isDisplayed());
        Assert.assertTrue(instagramSocialElement.isDisplayed());
        Assert.assertTrue(odnoklassnikiSocialElement.isDisplayed());
    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
