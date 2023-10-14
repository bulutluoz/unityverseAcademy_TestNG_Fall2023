package tests.day10_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_DataProvider extends TestBase {

    @Test
    public void amazonTopluArama() {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // verilen listedeki her bir urun icin arama yaptirin
        // her urun icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edin

        String[] aranacakUrunler = {"Nutella", "Java", "Armut", "elma", "Erik", "Malatya"};

        String[] aramaSonucKelimeleri;
        String aramasonucSayisiStr;
        String aramasonucStr;
        int aramaSonucSayisiInt;


        for (int i = 0; i < aranacakUrunler.length; i++) {
            WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.clear();
            aramaKutusu.sendKeys(aranacakUrunler[i] + Keys.ENTER);

            WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
            aramasonucStr = aramaSonucElementi.getText();

            // 1-48 of over 3,000 results for "nutella"

            aramaSonucKelimeleri = aramasonucStr.split(" ");
            // [1-48, of, over, 3,000, results, for, "nutella"]

            if (aramaSonucKelimeleri[2].equals("over")) {
                aramasonucSayisiStr = aramaSonucKelimeleri[3];
            } else {
                aramasonucSayisiStr = aramaSonucKelimeleri[2];
            } // 3,000

            aramasonucSayisiStr = aramasonucSayisiStr.replaceAll("\\D", ""); // "3000"
            aramaSonucSayisiInt = Integer.parseInt(aramasonucSayisiStr); // 3000

            Assert.assertTrue(aramaSonucSayisiInt > 1000);
        }
    }
}
