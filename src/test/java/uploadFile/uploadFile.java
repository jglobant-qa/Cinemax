package uploadFile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class uploadFile {
    private WebDriver driver;

    private By uploadButton = By.cssSelector("body input#fileField.upload");
    private String fileName = "/Users/jose.becerra/Desktop/test.txt";

    public uploadFile(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnUpload(){
        WebElement uploadBtn = driver.findElement(uploadButton);
        uploadBtn.sendKeys(fileName);
    }

    public boolean isUploadPresent() {
        return driver.findElements(uploadButton).size() > 0;
    }

    public void waitImplicit() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
