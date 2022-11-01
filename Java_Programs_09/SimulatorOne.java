 /**
     * <h1> SimulatorOne </h1>
     * Uses Dijkstra's algorithm to determine the shortest path that a 
     */
import java.util.*;
import 

public class SimulatorOne {
    
    public static void main(String args[]) {
        
         Scanner keyboard  = new Scanner(System.in);
         
         String numNodesStr, sourceNodeStr, numShopsStr, shopNodeStr, numClientsStr,  clientNodeStr;//input data lines
         int numNodesInt, sourceNodeInt,  numShopsInt, shopNodeInt, numClientsInt, clientNodeInt, result;
         String callStr, destNodeStr, weightStr, path, shopNodesStr, clientNodesStr, taxi;
         
         ArrayList<String> edges = new ArrayList<String>();
         ArrayList<String> shortestToClient = new ArrayList<String> ();
         ArrayList<String> shortestToShop = new ArrayList<String> ();
         ArrayList<String> pathToClient = new ArrayList<String> ();
         ArrayList<String> pathToShop = new ArrayList<String> ();
         
         String[] numNodesArr, sourceNodeArr, numShopsArr, shopNodeArr, numClientsArr, clientNodesArr;
         
         double weight = 0;
         
         Graph graph = new Graph();
         
//         Graph graph = new Graph();
//         String numOfNodeStr, nodeNumStr, nodeEdgeStr, destNode, costStr;
//         String driverLabels, ordersStr, numOfOrdersStr, numOfDriversStr;
//         StringTokenizer nodeEdgeToken, driverLabelsToken, ordersToken;
//         String[] outGoingEdgeArray = {};
//         double costDouble;
//         int numOfNodesInt, nodeNumInt, outGoingEdges, numOfDrivers, numOfOrders;
        
//         outGoingEdges = 0;
        numNodeStr = keyboard.nextLine();
        numNodeStr.trim();
        if (numNodesStr != "")
            numNodesInt = Integer.parseInt(numOfNodeStr);
        else
            numNodesInt = 0;
        
        /*
          * Here, we loop through the line that gives the source node, destination node and the weight (or an edge). We store 
          * each edge in an ArrayList called edges. The list is of the form 
          *  {<sNode0>, <dNode0>, <w0>, <sNode0>, <dNode1>, <w1>, ..., <sNode0>, <dNoden>, <wn>, ..., <sNodei>, 
          * <dNodej>, <wj>}
          */
        for (int i = 0; i < numNodesInt; i++) 
        {
                path = keyboard.nextLine();
                if (path != " ") {
                        sourceNodeArr = paths.split(" ");
                        sourceNodeStr = sourceNodeArr[0];
                        arrLen = sourceNodeArr.length;
                        if (arrLen > 1) {
                                for (int j = 1; j < arrLen; j++) {
                                        if (j%2  == 1) {//entries in the odd indices are destNodes
                                                destNodeStr = sourceNodeArr[j];
                                                edges.add(sourceNodeStr);// add source node to list {<sourceNodei>}
                                                edges.add(destNodeStr);//add dest node to list
                                        }
                                        if (j%2 == 0 ) {//entries in the even indices are weights
                                                weightStr = sourceNodeArr[j];
                                                edges.add(weightStr);//add weight to list
                                        }
                                }
                        }
                        else {
                                edges.add(sourceNodeStr);
                                edges.add("none");
                                edges.add("none");
                        }
                }
        }
        
        /*
          * Add nodes to the graph from edges list
          */
        int listSize = edge.size();
        if (listSize > 3) {
                    for (int m = 0; m < listSize; m++) {//go through the list
                            if (m%3 == 0) {
                                        sourceNodeStr = edge.get(m);
                            }
                            else if(m%3 == 1) {
                                        destNodeStr = edge.get(m);
                            }
                            else if (m%3 == 2) {
                                        weightStr = edge.get(m).trim();
                                        weight = Double.parseDouble(weightStr);
                                        graph.addEdge(sourceNodeStr, destNodeStr, weight);
                            }
                    }
        }
         else {
                            sourceNodeStr = edge.get(0);
                            destNodeStr = "";
                            weight = graph.INFINITY;
                            graph.addEdge(sourceNodeStr, destNodeStr, weight);
        }
        
        /*
          * Stores  shop data
          */
       numShopsStr = keyboard.nextLine();
       if (numShopsStr != "")
            numShopsInt = Integer.parseInt(numShopsStr.trim());
        else
            numShopsInt = 0;
        shopNodesStr = keyboard.nextLine();
        if (shopNodesStr != "")
            shopNodeArr = shopNodesStr.split(" ");
        
       /*
         * Stores client data
         */
        numClientsStr = keyboard.nextLine();
        if (numClientsStr != "")
                numClientsInt = Integer.parseInt(numClientsStr.trim());
        else
               numClientsInt = 0;
        clientNodesStr = keyboard.nextLine();
        if (clientNodesStr != "") {
               clientNodesArr = clientNodesStr.split(" ");
               arrLen = clientNodesArr.length;
        }
        
        
        /*
          * Perform Dijkstra algorithm to find shortest path from client located at clientNode[i] to destNode
          */
          for (int n = 0; n < arrLen; n++) {
                    clientNodeStr = clientNodeArr[n];
                    System.out.println("client " + clientNodeStr );
                    for(int p = 0; p < shopNodesArr.length; p++) 
                    {
                            shopNodeStr = shopNodesArr[p];
                            graph.dijkstra(shopNodeStr);
                            graph.printPath(clientNodeStr);
                            path = graph.shortestPath;
                            weight = graph.finalCost;
                            if (shortestToClient.get(2) != null) 
                                    {
                                            if (shortestToClient.get(2) == weight) {
                                                        shortestToClient.add(shopNodeStr);
                                                        shortestToClient.add(path);
                                                        shortestToClient.add(weight.toString());
                                            }
                                            else if (shortestToClient.get(2) < weight )
                                            {
                                                    shortestToClient.removeAll();
                                                    shortestToClient.add(shopNodeStr);
                                                    shortestToClient.add(path);
                                                    shortestToClient.add(weight.toString());
                                            }
                            }
                            else {
                                                shortestToClient.add(shopNodeStr);
                                                shortestToClient.add(path);
                                                shortestToClient.add(weight.toString());
                            }
                            if (p == (shopNodesArr.length -1)) {
                                    if (!shortestToClient.isEmpty()) {
                                            if (shortestToClient.size() > 3) {
                                                    for(int q = 0; q < shortestToClient.size(); q++) {
                                                            if (q%3 == 0) {
                                                                    System.out.println("taxi " + shortestToClient.get(q));//print "taxi startNode" 
                                                            }
                                                            else if (q%3 == 1) {
                                                                     System.out.println(shortestToClient.get(q));//print "path"
                                                            }
                                                    }
                                            }
                                            else {
                                                    System.out.println("taxi" + shortestToClient.get(0));
                                                    System.out.println(shortestToClient.get(1));
                                            }
                                    }
                            }
                    }
          }
    }
}
          
//         int k = 0;
//         int currentCost = 0, previousCost = 0, result = 0;
//         int destIndex = 0, sourceIndex = 0, weightIndex = 0;,
//         while (k < arrLen) {
//                 clientNode = clientNodesArr[k];
//                 if (edges.contains(clientNode))
//                 {
//                         for (int l = 0; l < edges.size(); l++) {
//                                     if (l%3 == 1 ) {
//                                                 destIndex = l;
//                                                 destNode = edges.get(destIndex);
//                                                if (clientNode.equals(destNode)) {
//                                                         sourceIndex = destIndex - 1;
//                                                         sourceNodeStr = edges.get(sourceIndex) ;
//                                                         weightIndex = destIndex + 1;
//                                                         weightStr = edges.get(weightIndex);
//                                                         shortestToClient.add(sourceNodeStr);
//                                                         shortestToClient.add(destNodeStr);
//                                                         shortestToClient.add(weightStr);
//                                                }
//                                     }
//                         }
//                 }
//                 k++;
//         }
//         for (int i = 0; i < numNodesInt; i++)
//         {
//             nodeEdgeStr = keyboard.nextLine();
//             nodeEdgeToken = new StringTokenizer(nodeEdgeStr);
//             nodeNumStr = nodeEdgeToken.nextToken();
//             if (nodeEdgeToken.hasMoreTokens()) {
//                  outGoingEdges = nodeEdgeToken.countTokens();
//                 outGoingEdgeArray = new String[outGoingEdges];
//                 for (int j = 0; j < outGoingEdges; j++) {
//                      outGoingEdgeArray[j] = nodeEdgeToken.nextToken();   
//                 }
//             }
//             
//             for (int k = 0; k < outGoingEdges/2; k++) {
//                 for (int m = 0; m < outGoingEdges; m++) {
//                     if (m%2 == 0) {
//                         destNode = outGoingEdgeArray[m];
//                         costStr = outGoingEdgeArray[m+1];
//                         costDouble = Double.parseDouble(costStr);
//                         graph.addEdge(nodeNumStr, destNode, costDouble);
//                     } 
//                 }
//             }           
//         }
  /*      
        numOfDriversStr = keyboard.nextLine();
        numOfDrivers = Integer.parseInt(numOfDriversStr);
        String[] driverArray = new String[numOfDrivers];
        driverLabels = keyboard.nextLine();
        driverLabelsToken = new StringTokenizer(driverLabels);
        
        for (int l = 0; l < numOfDrivers; l++) {
            driverArray[l] = driverLabelsToken.nextToken();
        } 
        
        numOfOrdersStr = keyboard.nextLine(); 
        numOfOrders = Integer.parseInt(numOfOrdersStr);
        String[] ordersArray = new String[numOfOrders*2];
        String[] pickUpArray = new String[numOfOrders];
        String[] dropOffArray = new String[numOfOrders];
        ordersStr = keyboard.nextLine();
        ordersToken = new StringTokenizer(ordersStr);
        
        int n = 2*numOfOrders;
        
        for (int p = 0; p < n; p++) {
            ordersArray[p] = ordersToken.nextToken();
        }
        
        int pickDropIndex;
        for (int s = 0; s < n; s++) {
            if (s%2 == 0) {
                pickDropIndex = s/2;
                pickUpArray[pickDropIndex] = ordersArray[s]; 
            }
            else {
                pickDropIndex = (s-1)/2; 
                dropOffArray[pickDropIndex] = ordersArray[s];
            }
        }
        
        
        
        double minPickUp1, minPickUp2, minPickUp, minDropOff, minPathHome;
        minPickUp1 = 0;
        minPickUp2 = 0;
        minPickUp = 0;
        minDropOff = 0;
        minPathHome = 0;
        
        String client, truck, pickup, mult, dropoff, cannot, driver;
        client = "client ";
        truck = "truck ";
        pickup = "pickup ";
        mult = "multiple solutions cost ";
        dropoff = "dropoff ";
        driver = "0";
        int solns = 0;
        
        for (int q = 0; q < numOfOrders; q++) {
            System.out.println(client + pickUpArray[q] + " " + dropOffArray[q]);
            minPickUp = 0;
            for (int r = 0; r < numOfDrivers; r++) {
                graph.dijkstra(driverArray[r]);
                minPickUp1 = graph.cost(pickUpArray[q]);
                if (minPickUp1 >= 0) {
                    if (minPickUp1 < minPickUp) {
                        minPickUp = minPickUp1;
                        driver = driverArray[r];
                        solns++;
                    }
                    else if (minPickUp1 == minPickUp) {
                        driver = driverArray[r];
                        solns++;    
                    }
                    else
                        minPickUp = minPickUp;
                }
                else 
                    System.out.println("cannot be helped");
            }
            System.out.println(truck + driver);
            graph.dijkstra(driver);           
            
            if (solns == 0) {
                graph.printPath(pickUpArray[q]);
            }
            else {
                System.out.println("multiple solutions cost " + minPickUp);
            }
            
            System.out.println(pickup + pickUpArray[q]);  
            graph.dijkstra(pickUpArray[q]);
            graph.printPath(dropOffArray[q]);
            System.out.println(dropoff + dropOffArray[q]);
            graph.dijkstra(dropOffArray[q]);
            graph.printPath(driver);   
        }        
    }    */
