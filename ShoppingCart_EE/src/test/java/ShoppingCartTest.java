import entities.Customer;
import entities.Product;
import entities.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ShoppingCartTest {

    ShoppingCart shoppingCart;
    @Before
    public void initialize(){
        Customer customer = new Customer("123");
        shoppingCart = new ShoppingCart(customer);
    }

    @Test
    public void testAddProduct(){
        Product doveSoap = new Product("Dove Soap", "soap", BigDecimal.valueOf(39), "Dove");
        shoppingCart.addProducts(doveSoap,5);
        assert (shoppingCart.getProducts().size()==5);
        assert (shoppingCart.getCartValue()==195);

        shoppingCart.addProducts(doveSoap,3);
        assert (shoppingCart.getProducts().size()==8);
        assert (shoppingCart.getCartValue()==312);
    }

    @Test
    public void testValueRoundOff(){

        Product doveSoap = new Product("Dove Soap", "soap",BigDecimal.valueOf(39.999), "Dove");
        shoppingCart.addProducts(doveSoap,8);
        assert (shoppingCart.getProducts().size()==8);
        assert (shoppingCart.getCartValue()==319.99);
    }

    @Test
    public void testZeroProductAddition(){
        Product doveSoap = new Product("Dove Soap", "soap",BigDecimal.valueOf(39.999), "Dove");
        shoppingCart.addProducts(doveSoap,0);
        assert (shoppingCart.getProducts().size()==0);
        assert (shoppingCart.getCartValue()==0);
    }
    @Test
    public void testDifferentProductAdditionWithTax(){
        Product doveSoap = new Product("Dove Soap", "soap",BigDecimal.valueOf(39.99), "Dove");
        shoppingCart.addProducts(doveSoap,2);
        Product axedeo = new Product("Axe Deo", "Deodorent",BigDecimal.valueOf(99.99), "Axe");
        shoppingCart.addProducts(axedeo,2);
        assert (shoppingCart.getProducts().size()==4);
        assert (shoppingCart.getTotalSalesTax()==35.00);
        assert (shoppingCart.getActualCartValue()==314.96);
    }

}
