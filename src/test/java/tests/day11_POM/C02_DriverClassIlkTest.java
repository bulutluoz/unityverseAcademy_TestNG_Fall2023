package tests.day11_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DriverClassIlkTest {

    @Test
    public void test01(){

        // testotomasyonu.com anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip aratin
        WebElement aramaKutusu= Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda gelen urunlerden ilkine tiklayin
        Driver.getDriver()
                .findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]")).click();
        // urun isim detayinda phone gectigini test edin

        WebElement urunAciklamaElementi = Driver.getDriver().findElement(By.xpath("//div[@class='product-short-desc  my-2']"));


        String urunAciklamasi = urunAciklamaElementi.getText().toLowerCase();

        Assert.assertTrue(urunAciklamasi.contains("phone"));

        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
