import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.quality.lab.domain.Authorization;
import ru.quality.lab.page_object_model.AuthorizationPage;
import ru.quality.lab.page_object_model.MailPage;

public class AuthorizationTest {

    public static final String LOGIN = "https://account.mail.ru/login";
    public static final String INBOX = "https://e.mail.ru/inbox/";
    private WebDriver driver;
    private Authorization authorization;

    @Before
    public void init() {
        this.authorization = new Authorization();
    }

    @Test
    public void positiveAuthorizationAndSentMail() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(LOGIN);
        driver.manage().window().maximize();

        AuthorizationPage authorizationPage = new AuthorizationPage(driver, authorization);
        authorizationPage.authorization();

        driver.get(INBOX);
        MailPage mailPage = new MailPage(driver, authorization);
        mailPage.waitForLoadMailPage();
        mailPage.sendEmail();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}