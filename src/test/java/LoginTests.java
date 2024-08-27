import org.junit.jupiter.api.Test;
import org.apache.log4j.Logger;

public class LoginTests extends BaseTest {

    private static final Logger logger = Logger.getLogger(LoginTests.class);

    @Test
    void teknosagiristesti() throws InterruptedException {
        logger.info("Test başlıyor: teknosagiristesti");

        pageActions.searchForProduct("saat");
        pageActions.waitForSearchResults();

        logger.info("İlk ürüne tıklanıyor.");
        pageActions.clickOnFirstProduct();      // saat listesindeki ilk ürüne tıklama

        if (pageActions.isAddToCartButtonVisible()) {
            logger.info("Sepete ekle butonu bulundu.");
        }
        else {
            logger.warn("Sepete ekle butonu bulunamadı.");
        }

        logger.info("Test tamamlandı: teknosagiristesti");
    }
}






//  pageActions.showAlertMessage("Sepete ekle Butonu bulundu!");
//   pageActions.showAlertMessage("Sepete ekle Butonu bulunamadı!");