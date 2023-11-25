package tests.day12_POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_UrunAlisverisTesti {

    @Test
    public void urunAlisverisTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //3- gecerli kullanici adi ve sifre ile giris yapin
        testOtomasyonuPage.signInEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.signInPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        testOtomasyonuPage.signInFormuSubmitButonu.click();
        //4- electronics linkine tiklayin
        testOtomasyonuPage.electronicsLinki.click();
        //5- ilk urunu secip add to cart butonuna tiklayin
        testOtomasyonuPage.ilkUrunElementi.click();
        //7.adimda urunun sepete eklendigini test edebilmek icin
        //bu adimda urun ismini kaydediyorum
        String secilenUrunIsmi = testOtomasyonuPage.seciliUrunIsimElementi.getText();
        testOtomasyonuPage.addToCartButonu.click();
        //6- your Cart linkini tiklayin
        testOtomasyonuPage.yourCartLinki.click();
        //7- urunun sepete eklendigini test edin
        String sepettekiUrunIsmi = testOtomasyonuPage.sepettekiUrunIsimElementi.getText();

        Assert.assertTrue(secilenUrunIsmi.equalsIgnoreCase(sepettekiUrunIsmi));

        //8- checkout butonuna basin
        ReusableMethods.bekle(1);
        testOtomasyonuPage.checkoutButonu.click();

        //9- ilgili alanlari doldurup place order now butonuna basin
            // - adres yoksa adress ekleyin
        if (!testOtomasyonuPage.kullaniciAdresiElementi.isDisplayed()){
            testOtomasyonuPage.adresEkleButonu.click();
            testOtomasyonuPage.adresEkleFormuIsimKutusu.click();
            ReusableMethods.bekle(3);
            Actions actions = new Actions(Driver.getDriver());
            Faker faker = new Faker();
            actions.sendKeys(faker.name().firstName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().fullAddress())
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys("Turkey")
                    .sendKeys(Keys.TAB)
                    .sendKeys("Adana Province")
                    .sendKeys(Keys.TAB)
                    .sendKeys("Adana")
                    .sendKeys(Keys.TAB)
                    .sendKeys("01100")
                    .sendKeys(Keys.TAB).perform();
            ReusableMethods.bekle(5);
            testOtomasyonuPage.adresEkleFormuSubmitButonu.click();
        }
            // gereken checkbox'lari click yapin
        testOtomasyonuPage.billingAdressCheckBox.click();
        testOtomasyonuPage.deliveryAdressSameCheckBox.click();
        testOtomasyonuPage.shippingMethodCheckBox.click();
        testOtomasyonuPage.acceptTermsCheckBox.click();

        testOtomasyonuPage.placeOrderNowButonu.click();

        //10- your order is successfully done yazisinin ciktigini test edin

        Assert.assertTrue(testOtomasyonuPage.alisverisBasariliYaziElementi.isDisplayed());

        ReusableMethods.bekle(5);
        //Driver.closeDriver();
    }
}
