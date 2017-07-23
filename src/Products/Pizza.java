package Products;

public class Pizza extends Product{

    protected Pizza(String name, double cost){
        super(name, cost);
    }
    
    public Pizza(){
        this("Pizza", 6.50);
    }
}
