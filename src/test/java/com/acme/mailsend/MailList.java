package com.acme.mailsend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class MailList {
    private WebDriver _driver;

    MailList(WebDriver driver) {
        _driver = driver;
        WebDriverWait wait = new WebDriverWait(_driver, 50);
        try {
            WebElement element =
                    wait.until(presenceOfElementLocated(By.cssSelector(".ico_16-compose")));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MailList pressButtonCompose() {
        _driver.findElement(By.cssSelector(".ico_16-compose")).click();
        return this;
    }
}
