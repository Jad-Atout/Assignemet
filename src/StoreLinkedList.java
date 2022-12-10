



public  class StoreLinkedList {
    int size;
    ItemNode head;
    ItemNode tail;

    public StoreLinkedList() {
    }
    public boolean addItem(String name,String ID, int price, int quantity){
        int storeNumber =  Integer.valueOf(ID.substring(0, 3));
      /*  String pattern = "(\\d{3})*";

        Pattern pat = Pattern.compile(pattern);
        Matcher m = pat.matcher(ID);
        switch (m.group(1)){
            case "111":
                storeNumber = 1;
                break;
            case "222":
                storeNumber = 2;
                break;
            case "333":
                storeNumber = 3;
                break;
            case "444":
                storeNumber = 4;
                break;
            default:
                return false;
        }*/

       return AddItem(new ItemNode(name,ID,price,quantity,storeNumber));

    }

    private boolean AddItem(ItemNode item){
        if(size == 0){
            head = item;
            tail= item;
            size++;
            return true;

        }else{
            tail.next = item;
            tail = item;
            size++;
            return true;
        }
    }

    public boolean deleteItem(String ID){
        ItemNode temp = head;
        while (temp.next != null){
            if(temp.next.ID.equals(ID)){
                ItemNode point = temp.next;
                temp.next = temp.next.next;
                point = null;
                return true;

            }
            temp= temp.next;
        }
        return false;
    }

    public boolean containsItem(String ID){
        ItemNode temp = head;
        while (temp.next != null){
            if(temp.ID.equals(ID)){
                return true;
            }
            temp = temp.next;
        }
        return false;

    }


    @Override
    public String toString() {
        String s = "[";
        ItemNode temp = head;
        while (temp != null){
            s += temp.toString() + "|" + "\n";
            temp = temp.next;
        }
        s+="]";
        return s;
    }

   protected class ItemNode{
        private String name;
        private String ID;
        private double price;
        private int quantity;
        private int section;
       public ItemNode next;



      public ItemNode() {
      }

      public ItemNode(String name, String ID, double price, int quantity, int section) {
          this.name = name;
          this.ID = ID;
          this.price = price;
          this.quantity = quantity;
          this.section = section;

      }

       public boolean setQuantity(int Amount , boolean add) {
          if(add){
              this.quantity += Amount;
          }else {

              if (quantity - Amount >= 0) {
                  this.quantity = quantity - Amount;
                  return true;
              }
          }
          return false;
       }

       @Override
        public String toString() {
            return "{" +
                    "name='" + name + "\n" +
                    ", ID='" + ID + "\n" +
                    ", price=" + price + "\n"+
                    ", quantity=" + quantity + "\n"+
                    ", section=" + section + "\n"+
                    '}';
        }

       public String getName() {
           return head.name;
       }

       public String getID() {
           return head.ID;
       }

       public double getPrice() {
           return head.price;
       }

       public int getQuantity() {
           return head.quantity;
       }

       public int getSection() {
           return head.section;
       }
    }
}
