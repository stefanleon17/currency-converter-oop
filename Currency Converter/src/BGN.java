//Bulgarian Leva

public class BGN extends USD{
    private final double ratioToUSD = 0.60;

    public BGN(double amount){
        super(amount);
    }

    public BGN() {
    }

    public double toUSD() {
        return amount * ratioToUSD;
    }

    @Override
    public String toString(){
        return "Лв " + String.format("%,.2f", amount);
    }
}
