package ru.quality.lab.page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.quality.lab.domain.Authorization;

import java.time.Duration;

public class MailPage {

    private final WebDriver webDriver;
    private final Authorization authorization;

    private final By newMail = By.xpath(".//a[@class = 'compose-button compose-button_white compose-button_base compose-button_with-dropdown js-shortcut']");
    private final By sendButton = By.xpath(".//button[@data-test-id = 'send']");
    private final By recipient = By.xpath(".//label[@class = 'container--zU301']");
    private final By subject = By.xpath(".//input[@class = 'container--H9L5q size_s--3_M-_' and @name = 'Subject']");
    private final By emailConfirmation = By.xpath(".//a[@class = 'layer__link']");

    //TODO переработать локатор
    private final By body = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]");


    public MailPage(WebDriver webDriver, Authorization authorization) {
        this.webDriver = webDriver;
        this.authorization = authorization;
    }

    public void waitForLoadMailPage() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(newMail).isDisplayed()));
    }

    public void waitForLoadSendButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(sendButton).isDisplayed()));
    }

    public void waitEmailConfirmation() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(emailConfirmation).isDisplayed()));
    }

    public void clickButtonNewMail() {
        webDriver.findElement(newMail).click();
    }

    public void clickButtonSendMail() {
        webDriver.findElement(sendButton).click();
    }

    public void fillRecipient() {
        webDriver.findElement(recipient).sendKeys(authorization.getUsername());
    }

    public void fillSubject() {
        webDriver.findElement(subject).sendKeys("Test mail");
    }

    public void fillBody() {
        webDriver.findElement(body).sendKeys("Test mail");
    }

    public void sendEmail() {
        clickButtonNewMail();
        waitForLoadSendButton();
        fillRecipient();
        fillSubject();
        fillBody();
        clickButtonSendMail();
        waitEmailConfirmation();
    }
}