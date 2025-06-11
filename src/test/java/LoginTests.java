import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

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

}
