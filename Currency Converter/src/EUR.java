//Euro

public class EUR extends USD{
    private final double ratioToUSD = 1.18;

    public EUR(double amount) {
        super(amount);
    }

    public EUR() {
    }

    public double toUSD() {
        return amount * ratioToUSD;
    }

    @Override
    public String toString() {
        return "€ " + String.format("%,.2f", amount);
    }
}
