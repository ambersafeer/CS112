package warehouse;

/*
 * Use this class to test to addProduct method.
 */
public class AddProduct {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);
        Warehouse nWarehouse = new Warehouse();
        int n = Integer.parseInt(StdIn.readLine());
        for (int i= 0; i < n; i++){
            int currDay = StdIn.readInt();
            int prodID = StdIn.readInt();
            String prodName = StdIn.readString();
            int itemStock = StdIn.readInt();
            int itemDemand = StdIn.readInt();
            nWarehouse.addProduct(prodID, prodName, itemStock, currDay, itemDemand);
        }
        StdOut.println(nWarehouse);
        }
	// Use this file to test addProduct
    }

