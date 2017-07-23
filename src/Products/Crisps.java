package Products;

public class Crisps extends Product{

    protected Crisps(String name, double cost){
        super(name, cost);
    }

    public Crisps(double cost){
        this("Crisps", cost);
    }
}
