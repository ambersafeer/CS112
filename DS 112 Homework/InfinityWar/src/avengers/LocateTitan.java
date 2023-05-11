package avengers;
/**
 * 
 * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0), 
 * modify the edge weights using the functionality values of the vertices that each edge 
 * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * LocateTitanInputFile name is passed through the command line as args[0]
 * Read from LocateTitanInputFile with the format:
 *    1. g (int): number of generators (vertices in the graph)
 *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
 *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from 
 *       one generator to another 
 * Create an adjacency matrix for g generators.
 * 
 * Populate the adjacency matrix with edge values (the energy cost to travel from one 
 * generator to another).
 * 
 * Step 2:
 * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it 
 * by the functionality of BOTH vertices (generators) that the edge points to. Then, 
 * typecast this number to an integer (this is done to avoid precision errors). The result 
 * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
 * 
 * Step 3:
 * LocateTitanOutputFile name is passed through the command line as args[1]
 * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan. 
 * Output this number into your output file!
 * 
 * Note: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, minCost represents the minimum cost to 
 *   travel from Earth to Titan):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(minCost);
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
 * 
 * @author Yashas Ravi
 * 
 */



public class LocateTitan {
	
    public static void main (String [] args) {
    	
        if ( args.length < 2 ) {
            StdOut.println("Execute: java LocateTitan <INput file> <OUTput file>");
            return;
        }

        String locateTitanInputFile = args[0];
        String locateTitanOutputFile = args[1];

        StdIn.setFile(locateTitanInputFile);
        StdOut.setFile(locateTitanOutputFile);

    	// WRITE YOUR CODE HERE
        int genNum = StdIn.readInt();
        int[][] adjmatrix = new int[genNum][genNum];
        Generator[] genArray = new Generator[genNum];


        // creates generator objects and puts them into an array of generators
        // to pull from later.
        for (int i = 0; i < genNum; i++){ 
            int id = StdIn.readInt();
            double funct = StdIn.readDouble();
            Generator newGenerator = new Generator(id, funct);
            genArray[i] = newGenerator;
        }

        // creates a 2D array based on the adjacancy matrix given.
        for (int i = 0; i < genNum; i++){
            for (int j = 0; j < genNum; j++){
                adjmatrix[i][j] = StdIn.readInt();
            }
        }

        // traverse through adjacany array in order to find the energy costs.
        for (int i = 0; i < genNum; i++){
            for (int j = 0; j < genNum; j++){
                int weight = adjmatrix[i][j];
                double totalCost = weight / (genArray[i].getFunct() * genArray[j].getFunct());
                adjmatrix[i][j] = (int) totalCost;
            }
        }

        // DIJKSTRAS ALGORITHM

        //create an array that keeps track of the MINIMUM cost to reach
        // every vertex from vertex 0

        int[] minCost = new int[genNum];

        //create an array that keeps track of which nodes are in the
        // path already.

        boolean[] DijkstraSet = new boolean[genNum];

        // set each minCost value to infinity
        // except vertex 0 since we are starting at node 0

        for (int i = 0; i < minCost.length; i++){
            if (i == 0){
                minCost[i] = 0;
            } else{
                minCost[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < genNum - 1; i++){
        // determine the vertex w the Minimum cost from vertex 0.
        // store in currentSource   
            int currentSource = getMinCostNode(genNum, minCost, DijkstraSet);
        // Add currentSource to DijkstraSet
            DijkstraSet[currentSource] = true;
        
        // update the distance from 0 to each currentSource's neighbors IF it CAN BE lowered.
            for (int w = 0; w < genNum; w++){
                if (adjmatrix[currentSource][w] != 0){
                   if (DijkstraSet[w] == false && minCost[currentSource] != Integer.MAX_VALUE && minCost[w] > (minCost[currentSource] + adjmatrix[currentSource][w])){
                    minCost[w] = minCost[currentSource] + adjmatrix[currentSource][w]; 
                    }
                }
            }
        }

        StdOut.print(minCost[genNum-1]);

        
    }

        public static int getMinCostNode(int genNum, int[] minCost, boolean[] DijkstraSet){
            int minCostNode = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < genNum; i++){
                if (minCost[i] < minCostNode && DijkstraSet[i] == false){
                    minCostNode = minCost[i];
                    index = i;   
                } 
            }
            return index;
    }
}
