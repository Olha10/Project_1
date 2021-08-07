package testbase;

import helpers.ElementsHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestBase {
    public static WebDriver driver;
    public static ElementsHelper elementsHelper;
    public String testUrl = ("https://icecat.biz");

    @BeforeGroups(groups="test_base")
    @Parameters("browser")
    public void setUp (Browsers browser){
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Invalid specified browser:" + browser + ",expected one of 'CHROME', 'FIREFOX', 'OPERA', 'EDGE', 'IE11'");
        }
        elementsHelper = new ElementsHelper(driver);
        driver.get(testUrl);
        driver.manage().window().maximize();
}
    @AfterGroups (groups="test_base")
    public void quit() {
        driver.quit();
    }

}
