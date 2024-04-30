package goIntoSeries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object class for Cinemax.com homepage.
 */
public class CinemaxHomePage {
    private WebDriver driver;

    // Locators
    private By viewMoreButton = By.cssSelector("div.hero-module-container-content div.hero-content a.hero-button");
    private By streamOn = By.cssSelector("div.hero-module-container-content div.hero-content div.hero-button-container");
    private By acceptOT = By.cssSelector("div#onetrust-consent-sdk div#onetrust-banner-sdk div.ot-sdk-container button#onetrust-accept-btn-handler");
    //private By viewMoreButton = By.id("viewMoreButton"); // Example locator, adjust based on actual application

    /**
     * Constructor for the goIntoSeries.CinemaxHomePage class.
     * @param driver WebDriver instance to interact with the page
     */
    public CinemaxHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method to click on the "View More" button.
     */
    public void clickViewMore() {
        WebElement viewMoreBtn = driver.findElement(viewMoreButton);
        viewMoreBtn.click();
    }

    /**
     * Method to verify if the "View More" button is present.
     * @return true if the button is present, false otherwise
     */
    public boolean isViewMorePresent() {
        return driver.findElements(viewMoreButton).size() > 0;
    }

    /**
     * Method to verify if the "View More" button is present.
     * @return true if the button is present, false otherwise
     */
    public boolean isStreamOnPresent() {
        return driver.findElements(streamOn).size() > 0;
    }

    /**
     * Method to click on the "View More" button.
     *
     * @return
     */
    public String streamOnHBO() {
        WebElement viewMoreBtn = driver.findElement(streamOn);
        return  viewMoreBtn.getText();
    }

    public void waitImplicit() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void acceptOneTrust() {
        try {
            WebElement acceptOneTrust = driver.findElement(acceptOT);
            acceptOneTrust.click();
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }
}
