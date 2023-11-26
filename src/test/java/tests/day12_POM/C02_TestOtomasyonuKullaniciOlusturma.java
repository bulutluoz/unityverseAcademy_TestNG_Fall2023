package tests.day12_POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_TestOtomasyonuKullaniciOlusturma {

    @Test
    public void kullaniciOlusturmaTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //3- signup linkine tiklayin
        testOtomasyonuPage.signUpLinki.click();
        //4- ilgili alanlari doldurarak signup tusuna basin

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        testOtomasyonuPage.signUpFirstnameKutusu.click();

        actions .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"))
                .perform();
        ReusableMethods.bekle(10);
        testOtomasyonuPage.signUpFormuSubmit.click();
        ReusableMethods.bekle(5);
    }
}
