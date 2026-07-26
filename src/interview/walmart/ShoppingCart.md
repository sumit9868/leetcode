Design a Cart and Checkout system for a large e-commerce platform like Walmart.com.
The system should allow users to add/remove items, apply coupons, and checkout using multiple payment methods.

Requirements

add items to the cart , if item out of stock throw an error
remove items from the cart , remove an already removed item throw an error
checkout from the cart using multiple payment methods , select form available payment options
support multiple payment methods

out scope, handeling payment processing, inventory management of the platform

Entities

ShoppingCart
 - CartItem[] cartItems
 + addItem(item,quantity), throw error if item out of stock
 + removeItem(item,quantity) throw error if we try to remove more than available
 + getCartValue() -> calculates the final cart value after apply
CartItem {Item , quantity, cost}
Item
Offer
PaymentMethod
Inventory

CheckoutSystem

- shopingCart[] : shoppingCart
- Offers : List<Offer>
- Inventory : Map<String,Integer> invetoryItems;
+ applyOffer(Shopping, stirng offer) -> cart cost after applying the offer
+ addItem(item,quantity), throw error if item out of stock
+ removeItem(item,quantity) throw error if we try to remove more than available
+ checkout(Shoppincart) -> as user for any offer, -> final cart ammount -> selection of payment method
{
    Offer offer = getOfferFromUser() -> OfferObject
    Float discount = offer.applyOffer(shoppingCart);

    Float finalCartAmount = shoppinCart.getValue() - discount;

    PaymentMethod payment = getPaymentMethod() -> Payment method object {UPI, card, net banking}

    String transactionID;
    try{
     transactionID= payment.performTansaction(finalCartAmount);
    }catch(Exception e){
        //throw error for payment failure
    }
    if(trasactionID==null) //error
    return transactionID;
}

Offers
 - 50off
 - byone
 - flatt100



public interface Offer{
public applyOffer(ShoppingCart);
}


public class ByOneGetOne implments Offer{
}
public applyOffer
}
Falt100 -> return 100;
50Peeset -> return ShoppinCart.getValue()/2;

interface PaymentMethod

CardPayment
UPIPayment
NetBankingPayment
Hybrid

Hybrid implements PaymentMethod{


public performTransaction(Long cartAmmont){
 Map<PaymentMethod,Long > paymentMethods = getPaymentMethods();
 for(PaymentMethod method: payemtnMethods){
    try{
         transactionID= payment.performTansaction(paymentMethods.get(method));
        }catch(Exception e){
            //throw error for payment failure
        }
 }

 return generateTransactionID();
}
}