package tests.day11_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C03_PageClassKullanimi {

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin

        Driver.getDriver().get("https://www.testotomasyonu.com");

        // electronics linlkine tiklayin

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.electronicsLinki.click();

        // sol tarafta cikan kategori listesinde 8 kategori bulundugunu test edin

        int expectedKategoriSayisi = 8;
        int actualKategoriSayisi= testOtomasyonuPage.kategoriElementList.size();

        Assert.assertEquals(actualKategoriSayisi,expectedKategoriSayisi);
        // sayfayi kapatin
        Driver.closeDriver();
    }
}
