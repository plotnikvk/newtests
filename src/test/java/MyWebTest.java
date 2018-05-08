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

    //Константы для поиска объектов на странице
    private final By SelectRegionButtonPath = By.xpath("//span[@class='region-list__arrow']");
    private final By SearchRegionWindowPath = By.xpath("//input[@placeholder='Введите название региона']");
    private final By ChoiceRegionPath = By.xpath("//span[@class='region-search-box__option']/u");
    private final By SelectedRegionPath = By.xpath("//span[@class='region-list__name']");
    private final By FooterElementPath = By.xpath("//div[@class='footer-info']");
    private final By Fb_IconPath = By.cssSelector("span[class*=fb]");
    private final By Tw_IconPath = By.cssSelector("span[class*=tw]");
    private final By Yt_IconPath = By.cssSelector("span[class*=yt]");
    private final By Ins_IconPath = By.cssSelector("span[class*=ins]");
    private final By Ok_IconPath = By.cssSelector("span[class*=ok]");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sberbank.ru/ru/person/");
    }
      

    @Test
    public void test ()throws NullPointerException, IllegalStateException{

        WebElement webElement = driver.findElement(SelectRegionButtonPath);
        new Actions(driver).moveToElement(webElement);
        webElement.click();

        WebElement region = driver.findElement(SearchRegionWindowPath);
        new Actions(driver).moveToElement(region);
        region.sendKeys("Нижегородская область");

        WebElement choiceElement = driver.findElement(ChoiceRegionPath);
        new Actions(driver).moveToElement(choiceElement);
        choiceElement.click();

        WebElement selectedRegion = driver.findElement(SelectedRegionPath);
        String factRegion = selectedRegion.getText();

        WebElement footerElement =driver.findElement(FooterElementPath);
        new Actions(driver).moveToElement(footerElement);
        footerElement.click();

        WebElement facebookSocialElement = driver.findElement(Fb_IconPath);
        WebElement twitterSocialElement = driver.findElement(Tw_IconPath);
        WebElement youtubeSocialElement = driver.findElement(Yt_IconPath);
        WebElement instagramSocialElement = driver.findElement(Ins_IconPath);
        WebElement odnoklassnikiSocialElement =driver.findElement(Ok_IconPath);


        Assert.assertEquals("Выбранная область не соответствует заданной",
                "Нижегородская область", factRegion );
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
