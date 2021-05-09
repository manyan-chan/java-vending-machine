import java.util.ArrayList;

public class CmdRejectCoins implements Command {
    @Override
    public String execute(VendingMachine v, String cmdPart) {
        Integer sum = v.getSum();
        ArrayList<Integer> coins = v.getInsertedCoins();
        String str = "Rejected ";
        if (sum == 0) {
            str = "Rejected no coin!";
        } else {
            for (int i = 0; i < coins.size(); i++) {
                if (i == coins.size() - 1) {
                    str += "$" + String.valueOf(coins.get(i)) + ". $";
                } else {
                    str += "$" + String.valueOf(coins.get(i)) + ", ";
                }
            }
            str += String.valueOf(sum) + " in total.";
        }
        v.emptyCoins();
        return str;
    }
}
