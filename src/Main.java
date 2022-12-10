import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        StoreLinkedList grocery = new StoreLinkedList();
        StoreLinkedList electronics = new StoreLinkedList();
        StoreLinkedList clothes = new StoreLinkedList();
        // adding items to grocery
        grocery.addItem("Apple" , "1112356", 12, 100);
        grocery.addItem("Orange" , "1115766", 20, 100);
        grocery.addItem("Fig" , "1112296", 17, 100);
        grocery.addItem("Water Melon" , "1112349", 15, 100);
        grocery.addItem("Pinapple" , "1112321", 3, 100);

        //adding items to electronics
        electronics.addItem("IPhone","22298753", 1000, 30);
        electronics.addItem("Tablet","22232123", 700, 70);
        electronics.addItem("MacBook","22298856", 2000, 20);
        electronics.addItem("TV","22298392", 500, 0);

        //adding items to clothes
        clothes.addItem("Shirt", "3434349", 20, 7);
        clothes.addItem("T-Shirt", "3434351", 20, 7);
        clothes.addItem("Shoes", "3431212", 20, 7);
        clothes.addItem("Hat", "34342344", 20, 7);

        // outputting stores;
        System.out.println(grocery);
        System.out.println("----------------------------------------------------------------");
        System.out.println(clothes);
        System.out.println("----------------------------------------------------------------");
        System.out.println(electronics);
        System.out.println("----------------------------------------------------------------");



        MainLinkedList mall = new MainLinkedList();
        mall.AddStore(grocery,"111");
        mall.AddStore(electronics,"222");
        mall.AddStore(clothes, "343");

        System.out.println(mall.findItem("Shirt", "3434349"));
        System.out.println(mall.findItem("TV","22293333"));
        System.out.println(mall.findItem("light", "380204"));
        System.out.println(mall.findItem("MacBook","22298856"));
        System.out.println("----------------------------------------------------------------");


        ShoppingCartList cart = new ShoppingCartList(mall.getItem("3434349") , 1);
        cart.addItem(mall.getItem("3333333"), 2 );
        cart.addItem(mall.getItem("22298856"), 1 );

        System.out.println( "the size of the cart before checking out:  " +cart.getSize());

        System.out.println( "the final price is:  "+cart.checkOut());

        System.out.println( "the size of the cart after checking out:  " +cart.getSize());

        System.out.println("----------------------------------------------------------------");








    }
}