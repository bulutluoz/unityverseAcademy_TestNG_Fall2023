package tests.day10_TestNG;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_DataProvider extends TestBase {


    @DataProvider
    public static Object[][] kullaniciBilgileriProvider() {

        Faker faker = new Faker();

        String[][] kullaniciListesi = new String[10][2];

        for (int i = 0; i <kullaniciListesi.length ; i++) {

            kullaniciListesi[i][0] = faker.internet().emailAddress();
            kullaniciListesi[i][1] = faker.internet().password();

        }

        return kullaniciListesi;
    }

    @Test (dataProvider = "kullaniciBilgileriProvider")
    public void negatifLoginTesti(String email, String password){
        // qualitydemy anasayfaya gidin
        driver.get("https://www.qualitydemy.com");

        // login linkine basin
        driver.findElement(By.linkText("Log in")).click();

        // bir liste olarak verilen yanlis kullanici email ve password'lerini deneyerek
        // sisteme giris yapilamadigini test edin

        WebElement emailKutusu = driver.findElement(By.id("login-email"));
        emailKutusu.sendKeys(email);

        WebElement passwordKutusu = driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys(password);

        // login butonuna basalim
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        // giris yapilamadigini test edelim
        emailKutusu = driver.findElement(By.id("login-email"));

        Assert.assertTrue(emailKutusu.isDisplayed());
    }
}
