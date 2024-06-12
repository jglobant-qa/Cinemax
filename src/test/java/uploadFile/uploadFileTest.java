package uploadFile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class uploadFileTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private uploadFile uploadFiles;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://filebin.net/");
        uploadFiles = new uploadFile(driver);
    }

    @Test
    public void doUploadFiles() {
        uploadFiles.waitImplicit();
        uploadFiles.isUploadPresent();
        uploadFiles.clickOnUpload();
        uploadFiles.waitImplicit();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
