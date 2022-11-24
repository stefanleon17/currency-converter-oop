//Mexican Peso

public class MXN extends USD{
    private final double ratioToUSD = 0.049;

    public MXN(double amount) {
        super(amount);
    }

    public double toUSD() {
        return ratioToUSD * amount;
    }

    public MXN() {
    }

    @Override
    public String toString() {
        return "$ " + String.format("%,.2f", amount);
    }
}
