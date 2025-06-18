import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {

    @Test
    public void loginEmptyEmailPassword() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();

        emailField.sendKeys("demo@testpro.io");

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }


    public WebDriver driver = null;
    public String url="https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void Inititatebrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod

    public void closeBrowser() {
        driver.quit();
    }

    public void navigateUrl(){

        driver.get(url);

    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

}