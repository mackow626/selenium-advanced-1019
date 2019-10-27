package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ListOfProductsPage extends BasePage {
    @FindBy(css = ".thumbnail-container")
    private List<WebElement> products;

    public ListOfProductsPage(WebDriver driver) {
        super(driver);
    }

    // rzutowanie List<WebElement> -> List<ProductMiniaturePage>
    public List<ProductMiniaturePage> getProducts() {
        List<ProductMiniaturePage> allProductsPo = new ArrayList<>();
        for (WebElement product : products) {
            allProductsPo.add(new ProductMiniaturePage(getDriver(), product));
        }
        return allProductsPo;
    }

    public ProductMiniaturePage getProductWithName(String name) throws Exception {
        for (ProductMiniaturePage product : getProducts()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        throw new Exception("Product not found: " + name);
    }

    public ProductMiniaturePage getRandomProduct() {
        return new ProductMiniaturePage(getDriver(), getRandomElement(products));
    }
}
