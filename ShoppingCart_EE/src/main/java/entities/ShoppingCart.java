package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static final double SALES_TAX = 0.125;

    public ShoppingCart (Customer customer){
        this.customer = customer;
    }
    private Customer customer;
    private List<Product> products = new ArrayList<>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product, int quantity) {
        for(int i = 0;i<quantity;i++) {
            this.products.add(product.clone());
           // this.products.add(new Product(product.getName(),product.getType(), product.getPrice(), product.getManufacturer()));
        }
    }

    public void removeProducts(Product product) {
        this.products.remove(product);
    }

    public double getCartValue(){
        BigDecimal roundedvalue = products.stream().map(p->p.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);

       return roundedvalue.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getTotalSalesTax(){
        return BigDecimal.valueOf(getCartValue()*SALES_TAX).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getActualCartValue(){
        return getCartValue()+getTotalSalesTax();
    }

}
