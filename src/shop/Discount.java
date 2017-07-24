package shop;

import Products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Discount {

    protected static final BigDecimal loyaltyCardDiscount = BigDecimal.valueOf(0.02);
    protected static final double discountLimit = 20;
    protected static final BigDecimal overLimitDiscount = BigDecimal.valueOf(0.1);

    protected static BigDecimal getCostWithTwoForOneDiscount(Stock stock, ArrayList<Product> products){
        ArrayList<Class> seenList = new ArrayList<>();

        BigDecimal cost = BigDecimal.ZERO;
        for (Product product : products) {

            Class current = product.getClass();
            boolean seen = false;
            if(stock.isTwoForOne(current)){
                seen = seenList.contains(current);
                if(!seen){
                    seenList.add(current);
                }else{
                    seenList.remove(current);
                }
            }

            if(!seen){
                cost = cost.add(product.getCostAsBigDecimal());
            }
        }
        return cost;
    }

    protected static BigDecimal getDiscountForOverLimit(BigDecimal amount){
        return amount.multiply(overLimitDiscount);
    }

    protected static BigDecimal getDiscountWithLoyaltyCard(BigDecimal amount){
        return amount.multiply(loyaltyCardDiscount);
    }
}
