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

    @FindBy(xpath = "(//span[text()='Account'])[1]")
    public WebElement accountLinki;

    @FindBy(xpath = "//a[text()=' Sign Up']")
    public WebElement signUpLinki;

    @FindBy(id="firstName")
    public WebElement signUpFirstnameKutusu;

    @FindBy(id = "btn-submit-form")
    public WebElement signUpFormuSubmit;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement signInEmailKutusu;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement signInPasswordKutusu;

    @FindBy(xpath = "//*[@id='submitlogin']")
    public WebElement signInFormuSubmitButonu;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logoutButonu;

    @FindBy(xpath = "(//div[@class='product-box mb-2 pb-1'])[1]")
    public WebElement ilkUrunElementi;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement seciliUrunIsimElementi;

    @FindBy(xpath = "//button[@class='add-to-cart']")
    public WebElement addToCartButonu;

    @FindBy(xpath = "(//span[text()='Your Cart'])[1]")
    public WebElement yourCartLinki;

    @FindBy(xpath = "//*[@*='product-title text-center']")
    public WebElement sepettekiUrunIsimElementi;

    @FindBy(xpath = "//*[@*='button-block button-place']")
    public WebElement checkoutButonu;
}
