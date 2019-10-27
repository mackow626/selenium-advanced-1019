package basket;

import base.BaseTest;
import models.Order;
import org.testng.annotations.Test;
import pages.commons.MainPage;
import pages.products.ProductDetailsPage;
import pages.products.ProductMiniaturePage;

import java.util.Random;

public class BasketTests extends BaseTest {

    @Test
    public void basketFlow(){
        Order expectedOrder = new Order(); // na początku pusty

        MainPage mainPage = new MainPage(getDriver());
        mainPage.getProductContainer().getRandomProduct().open();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
        productDetailsPage.setQuantity(new Random().nextInt(5)+1); //+1 aby uniknąć przekazania 0
        productDetailsPage.addProductToBasket(expectedOrder); // zapisanie produktu w obiekcie order i kliknięcie addToCartButton

        getDriver().get("http://5.196.7.235/cart?action=show"); // otwieramy koszyk

    }
}
