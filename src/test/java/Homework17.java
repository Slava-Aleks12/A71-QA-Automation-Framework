import org.testng.annotations.Test;
import org.testng.Assert;

public class Homework17 extends BaseTest {


    @Test
    public void addSongToPlaylist() {
        String expectedSongAddedMsg = "Added 1 song into \"My Playlist.\"";
            // Step 4
        navigateUrl();
            // Step 5
        provideEmail("iaroslav.aleksandrov@testpro.io");
        providePassword("iTedHBsr");
        clickSubmit();
            // Step 6
        searchSong("If I Find A Way");
            // Step 7
        clickViewAllBtn();
            // Step 8
        selectFirstSong();
            // Step 9
        clickAddToBtn();
            // Step 10
        selectPlaylist();
            // Step 11
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMsg);

        }

}

