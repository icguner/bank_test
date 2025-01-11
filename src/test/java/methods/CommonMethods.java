package methods;

import driver.Hooks;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.locater.LocaterParser;

import java.time.Duration;

public class CommonMethods {
    private static final Logger log = LoggerFactory.getLogger(CommonMethods.class);
    private WebDriver driver;
    private WebDriverWait wait;

    private static final int defaultElementWaitTime = 10;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(defaultElementWaitTime));
    }

    public void goToAddress(String url) {
        try {
            driver.navigate().to(url);
            log.info(url + " adresine gidiliyor");
            Hooks.getScenario().pass("Navigated to: " + url);
        } catch (Exception e) {
            log.error("Navigasyon hatası: ", e);
            Hooks.getScenario().fail("Navigasyon hatası: " + e.getMessage());
            throw e;
        }
    }

    public void waitSecond(int second) {
        try {
            Thread.sleep(second * 1000L);
            log.info(second + " saniye beklendi");
            Hooks.getScenario().pass(second + " saniye beklendi");
        } catch (InterruptedException e) {
            log.error("Bekleme hatası: ", e);
            Hooks.getScenario().fail("Bekleme hatası: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void waitForPresenceAssert(String elementName) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(LocaterParser.getBy(elementName)));
            Assert.assertNotNull("Element mevcut olmalı: " + elementName, element);
            log.info(elementName + " elementi görüldü.");
            Hooks.getScenario().pass(elementName + " elementi görüldü.");
        } catch (TimeoutException e) {
            log.error(elementName + " elementi " + defaultElementWaitTime +  " saniye içerisinde bulunamadı.", e);
            Hooks.getScenario().fail(elementName + " elementi " + defaultElementWaitTime +  " saniye içerisinde bulunamadı.");
            Assert.fail(elementName + " elementi " + defaultElementWaitTime +  " saniye içerisinde bulunamadı.");
        }
    }

    public void waitForPresence(String elementName) {
        try {
            wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            LocaterParser.getBy(elementName)
                    )
            );
            log.info(elementName + " elementinin yüklenmesi beklendi");
            Hooks.getScenario().pass(elementName + " elementinin yüklenmesi beklendi");
        } catch (TimeoutException e) {
            log.error(elementName + " elementinin yüklenmesi beklenirken hata oluştu.", e);
            Hooks.getScenario().fail(elementName + " elementinin yüklenmesi beklenirken hata oluştu.");
            throw e;
        }
    }

    public void waitForInvisibility(String elementName) {
        try {
            wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(
                            LocaterParser.getBy(elementName)
                    )
            );
            log.info(elementName + " elementinin görülmediği kontrol edildi");
            Hooks.getScenario().pass(elementName + " elementinin görülmediği kontrol edildi");
        } catch (TimeoutException e) {
            log.error(elementName + " elementinin görülmediğini kontrol ederken hata oluştu.", e);
            Hooks.getScenario().fail(elementName + " elementinin görülmediğini kontrol ederken hata oluştu.");
            throw e;
        }
    }

    public void assertTextInPage(String text) {
        try {
            String textLocator = driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")).getText();
            Assert.assertTrue("Sayfadaki metin, beklenen metni içermiyor: " + text,
                    textLocator.contains(text));
            log.info(text + " metni sayfada görüldü");
            Hooks.getScenario().pass(text + " metni sayfada görüldü");
        } catch (AssertionError e) {
            log.error("Metin doğrulama hatası: ", e);
            Hooks.getScenario().fail("Metin doğrulama hatası: " + e.getMessage());
            throw e;
        }
    }

    public void clickElement(String elementName) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            LocaterParser.getBy(elementName)
                    )
            );
            element.click();
            log.info(elementName + " elementine tıklandı");
            Hooks.getScenario().pass(elementName + " elementine tıklandı");
        } catch (Exception e) {
            log.error(elementName + " elementine tıklanamadı: ", e);
            Hooks.getScenario().fail(elementName + " elementine tıklanamadı: " + e.getMessage());
            throw e;
        }
    }

    public void clickIfElementExistAndContinue(String elementName) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            LocaterParser.getBy(elementName)
                    )
            );
            element.click();
            log.info(elementName + " elementine tıklandı");
            Hooks.getScenario().pass(elementName + " elementine tıklandı");
        } catch (TimeoutException ex) {
            log.info(elementName + " elementine bulunamadığı için tıklanamadı, devam ediliyor");
            Hooks.getScenario().info(elementName + " elementine bulunamadığı için tıklanamadı, devam ediliyor");
        }
    }

    public void sendKeys(String elementName, String text) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            LocaterParser.getBy(elementName)
                    )
            );
            element.sendKeys(text);
            log.info(elementName + " elementine " + text + " texti yazıldı");
            Hooks.getScenario().pass(elementName + " elementine " + text + " texti yazıldı");
        } catch (Exception e) {
            log.error(elementName + " elementine text yazılamadı: ", e);
            Hooks.getScenario().fail(elementName + " elementine text yazılamadı: " + e.getMessage());
            throw e;
        }
    }

    public void clearAndSendKeys(String elementName, String text) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            LocaterParser.getBy(elementName)
                    )
            );
            element.clear();
            element.sendKeys(text);
            log.info(elementName + " elementi temizlendi ve " + text + " texti yazıldı");
            Hooks.getScenario().pass(elementName + " elementi temizlendi ve " + text + " texti yazıldı");
        } catch (Exception e) {
            log.error(elementName + " elementi temizlenemedi veya text yazılamadı: ", e);
            Hooks.getScenario().fail(elementName + " elementi temizlenemedi veya text yazılamadı: " + e.getMessage());
            throw e;
        }
    }

    public void clearElement(String elementName) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            LocaterParser.getBy(elementName)
                    )
            );
            element.clear();
            log.info(elementName + " elementi temizlendi");
            Hooks.getScenario().pass(elementName + " elementi temizlendi");
        } catch (Exception e) {
            log.error(elementName + " elementi temizlenemedi: ", e);
            Hooks.getScenario().fail(elementName + " elementi temizlenemedi: " + e.getMessage());
            throw e;
        }
    }

    public void getLastTransactionAndCompareWithSentMoney(String money) {
        waitSecond(1);
        try {
            String lastTransactionXpath = "//div[contains(text(),'Transactions')]/following-sibling::div//div[contains(text(),'Amount:')]/following-sibling::div//div[contains(text(),'"+ money +"')]";
            WebElement amountElement = driver.findElement(By.xpath(lastTransactionXpath));
            log.info(money + " Gönderilen miktar son işlemlerde gözükmekte");
            Hooks.getScenario().pass(money + " Gönderilen miktar son işlemlerde gözükmekte");
            Assert.assertTrue("Gönderilen miktar son işlemlerde görünmektedir.", amountElement.isDisplayed());
        } catch (NoSuchElementException ex) {
            log.info(money + " Gönderilen miktar son işlemlerde gözükmüyor");
            Hooks.getScenario().fail(money + " Gönderilen miktar son işlemlerde gözükmüyor");
            Assert.fail(money + " Gönderilen miktar son işlemlerde gözükmüyor.");
        }
    }

}
