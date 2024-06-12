package hboViewVideo;

import goIntoSeries.CinemaxHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import viewSeries.SeriesHomePage;

public class hboSeriesNavigationTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private hboSeriesHomePage hboSeriesHomePage;
    private CinemaxHomePage cinemaxHomePage;
    private SeriesHomePage seriesHomePage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.hbo.com/");
        hboSeriesHomePage = new hboSeriesHomePage(driver);
        cinemaxHomePage = new CinemaxHomePage(driver);
        seriesHomePage = new SeriesHomePage(driver);
    }

    @Test
    public void playVideo() {
        cinemaxHomePage.waitImplicit();
        hboSeriesHomePage.acceptOneTrust();
        cinemaxHomePage.waitImplicit();
        hboSeriesHomePage.clickOnHero();
        cinemaxHomePage.waitImplicit();
        hboSeriesHomePage.clickOnPlay();
        cinemaxHomePage.waitImplicit();
        seriesHomePage.isVideoPlaying();
        cinemaxHomePage.waitImplicit();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
