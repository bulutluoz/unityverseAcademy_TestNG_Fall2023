package tests.day10_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.sql.Driver;

public class C01_HardAssert extends TestBase {

    @Test(groups = "e2e1")
    public void amazonTest(){
        /*
            TestNG JUnit'deki assertion method'larinin tamamina sahiptir
            sadece sirala JUnit'den farklidir

            Assert class'indan method'lar kullanarak yaptigimiz assertion'larda
            failed olan ilk assertion'da class'in calismasi durur
            kod hata verir.

            siz o hatayi duzelttikten sonra yeniden calistirirsaniz
            sonraki hatalari bulabilirsiniz
         */

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // url'in "https://www.amazon.com/" oldugunu test edin
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonuclarinin Nutella icerdigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedAramaIcerik = "Nutella";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedAramaIcerik));
        // ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        // ilk urun isminin Nutella icerdigini test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        String expectedUrunIcerik = "Nutella";
        String actualIlkurunIsmi = ilkUrunIsimElementi.getText();

        Assert.assertTrue(actualIlkurunIsmi.contains(expectedUrunIcerik));


    }

}
