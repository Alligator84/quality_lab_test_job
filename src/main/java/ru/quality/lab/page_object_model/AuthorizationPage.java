package ru.quality.lab.page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.quality.lab.domain.Authorization;

import java.time.Duration;

public class AuthorizationPage {

    private final WebDriver webDriver;
    private final Authorization authorization;

    private final By username = By.xpath(".//input[@name = 'username']");
    private final By pwd = By.xpath(".//input[@name = 'password']");
    private final By pwdButton = By.xpath(".//span[@class = 'inner-0-2-89 innerTextWrapper-0-2-90']");
    private final By loginButton = By.xpath(".//button[@data-test-id = 'submit-button']");

    public AuthorizationPage(WebDriver webDriver, Authorization authorization) {
        this.webDriver = webDriver;
        this.authorization = authorization;
    }

    public void waitForLoadAuthorizationPage() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(pwdButton).isDisplayed()));
    }

    public void waitForLoadFormForPassword() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(pwd).isDisplayed()));
    }

    public void fillFieldUsername() {
        webDriver.findElement(username).sendKeys(authorization.getUsername());
    }

    public void fillFieldPassword() {
        webDriver.findElement(pwd).sendKeys(authorization.getPassword());
    }

    public void clickPwdButton() {
        webDriver.findElement(pwdButton).click();
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public void authorization() {
        waitForLoadAuthorizationPage();
        fillFieldUsername();
        clickPwdButton();
        waitForLoadFormForPassword();
        fillFieldPassword();
        clickLoginButton();
    }
}