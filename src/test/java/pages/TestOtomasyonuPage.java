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

    @FindBy(xpath = "(//i[@class='fas fa-plus mx-2'])[1]")
    public WebElement adresEkleButonu;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement adresEkleFormuIsimKutusu;

    @FindBy(xpath = "(//*[text()='Add Address'])[2]")
    public WebElement adresEkleFormuSubmitButonu;

    @FindBy(xpath = "//div[@class='address-box']")
    public WebElement kullaniciAdresiElementi;

    @FindBy(xpath = "(//span[@class='checkmark'])[1]")
    public WebElement billingAdressCheckBox;

    @FindBy(xpath = "(//span[@class='checkmark'])[2]")
    public WebElement deliveryAdressSameCheckBox;

    @FindBy(xpath = "(//span[@class='checkmark'])[3]")
    public WebElement shippingMethodCheckBox;

    @FindBy(xpath = "//*[@name='accept_terms']")
    public WebElement acceptTermsCheckBox;

    @FindBy(xpath = "//*[@*='button-block button-place mt-3']")
    public WebElement placeOrderNowButonu;

    @FindBy(xpath = "//h2")
    public WebElement alisverisBasariliYaziElementi;
}
