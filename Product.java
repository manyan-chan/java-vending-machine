public class Product {
    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /* You may add other properties and methods */
    public String GetName() {
        return name;
    }

    public int GetPrice() {
        return price;
    }

    public int GetQuantity() {
        return quantity;
    }

    public void ReduceQuantity() {
        this.quantity --;
    }
}