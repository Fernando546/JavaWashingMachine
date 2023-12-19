public class Tank {
    private int liquidAmount;
    private int capacity;

    public Tank(int capacity) {
        this.capacity = capacity;
        this.liquidAmount = 200;
    }

    public int getLiquidAmount() {
        return liquidAmount;
    }


    public void removeLiquid(int amount) {
        if (liquidAmount - amount >= 0) {
            liquidAmount -= amount;
        } else {
            System.out.println(ANSI_RED + "Tank does not have enough liquid to remove." + ANSI_RESET);
        }
    }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}