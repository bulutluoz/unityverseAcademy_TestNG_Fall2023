package tests.day11_POM;

import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C08_WebuniversityTest {

    @Test
    public void test01(){
        //“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("webuniversityUrl"));
        //“Our Products” butonuna basin
        WebuniversityPage webuniversityPage = new WebuniversityPage();
        Driver.getDriver().switchTo().frame(webuniversityPage.iFrameElementi);

        webuniversityPage.ourProductsLinki.click();

        //“Cameras product”i tiklayin

        webuniversityPage.camerasElementi.click();
        //Popup mesajini yazdirin
        System.out.println(webuniversityPage.popupYaziElementi.getText());
        //“close” butonuna basin
        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin

        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}
