//Great Britain Pound

public class GBP extends USD{
    private final double ratioToUSD = 1.38;

    public GBP(double amount) {
        super(amount);
    }

    public GBP() {
    }

    public double toUSD() {
        return amount * ratioToUSD;
    }

    @Override
    public String toString() {
        return "£ " + String.format("%,.2f", amount);
    }
}
