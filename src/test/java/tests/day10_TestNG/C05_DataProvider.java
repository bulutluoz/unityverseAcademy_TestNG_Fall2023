package tests.day10_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_DataProvider extends TestBase {

    /*
        Data Provider, @DataProvider notasyonu ile isaretlenmis
        ve bize iki katli bir Object[][] donen bir method'dur
     */

    @DataProvider
    public static Object[][] listeYollayacakProvider() {

        String[][] aranacakUrunler = {{"Nutella"}, {"Java"}, {"Armut"}, {"elma"}, {"Erik"}, {"Malatya"}};

        return aranacakUrunler;
    }

    // String[] aranacakUrunler = {"Nutella", "Java", "Armut", "elma", "Erik", "Malatya"};
    // data provider kendisine verilen array'deki elementleri
    // tek tek parametre olarak bizim test method'umuza yollar



    @Test(dataProvider = "listeYollayacakProvider")
    public void aramaTesti(String aranacakUrun){
        // amazona gidelim
        driver.get("https://www.amazon.com");

        // parametre olarak dataProvider'in bize yolladigi urunu aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);

        // urun icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edelim
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aramasonucStr = aramaSonucElementi.getText();

        String[] aramaSonucKelimeleri = aramasonucStr.split(" ");
        String aramasonucSayisiStr;

        if (aramaSonucKelimeleri[2].equals("over")) {
            aramasonucSayisiStr = aramaSonucKelimeleri[3];
        } else {
            aramasonucSayisiStr = aramaSonucKelimeleri[2];
        } // 3,000 String olarak arama sonuc sayisi

        aramasonucSayisiStr = aramasonucSayisiStr.replaceAll("\\D", ""); // "3000"
        int aramaSonucSayisiInt = Integer.parseInt(aramasonucSayisiStr); // 3000

        Assert.assertTrue(aramaSonucSayisiInt>1000);
    }

}
