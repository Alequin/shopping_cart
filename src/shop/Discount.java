package shop;

import Products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Discount {

    protected static final BigDecimal loyaltyCardDiscount = BigDecimal.valueOf(0.02);
    protected static final double discountLimit = 20;
    protected static final BigDecimal overLimitDiscount = BigDecimal.valueOf(0.1);

    protected static BigDecimal getCostWithTwoForOneDiscount(Stock stock, ArrayList<Product> products){
        HashMap<Class, Boolean> seenList = new HashMap<>();

        BigDecimal cost = BigDecimal.ZERO;
        for (Product product : products) {

            Class current = product.getClass();
            seenList.putIfAbsent(current, false);

            if(!seenList.get(current)){
                cost = cost.add(product.getCostAsBigDecimal());
            }

            if(stock.isTwoForOne(current)){
                seenList.put(current, !seenList.get(current));
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
