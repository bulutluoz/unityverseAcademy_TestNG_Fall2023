package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void tumSayfaFotografCek(WebDriver driver,String screenshotIsmi)  {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // dosya adini dinamik yapalim
        // target/screenshots/tumSayfaSS.png
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmm");
        localDateTime.format(istenenFormat); // 2310080829

        String dinamikDosyaAdi = "target/screenshots/"+screenshotIsmi+
                                    localDateTime.format(istenenFormat)+".jpg";
        File tumSayfaSS = new File(dinamikDosyaAdi);
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
            screenshot dosyasi icin hep ayni ismi kullanirsak
            tum cekilen fotograflar ayni isimle kaydedileceginden
            tek bir dosya olur, son cekilen fotograf eskilerin uzerine kaydolur

            cektigimiz fotograflarin hepsinin kalmasi
            ve istenilen isimde olmasi icin
            dosya adini dinamik yapalim

            1- method'un cagrildigi yerde bir fotograf ismi yazilsin
            2- method'da dosya ismine tarih etiketi ekleyelim
            ilkUrun2310080829
         */
    }

    public static void webelementScreenshotCek(WebElement istenenWebelement,String screenshotIsmi){

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmm");
        localDateTime.format(istenenFormat); // 2310080829

        String dinamikDosyaAdi = "target/screenshots/"+screenshotIsmi+
                localDateTime.format(istenenFormat)+".jpg";
        File webelementSS = new File(dinamikDosyaAdi);

        File geciciDosya = istenenWebelement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,webelementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

}
