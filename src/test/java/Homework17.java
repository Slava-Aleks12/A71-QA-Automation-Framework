import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Homework17 {
    public static class LoginTests extends BaseTest {


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

        public void addSongToPlaylist() {
            String expectedSongAddedMsg = "Added 1 song into \"Second User Playlist.\"";

            // Navigate to koel app
            navigateUrl();

            // Log in with valid credentials
            provideEmail("iaroslav.aleksandrov@testpro.io");
            providePassword("iTedHBsr");
            clickSubmit();
            // Search for a song
            searchSong("Lament");
            // Click 'View All' button to display search results
            clickViewAllBtn();
            // Click the first song in the search results
            selectFirstSong();
            // Click the 'ADD TO...' button
            clickAddToBtn();
            // Choose the playlist to add selected song to
            selectPlaylist();
            //Assertion
            Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMsg);
        }
    }
}

