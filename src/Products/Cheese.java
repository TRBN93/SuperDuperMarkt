package Products;

import java.time.LocalDate;

public class Cheese extends Product {

    public Cheese(String name, double basicPrice, LocalDate expiryDate) {
        super(name, basicPrice, expiryDate);
    }

    @Override
    public double getPrice(){
        checkQuality();
        return basicPrice+ 0.1*getQuality();
    }

    @Override
    public int getQuality(){
        checkQuality();
        if(quality < 30){
            this.spoiled = true;
        }
        return quality;
    }
}
