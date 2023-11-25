package tests.day12_POM;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginTesti {


    //3- 3 farkli test method’u olusturun.
    //	- gecerli username, gecersiz password
    //	- gecersiz username, gecerli password
    //	- gecersiz username, gecersiz password.
    //4- Sign in butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin

    TestOtomasyonuPage testOtomasyonuPage;

    @Test
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //3- 3 farkli test method’u olusturun.
        //	- gecerli username, gecersiz password
        testOtomasyonuPage.signInEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- Sign in butonuna basarak login olmayi deneyin
        testOtomasyonuPage.signInFormuSubmitButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.signInPasswordKutusu.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void gecersizUsernameTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //3- 3 farkli test method’u olusturun.
        //	- gecersiz username, gecerli password
        testOtomasyonuPage.signInEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //4- Sign in butonuna basarak login olmayi deneyin
        testOtomasyonuPage.signInFormuSubmitButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.signInPasswordKutusu.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void gecersizUsernameGecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //3- 3 farkli test method’u olusturun.
        //	- gecersiz username, gecersiz password.
        testOtomasyonuPage.signInEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- Sign in butonuna basarak login olmayi deneyin
        testOtomasyonuPage.signInFormuSubmitButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.signInPasswordKutusu.isDisplayed());
        Driver.closeDriver();
    }

}
