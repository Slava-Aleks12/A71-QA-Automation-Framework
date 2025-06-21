import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test
public class LoginTests extends BaseTest {

    @Test
    public void registrationNavigation() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        String Url = "https://qa.koel.app/";
        driver.get(Url);
        WebElement registrationNavigation = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationNavigation.click();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void loginEmptyPassword() throws InterruptedException {

        navigateUrl();
        provideEmail("iaroslav.aleksandrov@testpro.io");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        navigateUrl();
        provideEmail("iaroslav.aleksandrov@testpro.io");
        providePassword("iTedHBsr");
        clickSubmit();
        Thread.sleep(2000);
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
    }

}
