import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseTest {
    protected WebDriver driver;
    protected PageActions pageActions;

    private static final Logger logger = Logger.getLogger(LoginTests.class);

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.teknosa.com");
        logger.info("Test başlıyor: teknosagiristesti");
        pageActions = new PageActions(driver);

    }

    @AfterEach
    void tearDown() {
        logger.info("Test tamamlandı: teknosagiristesti");
        if (driver != null) {
            driver.quit();
        }
    }
}