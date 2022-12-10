public class MainLinkedList {
    private int size ;
    private StoreNode head;
    private StoreNode tail;
    private boolean AddStore(StoreNode store){
        if(size == 0){
            head = store;
            tail= store;
            size++;
            return true;

        }else{
            tail.next = store;
            tail = store;
            size++;
            return true;
        }
    }
    public String findItem(String name, String ID){
        StoreNode store = findStore(ID);
        if(store == null){
            return "The element doesn't belong to any store";
        }else if (store.store.containsItem(ID)){
            return "The Item : " + name + " exists in "+ store.storeID;

        }else{
            return "The element is not in the store";
        }

    }
    private StoreNode findStore(String ID){
        StoreNode temp = head;
        String StoreID = ID.substring(0,3);
        while (temp != null){
            if(temp.storeID.equals(StoreID)){
                return temp;
            }
            temp = temp.next;

        }
        return null;
    }






    protected class StoreNode{
        private StoreLinkedList store;
        private String storeID;
        private StoreNode next;

        public StoreNode(StoreLinkedList store, String ID) {
            this.store = store;
            storeID = ID;

        }
    }
}
