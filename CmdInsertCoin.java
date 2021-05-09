public class CmdInsertCoin implements Command {
    @Override
    public String execute(VendingMachine v, String cmdPart) {
        Integer c = Integer.valueOf(cmdPart);
        // Add the coin to Coin Slot
        v.insertCoin(c);
        Integer sum = v.getSum();
        String template = "Inserted a $%d coin. $%d in total.";
        String result = String.format(template, c, sum);
        return result;
    }
}
