package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    public TestOtomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//li[@class='has-sub'])[1]")
    public WebElement electronicsLinki;

    @FindBy(xpath = "//li[@class='acc_head']")
    public List<WebElement> kategoriElementList;


    @FindBy(xpath = "//div[@class='product-box my-2  py-1']")
    public List<WebElement> bulunanUrunlerListesi;
}
