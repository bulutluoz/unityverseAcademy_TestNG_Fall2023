package tests.day11_POM;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_FacebookGirisTesti {

    @Test
    public void facebookTesti(){

        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        // cookies'i kabul edin
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookieKabulButonu.click();
        ReusableMethods.bekle(1);
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin


        Faker faker = new Faker();
        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.sifreKutusu.sendKeys(faker.internet().password());
        facebookPage.girisYapButonu.click();

        //4- Basarili giris yapilamadigini test edin

        Assert.assertTrue(facebookPage.girisYapilamadiElementi.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();

    }
}
