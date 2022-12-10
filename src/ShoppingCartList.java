import java.util.HashMap;
import java.util.Map;

public class ShoppingCartList {
    private int size;
    private StoreLinkedList.ItemNode head;
    private StoreLinkedList.ItemNode tail;
    Map<StoreLinkedList.ItemNode, Integer> quantityMap = new HashMap<>();

    public ShoppingCartList(StoreLinkedList.ItemNode item, int quantity) {
        addItem(item, quantity);

    }


    private void addItem (StoreLinkedList.ItemNode item , int quantity){
        if(item.setQuantity(quantity, false)) {
            if (size == 0) {
                head = item;


            } else {
                tail.next = item;

            }
            tail = item;
            size++;
            quantityMap.put(item,quantity);

        }


    }

    public void  removeItem(String ID){

            StoreLinkedList.ItemNode temp = head;
            if(size == 0){
                return;
            }
            if (size == 1){
                int returned = quantityMap.getOrDefault(head,0);
                temp.setQuantity(returned,true);
                quantityMap.remove(head);
                head = null;
                tail = null;


            }
            while (temp.next != null){
                if(temp.next.getID().equals(ID)){
                    StoreLinkedList.ItemNode point = temp.next;
                    int returned = quantityMap.getOrDefault(point,0);
                    temp.setQuantity(returned,true);
                    temp.next = temp.next.next;
                    point = null;
                    break;


                }
                temp= temp.next;
            }
    }
    public double  checkOut(){
        double price = 0.0;

        while (head != null){
            price += head.getPrice()*quantityMap.getOrDefault(head, 0);
            quantityMap.remove(head);
            head = head.next;
        }
        return price;
    }


    }

