import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


/**
 * Created by tjmaher on 3/10/15.
 */
public class SelectSectionFindSublinksTest {


    private static WebDriver _driver;

    @BeforeClass
    public static void startSelenium(){
        System.setProperty("webdriver.chrome.driver", "/Users/tjmaher/code/commerce/selenium/src/test/resources/drivers/chromedriver");
        _driver = new ChromeDriver();

    }

    @Test
    public void hoverAndCountLinks(){
        _driver.get("http://fitbit.com/");
        new WebDriverWait(_driver, 10).until(ExpectedConditions.titleContains("Fitbit"));

        hoverAndPrintLinkTotal("Products");
        hoverAndPrintLinkTotal("Experiences");
        hoverAndPrintLinkTotal("Fun");
        hoverAndPrintLinkTotal("Help");


    }


    public static void hoverAndPrintLinkTotal(String subMenu){

        String _locator = "";

        switch (subMenu){

            case "Products":
                _locator = ".hdr-prod";
                break;
            case "Experiences":
                _locator = ".hdr-exps";
                break;
            case "Fun":
                _locator = ".hdr-fun";
                break;
            case "Help":
                _locator = ".hdr-help";
                break;
        }


        Actions mouse = new Actions(_driver);

        WebElement subMenuHoverLink = _driver.findElement(By.cssSelector(_locator));
        mouse.moveToElement(subMenuHoverLink).perform();


        System.out.println("Section: " + subMenu + ":\n");

        List<WebElement> elements = _driver.findElements(By.cssSelector(_locator + " [href]")); // Find ALL links under hdr-menu



        System.out.println("* This page has " + elements.size() + " links in this subsection.\n");

    }


    @AfterClass
    public static void closeSelenium(){
        _driver.quit();
    }


}



