import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        StoreLinkedList store = new StoreLinkedList();
        store.addItem("Apple" , "1112356", 12, 100);
        store.addItem("Orange" , "1115766", 20, 100);
        store.addItem("Fig" , "1112296", 17, 100);
        store.addItem("Water Melon" , "1112349", 15, 100);
        store.addItem("Pinapple" , "1112321", 3, 100);
        System.out.println(store.toString());
        System.out.println(store.deleteItem("1112349"));
        System.out.println("---------------------------------------------");
        System.out.println(store.toString());
        ShoppingCartList shoppingCartList = new ShoppingCartList(store.head, 20);



        shoppingCartList.removeItem("1112356");
        System.out.println(shoppingCartList.checkOut());
        System.out.println(store.head.getQuantity());




    }
}