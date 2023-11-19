package tests.day11_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_ConfigReaderKullanimi {

    @Test
    public void test01(){

        // testotomasyonu.com anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // belirlenmis aranacakKelime icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // arama islemi sonucunda urun goruntulendigini test edin
        // bu test icin bulunan urunleri bir listeye kaydettik
        // listenin bos olmadigini test ediyoruz

        Assert.assertTrue(testOtomasyonuPage.bulunanUrunlerListesi.size()>0,"Aranan urun bulunamadi");

        // sayfayi kapatin

        ReusableMethods.bekle(12);
        Driver.closeDriver();

    }
}
