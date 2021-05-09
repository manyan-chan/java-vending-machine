import java.util.ArrayList;
import java.util.Collections;

public class VendingMachine {
    // ArrayList of Integers represents inserted coins in Coin Slot private
    ArrayList<Integer> insertedCoins;

    // ArrayList of Product represents inventories of products
    private ArrayList<Product> products;

    public VendingMachine() {
        insertedCoins = new ArrayList<Integer>();
        products = new ArrayList<Product>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void insertCoin(Integer c) {
        insertedCoins.add(c);
        Collections.sort(insertedCoins);
    }

    public ArrayList<Integer> getInsertedCoins(){
        return this.insertedCoins;
    }

    public ArrayList<Product> getProducts(){
        return this.products;
    }

    public void emptyCoins(){
        this.insertedCoins.clear();
    }

    public Integer getSum(){
        Integer sum = 0;
        for (int counter = 0; counter < insertedCoins.size(); counter++) {
            sum += insertedCoins.get(counter);
        }
        return sum;
    }
}