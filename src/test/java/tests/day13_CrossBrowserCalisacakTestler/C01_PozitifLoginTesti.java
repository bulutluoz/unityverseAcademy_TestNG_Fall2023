package tests.day13_CrossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_PozitifLoginTesti extends TestBaseCross {

    @Test
    public void pozitifLoginTesti(){
        // POM'de ihtiyacimiz olan locate'leri page sayfalarinda hazirliyorduk
        // ama page sayfalarina bizim normal Driver class'imiz tanimlandigindan
        // oradaki locate'leri cross browser testlerde KULLANAMAYIZ

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        WebElement accountLinki = driver.findElement(By.xpath("(//span[text()='Account'])[1]"));
        accountLinki.click();
        //3- Kullanici email'i olarak gecerli email girin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        //4- Kullanici sifresi olarak gecerli password girin
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //5- Sign in butonuna basarak login olun
        driver.findElement(By.xpath("//*[@id='submitlogin']")).click();
        //6- Basarili olarak giris yapilabildigini test edin
        WebElement logOutButonu = driver.findElement(By.xpath("//span[text()='Logout']"));
        Assert.assertTrue(logOutButonu.isDisplayed());

        ReusableMethods.bekle(3);
    }
}
