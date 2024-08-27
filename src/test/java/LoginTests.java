import org.junit.jupiter.api.Test;
import org.apache.log4j.Logger;

public class LoginTests extends BaseTest {

    private static final Logger logger = Logger.getLogger(LoginTests.class);

    @Test
    void teknosagiristesti() throws InterruptedException {

        PageActions pageAction = new PageActions(driver);

        pageAction.searchForProduct("saat");
        pageAction.waitForSearchResults();
        pageAction.clickOnFirstProduct();
        pageAction.isAddToCartButtonVisible();

    }
}





