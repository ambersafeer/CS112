package warehouse;

public class Restock {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);
        Warehouse nWarehouse = new Warehouse();
        int n = StdIn.readInt();
        String x = "add";
        String y = "restock";
        for (int i= 0; i < n; i++){
            String op = StdIn.readString();
            if (op.equals(x)){
                int currDay = StdIn.readInt();
                int prodID = StdIn.readInt();
                String prodName = StdIn.readString();
                int itemStock = StdIn.readInt();
                int itemDemand = StdIn.readInt();
                nWarehouse.addProduct(prodID, prodName, itemStock, currDay, itemDemand); 
            } else if (op.equals(y)) {
                int prodID = StdIn.readInt();
                int amount = StdIn.readInt();
                nWarehouse.restockProduct(prodID, amount);
            }
        }
        StdOut.println(nWarehouse);
        }
	// Uset his file to test restock
    }

