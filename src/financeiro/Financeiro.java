package financeiro;

public class Financeiro {
    private static boolean capital;

    private Financeiro() {
        setCapital(true);
    }    

    private static void setCapital(boolean value) {
        capital = value;
    }
    
    public static boolean concedeCapital() {
        return true;
    }    
}
