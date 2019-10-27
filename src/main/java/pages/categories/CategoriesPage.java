package pages.categories;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.commons.TopMenuPage;
import pages.products.ListOfProductsPage;

public class CategoriesPage extends BasePage {

    public CategoriesPage(WebDriver driver) {
        super(driver);
        popularProducts = new ListOfProductsPage(driver);
        menu = new TopMenuPage(driver);
    }

    private ListOfProductsPage popularProducts;
    private TopMenuPage menu;

    public ListOfProductsPage getPopularProducts() {
        return popularProducts;
    }

    public TopMenuPage getMenu() {
        return menu;
    }
}
