package pages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.base.BasePage;

import java.math.BigDecimal;

public class BasketLine extends BasePage {
    public BasketLine(WebDriver driver, WebElement element) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }

    @FindBy(css = "a[data-id_customization='0']")
    private WebElement name;

    @FindBy(css = ".current-price")
    private WebElement price;

    @FindBy(css = "span.product-price")
    private WebElement totalPrice;

    @FindBy(css = ".js-cart-line-product-quantity")
    private WebElement quantity;

    public String getName() {
        return name.getText().toUpperCase();
    }

    public BigDecimal getPrice() {
        return new BigDecimal(price.getText().replace("$",""));
    }

    public BigDecimal getTotalPrice() {
        return new BigDecimal(totalPrice.getText().replace("$",""));
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getAttribute("value"));
    }
}
