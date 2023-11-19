package tests.day11_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C07_QualitydemyNegatifLoginTesti {
    // 1- https://www.qualitydemy.com/ anasayfasina gidin
    // 2- login linkine basin
    // 3-  3 farkli test method’u olusturun.
    //	- gecerli username, gecersiz password
    //	- gecersiz username, gecerli password
    //	- gecersiz username, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin

    @Test
    public void gecersizPasswordTesti(){
        // 1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // 2- login linkine basin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginButonu.click();
        // 3-  3 farkli test method’u olusturun.
        //	- gecerli username, gecersiz password
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        //4- Login butonuna basarak login olun
        qualitydemyPage.loginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void gecersizUsernameTesti(){
        // 1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // 2- login linkine basin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginButonu.click();
        // 3-  3 farkli test method’u olusturun.
        //	- gecersiz username, gecerli password
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizEmail"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        //4- Login butonuna basarak login olun
        qualitydemyPage.loginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void gecersizUsernameGecersizPasswordTesti(){
        // 1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // 2- login linkine basin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginButonu.click();
        // 3-  3 farkli test method’u olusturun.
        //	- gecersiz username, gecersiz password
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizEmail"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        //4- Login butonuna basarak login olun
        qualitydemyPage.loginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());
        Driver.closeDriver();
    }

}
