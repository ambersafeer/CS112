package warehouse;

/*
 * Use this class to test the deleteProduct method.
 */ 
public class DeleteProduct {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);
        Warehouse nWarehouse = new Warehouse();
        int n = Integer.parseInt(StdIn.readLine());
        String x = "add";
        String y = "delete";
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
                nWarehouse.deleteProduct(prodID);
            }   
        }
        StdOut.println(nWarehouse);
	// Use this file to test deleteProduct
    }
}
