package tests.day11_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_POM_ilkTest {

    @Test
    public void test01(){

        /*
            ilk ihtiyacimiz WebDriver
            daha once driver'i parent edindigimiz TestBase'den aliyorduk
            POM'de driver olusturmak icin extends ile parent edindigimiz TestBase
            class'ini kullanmak yerine

            Farkli bir class'da olup, bize bir WebDriver objesi donduren
            siradan bir method haline getirecegiz


         */


        Driver.getDriver().get("https://www.testotomasyonu.com");

        ReusableMethods.bekle(1);

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        aramaKutusu.sendKeys("shoes" + Keys.ENTER);

        ReusableMethods.bekle(2);

        Driver.closeDriver();

        Driver.getDriver().get("https://www.testotomasyonu.com");

        aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        ReusableMethods.bekle(2);

        Driver.closeDriver();
    }
}
