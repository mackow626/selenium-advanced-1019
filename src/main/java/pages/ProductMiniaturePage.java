package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.math.BigDecimal;

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

    public BigDecimal getPrice() {
        return new BigDecimal(price.getText().replace("$", ""));
    }

    public BigDecimal getPriceBeforeDiscount() {
        return new BigDecimal(priceBeforeDiscount.getText().replace("$", ""));
    }

    public String getName() {
        return name.getText().replace("...", "");
    }

    public boolean isNew() {
        return isPresent(newLabel);
    }

    public boolean hasImage() {
        return isPresent(image) & !image.getAttribute("src").contains("empty");
    }

    public boolean isDiscounted() {
        return isPresent(discountLabel);
    }

    public BigDecimal getDiscountValue() {
        return new BigDecimal(discountLabel.getText()
                .replace("%", "")
                .replace("-", ""));
    }

    public void open() {
        click(name);
    }

}
