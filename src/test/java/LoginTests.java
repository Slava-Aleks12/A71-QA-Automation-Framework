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
    public void loginValidEmailPassword() throws InterruptedException {
        //Test Steps
        //Step 1 navigate to koel app
        navigateUrl();
        //Step 2 enter email
        provideEmail("kelly.wade@testpro.io");
        //Step 3 enter password
        providePassword("P!990109189300ok");
        //Step 4 click submit button
        clickSubmit();
        Thread.sleep(2000);
        //Step 5 verify user is logged in
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
    }
    @Test
    public void changeProfileName() throws InterruptedException {

        //Navigate to Koel app
        navigateUrl();
        //provide email
        provideEmail("iaroslav.aleksandrov@testpro.io");
        //provide password
        providePassword("iTedHBsr");
        //click submit
        clickSubmit();
        String randomName = randomName();
        //pause for 2 seconds for page to load
        Thread.sleep(2000);
        //click avatar icon to go to profile setting page
        clickAvatarIcon();
        //provide current Password
        provideCurrentPassword("P!990109189300ok");
        //provide profile name
        provideProfileName(randomName);
        //click save button
        clickSaveButton();
        //wait 2 seconds
        Thread.sleep(2000);
        //verify profile name change
        WebElement actualProfileName = driver.findElement(By.cssSelector("span[class='name']"));
        Assert.assertEquals(actualProfileName.getText(),randomName);
    }

}
