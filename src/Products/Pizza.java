package Products;

public class Pizza extends Product{

    protected Pizza(String name, double cost){
        super(name, cost);
    }
    
    public Pizza(double cost){
        this("Pizza", cost);
    }
}
