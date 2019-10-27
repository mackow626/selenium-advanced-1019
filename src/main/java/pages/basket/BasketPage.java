package pages.basket;

import models.Order;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.commons.TopMenuPage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
        menu = new TopMenuPage(driver);
        System.out.println("otwieram BasketPage");
    }

    @FindBy(css = ".cart-item")
    private List<WebElement> basketLines;

    @FindBy(css = "#cart-subtotal-products .value")
    private WebElement totalOrderPrice;

    private TopMenuPage menu;

    public BigDecimal getTotalOrderPrice() {
        return new BigDecimal(totalOrderPrice.getText().replace("$", ""));
    }

    public TopMenuPage getMenu() {
        return menu;
    }

    // rzutowanie List<WebElement> -> List<BasketLine>
    public List<BasketLine> getAllLines() {
        List<BasketLine> allLines = new ArrayList<>();

        for (WebElement line : basketLines) {
            allLines.add(new BasketLine(getDriver(), line));
        }
        return allLines;
    }

    // rzutowanie List<BasketLine> -> List<Product>
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();

        for (BasketLine line : getAllLines()) {
            allProducts.add(new Product(line.getName(), line.getPrice(), line.getQuantity(), line.getTotalPrice()));
        }
        return allProducts;
    }

    public Order toOrder() {
        return new Order(getAllProducts(), getTotalOrderPrice());
    }
}
