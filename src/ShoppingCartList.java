import java.util.HashMap;
import java.util.Map;

public class ShoppingCartList {
    private int size;
    private ItemNode head;
    private ItemNode tail;
    private Map<ItemNode, Integer> quantityMap = new HashMap<>();



    public ShoppingCartList(ItemNode item, int quantity) {
        addItem(item, quantity);

    }

    public int getSize() {
        return size;
    }

    public void addItem (ItemNode item , int quantity){
        if(item == null){
            System.out.println("Failed to add the item is not available");
        }else {

            if (item.setQuantity(quantity, false)) {
                if (size == 0) {
                    head = item;
                    tail = item;
                    size++;
                    quantityMap.put(item, quantity);


                } else {
                    tail.next = item;
                    tail = item;
                    size++;
                    quantityMap.put(item, quantity);

                }



            }else {
                System.out.println("The Amount is not Available");
            }
        }


    }

    public void  removeItem(String ID){

            ItemNode temp = head;
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
                    ItemNode point = temp.next;
                    int returned = quantityMap.getOrDefault(point,0);
                    temp.setQuantity(returned,true);
                    temp.next = temp.next.next;
                    point = null;
                    break;


                }
                temp= temp.next;
            }
    }

    @Override
    public String toString() {
        ItemNode temp = head;
        String s = "";
       while (temp!=null){
           s+= temp.toString();
           temp = temp.next;

       }
       return s;
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

