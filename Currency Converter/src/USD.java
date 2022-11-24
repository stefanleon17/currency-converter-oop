//The program converts currencies by referencing the value of one unit to that of one USD.
//In order to make the repeated conversion into USD easier,
//every currency class inherits the conversion methods from the USD class.

public class USD {
    protected double amount;
    private double amountUSD;

    //Values below can be updated as exchange rates change

    private final double ratioToBGN = 1.667;
    private final double ratioToCNY = 6.667;
    private final double ratioToJPY = 110.11;
    private final double ratioToEUR = 0.847;
    private final double ratioToMXN = 20.408;
    private final double ratioToGBP = 0.725;
    private final double ratioToRUB = 76.92;

    public USD(){
    }

    public USD(double amount) {
        this.amount = amount;
        this.amountUSD = amount;
    }

    public void setAmountUSD(double amountUSD){
        this.amountUSD = amountUSD;
    }

    //Conversion methods

    public double toUSD(){
        return amount;
    }

    public double toRUB(){
        return amountUSD * ratioToRUB;
    }

    public double toGBP(){
        return amountUSD * ratioToGBP;
    }

    public double toBGN(){
        return amountUSD * ratioToBGN;
    }

    public double toEUR(){
        return amountUSD * ratioToEUR;
    }

    public double toCNY(){
        return amountUSD * ratioToCNY;
    }

    public double toJPY(){
        return amountUSD * ratioToJPY;
    }

    public double toMXN(){
        return amountUSD * ratioToMXN;
    }

    //the toString method is overridden in every class
    @Override
    public String toString() {
        return "$ " + String.format("%,.2f", amountUSD);
    }
}
