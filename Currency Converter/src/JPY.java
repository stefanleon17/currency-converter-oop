//Japanese Yen

public class JPY extends USD{
    private final double ratioToUSD = 0.0090;

    public JPY(double amount) {
        super(amount);
    }

    public double toUSD() {
        return amount * ratioToUSD;
    }

    public JPY() {
    }

    @Override
    public String toString() {
        return "¥ " + String.format("%,.2f", amount);
    }
}
