package model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private String color;
    private String category;
    private int category_id;

    public Product(int productId, String productName, double price, int quantity, String color) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public Product(String productName, double price, int quantity, String color, int category_id) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category_id = category_id;
    }

    public Product(String productName, double price, int quantity, String color, String category, int category_id) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
        this.category_id = category_id;
    }

    public Product(int productId, String productName, double price, int quantity, String color, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
