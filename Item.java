//Inherited class for items that have no cost, but instead have a quantity
public class Item extends Skill{
    public int quantity;
    public boolean spRestore;
    public Item(String n, int t, boolean f, boolean a, int c, int bP, boolean u, int q, boolean sp){
        super(n, t, f, a, c, bP, u);
        quantity = q;
        spRestore = sp;
    }

    public String quantityCounter(){
        return(this.name + " | " + this.quantity);
    }

    public static void init(){
        System.out.println("Item.java compiled!\n");
    }
}