package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ProductMiniaturePage extends BasePage {
    public ProductMiniaturePage(WebDriver driver, WebElement element) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }
    
    @FindBy(className = "price")
    private WebElement price;

    @FindBy(className = "regular-price")
    private WebElement priceBeforeDiscount;

    @FindBy(className = "product-title")
    private WebElement name;

    @FindBy(className = "new")
    private WebElement newLabel;

    @FindBy(css = "img")
    private WebElement image;

    @FindBy(className = "discount-product")
    private WebElement discountLabel;

}
