package tests.day13_TestNGReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluPozitifLoginTesti extends TestBaseRapor {

    @Test
    public void pozitifLoginTesti(){
        extentTest = extentReports.createTest("pozitif login testi","Kullanici gecerli bilgilerle login olabilmeli");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");
        //2- account linkine basin
        ReusableMethods.bekle(2);
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");
        //3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.signInEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");
        //4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli password girer");
        //5- Sign in butonuna basarak login olun
        ReusableMethods.bekle(2);
        testOtomasyonuPage.signInFormuSubmitButonu.click();
        extentTest.info("Sign in butonuna basarak login olur");
        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");
        ReusableMethods.bekle(1);
        //7-sayfayi kapatin
        Driver.closeDriver();
    }
}
