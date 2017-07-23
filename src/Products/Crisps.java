package Products;

public class Crisps extends Product{

    protected Crisps(String name, double cost){
        super(name, cost);
    }

    public Crisps(){
        this("Crisps", 1.20);
    }
}
