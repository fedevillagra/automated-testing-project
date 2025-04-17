package login;
import base.BaseTests;
import com.epam.automation.models.LoginPage;
import org.junit.jupiter.api.*;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class LoginTests extends BaseTests {
    private LoginPage loginPage;

    @BeforeEach
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginWithEmptyCredentials() {
        try {
            loginPage.login("", "");
            String errorMessage = loginPage.getErrorMessage();
            MatcherAssert.assertThat(errorMessage, Matchers.containsString("Username is required"));
            logger.info("UC-1 passed");
        } catch (Throwable t) {
            takeScreenshot("testLoginWithEmptyCredentials");
            throw t;
        }
    }

    @Test
    public void testLoginWithUsernameOnly() {
        try {
            loginPage.login("standard_user", "");
            String errorMessage = loginPage.getErrorMessage();
            MatcherAssert.assertThat(errorMessage, Matchers.containsString("Password is required"));
            logger.info("UC-2 passed");
        } catch (Throwable t) {
            takeScreenshot("testLoginWithUsernameOnly");
            throw t;
        }
    }

    @Test
    public void testSuccessfulLogin() {
        try {
            loginPage.login("standard_user", "secret_sauce");
            String title = loginPage.getPageTitle();
            MatcherAssert.assertThat(title, Matchers.equalTo("Swag Labs"));
            logger.info("UC-3 passed");
        } catch (Throwable t) {
            takeScreenshot("testSuccessfulLogin");
            throw t;
        }
    }
}
