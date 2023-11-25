package tests.day12_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_POM {

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // dress icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("dress" + Keys.ENTER);
        // arama sonucunda urun bulunabildigini test edin
        int bulunanUrunSayisi = testOtomasyonuPage.bulunanUrunlerListesi.size();
        Assert.assertTrue(bulunanUrunSayisi > 0);
        // sayfayi kapatin
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
