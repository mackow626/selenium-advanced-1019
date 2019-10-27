package pages.products;

import models.Order;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.math.BigDecimal;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span[itemprop='price']")
    private WebElement price;

    @FindBy(css = "h1")
    private WebElement name;

    @FindBy(css = "#quantity_wanted")
    private WebElement quantity;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;

    public String getName() {
        return name.getText();
    }

    public BigDecimal getPrice() {
        return new BigDecimal(price.getText().replace("$", ""));
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getAttribute("value"));
    }


    public void setQuantity(int quantity) {
        this.quantity.clear();
        sendKeys(this.quantity, String.valueOf(quantity));
    }

    public void addProductToBasket(Order expectedOrder) {
        Product productToSave = new Product(getName(), getPrice(), getQuantity());
        expectedOrder.addProduct(productToSave);
        click(addToCartButton);
    }
}
