package entities;

import java.math.BigDecimal;

public class Product implements Cloneable{



    private String name;
    private String type;
    private BigDecimal price;
    private String manufacturer;

    public Product(String name, String type, BigDecimal price, String manufacturer) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.manufacturer = manufacturer;
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }


    @Override
    public Product clone(){
        return new Product(this.name, this.type,this.price,this.manufacturer);
    }

}
