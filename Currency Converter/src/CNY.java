//Chinese Yuan

public class CNY extends USD{
    private final double ratioToUSD = 0.15;

    public CNY(double amount) {
        super(amount);
    }

    public CNY() {
    }

    public double toUSD() {
        return amount * ratioToUSD;
    }

    @Override
    public String toString() {
        return "¥ " + String.format("%,.2f", amount);
    }
}
