package tests.day9_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_Priority extends TestBase {
    /*
        TestNG'de birden fazla test method'u calisacaksa, isim sirasina gore calisir

        eger priority ile siralama yapilmissa, priority degeri kucukten buyuge gore calisir
        eger ayni priority degerine sahip olan varsa isim sirasina gore calisir
        eger priority degeri atanmamissa, default deger olan prioruty=0 a gore calisir

     */

    @Test(priority = -23)
    public void amazonTest(){

        driver.get("https://www.amazon.com");
        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test
    public void youtubeTest(){

        driver.get("https://www.youtube.com");
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test
    public void facebookTest(){

        driver.get("https://www.facebook.com");
        String expectedUrlIcerik = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

}
