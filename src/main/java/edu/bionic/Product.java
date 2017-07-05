package edu.bionic;


import java.math.BigDecimal;

public class Product {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Color color;
    private Integer capasity;
    private String display;


    public Product(Integer id, String name, BigDecimal price, Color color, Integer capasity, String display) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.capasity = capasity;
        this.display = display;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getCapasity() {
        return capasity;
    }

    public void setCapasity(Integer capasity) {
        this.capasity = capasity;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String printInfo() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color=" + color +
                ", display='" + display + '\'' +
                ", capasity=" + capasity +
                '}';
    }
}
