package Products;

public class ToothPaste extends Product{

    protected ToothPaste(String name, double cost){
        super(name, cost);
    }

    public ToothPaste(double cost){
        this("ToothPaste", cost);
    }

}
