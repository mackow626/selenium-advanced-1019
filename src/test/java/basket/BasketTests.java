package basket;

import base.BaseTest;
import models.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.basket.BasketPage;
import pages.commons.MainPage;
import pages.products.ProductDetailsPage;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTests extends BaseTest {

    @Test
    public void basketFlow() {
        Order expectedOrder = new Order(); // na początku pusty order

        for (int i = 0; i < 10; i++) {
            getDriver().get("http://5.196.7.235/");
            MainPage mainPage = new MainPage(getDriver());
            mainPage.getProductContainer().getRandomProduct().open();

            ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
            productDetailsPage.setQuantity(new Random().nextInt(5) + 1); //+1 aby uniknąć przekazania 0
            productDetailsPage.addProductToBasket(expectedOrder); // zapisanie produktu w obiekcie order i kliknięcie addToCartButton
        }


        getDriver().get("http://5.196.7.235/cart?action=show"); // otwieramy koszyk
        BasketPage basketPage = new BasketPage(getDriver());

        int expectedCartQuantity = expectedOrder.getTotalQuantity();
        int actualCartQuantity = basketPage.getMenu().getCartQuantity();
        Assert.assertEquals(actualCartQuantity, expectedCartQuantity);

        Order actualOrder = basketPage.toOrder();
        assertThat(expectedOrder).isEqualToComparingFieldByFieldRecursively(actualOrder);
    }
}
