import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    private static final Logger logger = Logger.getLogger(LoginTests.class);

    public PageActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));       //açılan sayfayı max 10 saniye kadar bekle
        this.js = (JavascriptExecutor) driver;
    }


    private By searchInput = By.id("search-input");                  // locator isimleri
    private By searchButton = By.className("sbx-search");
    private By firstProductLink = By.className("prd-link");
    private By addToCartButton = By.className("AddToCart-AddToCartAction");


    public void searchForProduct(String productName) {            //methodlar
        driver.findElement(searchInput).sendKeys(productName);
        Actions actions = new Actions(driver);
        WebElement searchBtn = driver.findElement(searchButton);
        actions.doubleClick(searchBtn).perform();
    }

    public void waitForSearchResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("prd-inner")));
    }

    public void clickOnFirstProduct() throws InterruptedException {    //saat kelimesi bulundu mu?
        WebElement link = driver.findElement(firstProductLink);
        String hrefValue = link.getAttribute("href");


        if (hrefValue.contains("watch")) {
            logger.info("Kelime bulundu!");
        //  showAlertMessage("Kelime bulundu!");
            link.click();
        } else {
            logger.warn("Kelime bulunamadı :(!");
            // showAlertMessage("Kelime bulunamadı :(!");
        }
    }

    public boolean isAddToCartButtonVisible() {             // sepeteekle butonu varmı diye kontrol etme

        try {
            WebElement button = driver.findElement(addToCartButton);
            return button.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void showAlertMessage(String message) {                       // ekranda msj verme
        js.executeScript("alert('" + message + "');");
        driver.switchTo().alert().accept();
    }
}