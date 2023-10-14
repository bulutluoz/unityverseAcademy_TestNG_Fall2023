package tests.day9_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBase_BeforeClass;

public class C02_DependsOnMethods extends TestBase_BeforeClass {
     /*
        DependsOnMethods priority'den farklidir

        DependsOnMethods hangi method'un once calisacagina karar vermez
        Sadece yazildigi test calismadan once, baglandigi testin
        calistigindan ve PASSED oldugundan emin olmak ister.

        bagli oldugu test calismaz veya calisir ama PASSED olmazsa
        DependsOnMethods'un yazildigi test IGNORE olur

        DependsOnMethods yazildigi method tek basina calistirilmak istenirse
        once bagli oldugu testin calismasi ve Passed olmasi gerektiginden
        kendinden once bagli oldugu method'un calismasini saglar

        Ama bu baglanti birden fazla method'u calistirmaz.

        priority kullanilarak bir method'un once calismasi istense de
        o method onceligi bagli oldugu method'a devreder
        bagli olunan method da baska method'a bagliysa once onu calistirir.
     */

    @Test(groups = {"smoke","e2e1","e2e2"})
    public void amazonTest(){
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // url'in amazon icerdigini test edin ve screenshot alin
        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test(dependsOnMethods = "amazonTest",groups = {"smoke"})
    public void nutellaTest(){

        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }

    @Test(dependsOnMethods = "nutellaTest")
    public void ilkUrunTest(){
    // ilk urune tiklayin
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"))
                .click();
        // urun isminin Nutella icerdigini test edin ve urun isminin screenshot alin

        WebElement urunIsimElementi= driver.findElement(By.xpath("//h1[@id='title']"));

        String expectedUrunIcerik = "Nutella";
        String actualUrunIsmi = urunIsimElementi.getText();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIcerik));
    }


}
