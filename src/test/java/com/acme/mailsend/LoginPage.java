package com.acme.mailsend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver _driver;

    LoginPage(WebDriver driver) {
        _driver = driver;
    }

    public LoginPage enterEmail(String login) {
        _driver.findElement(By.cssSelector("[data-testid=\"login-input\"]")).sendKeys(login);
        return this;
    }

    public LoginPage pressButtonPassword() {
        _driver.findElement(By.cssSelector("[data-testid=\"enter-password\"]")).click();
        return this;
    }

    public LoginPage enterPassword(String pswrd) {
        _driver.findElement(By.cssSelector("[data-testid=\"password-input\"]")).sendKeys(pswrd);
        return this;
    }

    public LoginPage pressButtonLogin() {
        _driver.findElement(By.cssSelector("[data-testid=\"login-to-mail\"]")).click();
        return this;
    }
}
