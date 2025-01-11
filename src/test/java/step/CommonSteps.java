package step;

import com.thoughtworks.gauge.Step;
import driver.DriverFactory;
import methods.CommonMethods;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    CommonMethods helper = new CommonMethods(DriverFactory.getDriver());

    @Step("<url> adresine gidilir")
    public void goToUrl(String url) {
        helper.goToAddress(url);
    }

    @Step("<saniye> saniye beklenir")
    public void waitSecond(int second) throws InterruptedException {
        helper.waitSecond(second);
    }

    @Step("<text> metni sayfada var mı kontrol edilir")
    public void checkTextInPageAndAssert(String text) {
        helper.assertTextInPage(text);
    }

    @Step("<key> elementi sayfada var mı kontrol edilir")
    public void checkAndAssertElementExist(String key) {
        helper.waitForPresenceAssert(key);
    }

    @Step("Key değeri <key> olan elemana tıklanır")
    public void clickOnElement(String key) {
        helper.clickElement(key);
    }

    @Step("Key değeri <key> olan elemana <text> yazılır")
    public void sendTextToElement(String key, String text) {
        helper.sendKeys(key, text);
    }

    @Step("Key değeri <key> olan eleman önce silinir sonra <text> yazılır")
    public void clearAndSendText(String key, String text) {
        helper.clearAndSendKeys(key, text);
    }

    @Step("Key değeri <key> olan elementin görünmez olmasını beklenir")
    public void waitForElementInvisible(String key) {
        helper.waitForInvisibility(key);
    }

    @Step("<price> yolladığım tutar son işlemlerde var mı kontrol edilir")
    public void getLastTransactionAndCompareWithSentMoney(String price) {
        helper.getLastTransactionAndCompareWithSentMoney(price);
    }
}
