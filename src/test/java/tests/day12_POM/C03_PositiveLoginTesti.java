package tests.day12_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_PositiveLoginTesti {

    @Test
    public void pozitifLoginTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.signInEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        //4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //5- Sign in butonuna basarak login olun
        testOtomasyonuPage.signInFormuSubmitButonu.click();
        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutButonu.isDisplayed());
        ReusableMethods.bekle(1);
        //7-sayfayi kapatin
        Driver.closeDriver();
    }
}
