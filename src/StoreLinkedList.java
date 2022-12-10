



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
            if(temp.next.getID().equals(ID)){
                ItemNode point = temp.next;
                temp.next = temp.next.next;
                point = null;
                return true;

            }
            temp= temp.next;
        }
        return false;
    }

    public ItemNode containsItem(String ID){
        ItemNode temp = head;
        while (temp != null){
            if(temp.getID().equals(ID)){
                return temp;
            }
            temp = temp.next;
        }
        return null;

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


}

