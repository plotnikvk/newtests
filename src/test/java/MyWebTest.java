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

        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr/td/div/div/div/div" +
                "/div/div[1]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/form/div[3]/a/span/span"));
        new Actions(driver).moveToElement(webElement);
        webElement.click();
        Thread.sleep(3000);

        WebElement region = driver.findElement(By.xpath("//input[@placeholder='Введите название региона']"));
        new Actions(driver).moveToElement(region);
        region.sendKeys("Нижегородская область");
        Thread.sleep(3000);

        WebElement choiceElement = driver.findElement(By.tagName("u"));
        new Actions(driver).moveToElement(choiceElement);
        choiceElement.click();
        Thread.sleep(3000);

        WebElement selectRegion = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr/td/div/div/div/" +
                "div/div/div[1]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/form/div[3]/a/span"));
        String factRegion = selectRegion.getText();
        Assert.assertEquals("Выбранная область соответствует заданной","Нижегородская область",
                factRegion );
//        Thread.sleep(3000);

        WebElement footerElement =driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr/td/div/div/" +
                "div/div/div/div[3]/div/div[2]/div/div/div[3]/div/div/div"));
        new Actions(driver).moveToElement(footerElement);
//        Thread.sleep(3000);
    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
