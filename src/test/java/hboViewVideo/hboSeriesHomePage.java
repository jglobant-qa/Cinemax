package hboViewVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hboSeriesHomePage {
    private WebDriver driver;

    //Locators
    private By heroMain = By.cssSelector("div.container div.hero-module-container-content div.hero-buttons-content a#page17387-band61935-Button232922");
    private By modalPlayBtn = By.cssSelector("div#modal-container div.modal-body div.box div.playButton");
    private By progressBar = By.cssSelector("div.tui div.tui-control-bar div.tui-progress-bar div.tui-bar__active-progress");
    private By CSSplayVideo = By.cssSelector("div.tui div.tui__control-surface div.tui__slate div.tui-start-slate");
    private By acceptOT = By.cssSelector("div#onetrust-consent-sdk div#onetrust-banner-sdk div.ot-sdk-container button#onetrust-accept-btn-handler");

    public hboSeriesHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnHero() {
        WebElement clickOnHero = driver.findElement(heroMain);
        clickOnHero.click();
    }

    public void clickOnPlay() {
        WebElement modalPLayBtn = driver.findElement(modalPlayBtn);
        modalPLayBtn.click();
    }

    public void playVideo()  {
        WebElement playWebVideo = driver.findElement(CSSplayVideo);
        playWebVideo.click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isVideoPlaying(){
        WebElement isPlaying = driver.findElement(progressBar);
        String[] playerValue = isPlaying.getAttribute("style").split(":");
        String[] progressValue = playerValue[2].split("%");
        String[] progress = progressValue[0].split("\\.");
        Integer progressBarValue = Integer.parseInt(progress[0].replaceAll("\\s", ""));
        return progressBarValue > 0;
    }

    public void ByVisibleElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Locating element by link text and store in variable "Element"
        WebElement Element = driver.findElement(CSSplayVideo);

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
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

