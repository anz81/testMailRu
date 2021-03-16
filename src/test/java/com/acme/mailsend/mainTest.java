package com.acme.mailsend;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Arrays;
import static org.junit.Assert.assertTrue;

public class mainTest {

    private ConfProperties confProperties;
    private LoginPage logPage;
    private MailList mainList;
    private LetterPage letterPage;

    @Test
    public void mailRuTest() {
        confProperties = new ConfProperties();
        System.setProperty("webdriver.chrome.driver", confProperties.getProperty("chromedriver"));
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
        WebDriver driver = new ChromeDriver(capabilities);
        driver.get("https://mail.ru/");
        logPage = new LoginPage(driver);
        logPage.enterEmail(confProperties.getProperty("login"))
                .pressButtonPassword()
                .enterPassword(confProperties.getProperty("pswrd"))
                .pressButtonLogin();
        mainList = new MailList(driver);
        mainList.pressButtonCompose();
        letterPage = new LetterPage(driver);
        letterPage.enterAddress(confProperties.getProperty("email"))
                .enterBody("test message")
                .pressButtonSend();
        assertTrue(letterPage.isSentMessageShown());
        driver.close();
    }
}
