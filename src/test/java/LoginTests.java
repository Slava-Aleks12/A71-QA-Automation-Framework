import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {


    @Test
    public void LoginValidEmail() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        String Url= "https://qa.koel.app/";
        driver.get(Url);
        WebElement emailFiled= driver.findElement(By.cssSelector("a[href='registration']"));
        //emailFiled.sendKeys("iaroslav.aleksandrov@testpro.io");
        //WebElement passwordField= driver.findElement(By.cssSelector("input[type='password']"));
        //passwordField.sendKeys("iTedHBsr");
        //WebElement submitButton= driver.findElement(By.cssSelector("button[type='submit']"));
        //submitButton.click();
        Thread.sleep(2000);
        //WebElement avatar= driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assert.assertTrue(avatar.isDisplayed());
        driver.quit();
    }
}
