public class ItemNode {
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
        return name;
    }

    public String getID() {
        return ID;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSection() {
        return section;
    }
}
