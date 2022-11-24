//Russian Ruble

public class RUB extends USD{
    private final double ratioToUSD = 0.013;

    public RUB(double amount){
        super(amount);
    }

    public RUB() {
    }

    public double toUSD() {
        return amount * ratioToUSD;
    }

    @Override
    public String toString() {
        return "₽ " + String.format("%,.2f", amount);
    }
}
