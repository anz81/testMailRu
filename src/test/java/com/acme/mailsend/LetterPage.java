package com.acme.mailsend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LetterPage {
    private WebDriver _driver;

    LetterPage(WebDriver driver) {
        _driver = driver;
        _driver.switchTo().activeElement();
        WebDriverWait wait = new WebDriverWait(_driver, 50);
        try {
            WebElement field =
                    wait.until(presenceOfElementLocated(new By.ByXPath("//div/div/input")));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LetterPage enterAddress(String email) {
        _driver.findElement(new By.ByXPath("//div/div/input")).sendKeys(email);
        return this;
    }

    public LetterPage enterBody(String text) {
        _driver.findElement(new By.ByXPath("//div[5]/div/div/div[2]/div"))
                .sendKeys(text);
        return this;
    }

    public LetterPage pressButtonSend() {
        _driver.findElement(new By.ByXPath("//div[2]/div/span/span/span"))
                .click();
        return this;
    }

    public boolean isSentMessageShown() {
        boolean flag = false;
        WebDriverWait wait = new WebDriverWait(_driver, 50);
        try {
            WebElement field =
                    wait.until(presenceOfElementLocated(new By.ByXPath("/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[2]/a")));
            String s = field.getText();
            if (s.contains("Письмо отправлено"))
                flag = true;
        }
        catch (Exception e) {}
        return flag;
    }
}
