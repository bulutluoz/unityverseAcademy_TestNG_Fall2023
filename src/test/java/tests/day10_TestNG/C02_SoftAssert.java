package tests.day10_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C02_SoftAssert extends TestBase {

    @Test
    public void amazonTest(){
        /*
            TestNG bir method'da birden fazla assertion oldugunda
            tum assertion'lari tek seferde raporlama icin
            bize SoftAssert class'indan method'lar sunmustur.

            SoftAssert ile assertion'lari yapmak icin
            1- softAssert objesi olustur
            2- istenilen tum assertion'lari yap
            3- tum assertion'lar bittikten sonra, sonucu raporlatmak icin sotfAssert.assertAll() kullan
         */

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // url'in "https://www.amazon.com/" oldugunu test edin
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualUrl,expectedUrl,"url test");

        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonuclarinin Nutella icerdigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedAramaIcerik = "Nutella";
        String actualAramaSonucu = aramaSonucElementi.getText();

        softAssert.assertTrue(actualAramaSonucu.contains(expectedAramaIcerik),"nutella arama");
        // ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        // ilk urun isminin Nutella icerdigini test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        String expectedUrunIcerik = "Kutella";
        String actualIlkurunIsmi = ilkUrunIsimElementi.getText();

        softAssert.assertTrue(actualIlkurunIsmi.contains(expectedUrunIcerik),"ilk urun isim");

        softAssert.assertAll();
        System.out.println("failed olan assertion olursa bu satir calismaz");
        /*
            SoftAssert birden fazla assertion failed olsa da calismaya devam etmesi icin kullanilir
            biz assertAll() kullanincaya kadar, buldugu hatalari kendisi not eder, calismayi durdurmaz

            assertAll() satirina geldiginde tum assertion sonuclarini rapor eder
            ve failed olan assertion varsa assertAll() calistiginda kodun calismasi durur
            ve tum failed olan assertion'lar raporlanir

            assertion'lardan sonra assertAll() yazilmazsa
            failed olan assertion'lar olsa da test passed olur

         */
    }
}
