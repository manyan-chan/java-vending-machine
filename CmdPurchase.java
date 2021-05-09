import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;

public class CmdPurchase implements Command {
    @Override
    public String execute(VendingMachine v, String cmdPart) {
        ArrayList<Product> products = v.getProducts();
        Integer sum = v.getSum();
        String result = null;
        for (int i = 0; i < products.size(); i++) {
            // System.out.println(products.get(i).GetName());
            // System.out.println(cmdPart);
            if (products.get(i).GetName().equalsIgnoreCase(cmdPart)) {
                // System.out.println(products.get(i).GetName());
                Boolean isEmpty = products.get(i).GetQuantity() == 0 ? true : false;
                if (isEmpty) {
                    String template = "%s is out of stock!";
                    return result = String.format(template, products.get(i).GetName());
                } else {
                    Integer sum2 = sum - products.get(i).GetPrice();
                    if (sum2 < 0) {
                        String template = "Not enough credit to buy %s! Inserted $%d but needs $%s.";
                        return result = String.format(template, products.get(i).GetName(), sum,
                                products.get(i).GetPrice());
                    } else if (sum2 == 0) {
                        products.get(i).ReduceQuantity();
                        v.emptyCoins();
                        String template = "Dropped %s. Paid $%d. No change.";
                        return result = String.format(template, products.get(i).GetName(), sum);
                    } else {
                        products.get(i).ReduceQuantity();
                        v.emptyCoins();
                        String template = "Dropped %s. Paid $%d. Your change: $%s.";
                        return result = String.format(template, products.get(i).GetName(), sum, change(sum2));
                    }
                }
            }
        }
        return result;
    }

    public String change(int sum) {
        ArrayList<Integer> changeList = new ArrayList<Integer>();
        while (sum > 0) {
            if (sum >= 10) {
                changeList.add(10);
                sum -= 10;
            } else if (sum >= 5) {
                changeList.add(5);
                sum -= 5;
            } else if (sum >= 2) {
                changeList.add(2);
                sum -= 2;
            } else {
                changeList.add(1);
                sum -= 1;
            }
        }
        Collections.sort(changeList);
        String str = changeList.stream().map(String::valueOf).collect(Collectors.joining(", $"));

        return str;
    }
}
