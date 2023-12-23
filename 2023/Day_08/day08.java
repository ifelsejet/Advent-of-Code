import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
public class day08 {

    public static void main(String[] args){
        BufferedReader reader;
        String movingOrder = "";
        boolean firstLine = true;
        boolean firstNode = true;
        long numSteps = 0;
        boolean zFound = false;
        boolean allAreZ = false;
         //BinaryTree tree = new BinaryTree(); //populate tree line by line
       //  Node root = new Node("-1");
       HashMap<String, List<String>> jankGraph = new HashMap<>();

         

        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_08\\input.txt"));
                String line = reader.readLine();

                while(line != null){

                    if(!firstLine && !line.isEmpty()){
                        //parent = (Left Child, Right Child)
                        String[] split = line.split(" = ");
                        String parent = split[0];
                      //  System.out.println("parent node is " + parent);
                        
                        String[] children = split[1].split(",");
                        String left = children[0].replace("(", "").trim();
                         String right = children[1].replace(")", "").trim();

                         //System.out.println("Left kid is " + left);
                        //  System.out.println("right kid is " + right);
                          List<String> leafNodes = new ArrayList<>();
                          leafNodes.add(left);
                          leafNodes.add(right);

                          jankGraph.put(parent, leafNodes); //build graph

                         /* 
                        for ( String s : children){
                            System.out.println("children for parent root :" + parent + " is " + s);
                        }
                        */
                        
                    }

                    if(firstLine){
                        firstLine = false;
                        movingOrder = line;
                        System.out.println("order is :" + movingOrder);
                    }
    
                
                        line = reader.readLine();
                   }
                     reader.close();
                }
              
             catch (IOException e) {
                e.printStackTrace();
            }
           // System.out.println("Part 1 sol: " + totalPoints);
           //print graph
         //  jankGraph.forEach((key, value) -> System.out.println(key + " => " + value));

           ArrayList<String> sortedKeys
           = new ArrayList<String>(jankGraph.keySet()); //make sure to get AAA first

      // Collections.sort(sortedKeys); kinda slow

       //check for all nodes ending with A
        List<String> startingNodes  = new ArrayList<>();
       for(String key : jankGraph.keySet()){
            if(key.charAt(key.length() - 1) == 'A'){
                startingNodes.add(key);
                System.out.println("added : " + key);
            }
       }
       int nodeSizes = startingNodes.size();
       List<Long> stepsList = new ArrayList<>();

       for(int i = 0 ; i < startingNodes.size(); i++){
            stepsList.add(i, getSteps(startingNodes.get(i), jankGraph, movingOrder));
       }

       // find all the starting nodes steps, then take the LCM of the steps
       System.out.println("Part 2 sol: " + findLCM(stepsList));
       stepsList.forEach(step -> System.out.println(step));


       /* 
       while(!allAreZ){ // REALLY SLOW
        for(Character currOrder : movingOrder.toCharArray()){
            
             if(currOrder == 'L'){
                for(int i = 0; i < startingNodes.size(); i++){
                    String current = jankGraph.get(startingNodes.get(i)).get(0); //get left; 
                    System.out.println("Got left: " + current + " for " + startingNodes.get(i));
                    startingNodes.set(i, current);
                  //  System.out.println("Now node to search is " + startingNodes.get(i));
                }
            }
            else if(currOrder == 'R'){
                 for(int i = 0; i < startingNodes.size(); i++){
                String current = jankGraph.get(startingNodes.get(i)).get(1); //get right ; 
                System.out.println("Got right: " + current + " for " + startingNodes.get(i));

                    startingNodes.set(i, current);
              //  System.out.println("Now node to search is! " + startingNodes.get(i));

                 }
            }

            //check if all end with Z
            int currAreZ = 0;
            for(String node : startingNodes){
            if(node.charAt(node.length() - 1) == 'Z'){
                System.out.println(node + " ends in Z!");
               currAreZ++;
            }
            }
            if(currAreZ == nodeSizes){
                allAreZ = true;
            }

            numSteps++;

        }
       }
       */

       
      

       //keep searching until all starting nodes end with Z

            
       
            /* 
            String current = "";
            String currentParent = "AAA";
           while(!zFound){
            //check currentOrder
           // Character currOrder = movingOrder.charAt(0);
            //move characters around
           for(Character currOrder : movingOrder.toCharArray()){
            if(currOrder == 'L'){
                current = jankGraph.get(currentParent).get(0); //get left; 
                System.out.println("got left: " + current + " for curr Parent " + currentParent);
            }
            else if(currOrder == 'R'){
                current = jankGraph.get(currentParent).get(1); //get right;
                System.out.println("got right : " + current + " for curr Parent: " + currentParent);
            }
            if(current.equals("ZZZ")){
                zFound = true;
                numSteps++;
            }
            else {
                numSteps++;
                currentParent = current; // if not found, search from last node
            }
        }
            



           }//keep searching
           */

            
        }

        public static long getSteps(String node, HashMap<String, List<String>> graph, String order) {
            long numSteps = 0;
            boolean zFound = false;
              
            String currentParent = node;
            String currentNode = "";
           while(!zFound){
            //check currentOrder
           // Character currOrder = movingOrder.charAt(0);
            //move characters around
           for(Character currOrder : order.toCharArray()){
            if(currOrder == 'L'){
                currentNode = graph.get(currentParent).get(0); //get left; 
                System.out.println("got left: " + currentNode + " for curr Parent " + currentParent);
            }
            else if(currOrder == 'R'){
                currentNode = graph.get(currentParent).get(1); //get right;
                System.out.println("got right : " + currentNode + " for curr Parent: " + currentParent);
            }
            if(currentNode.endsWith("Z")){
                zFound = true;
                numSteps++;
                System.out.println("Found z! in " + numSteps + " steps");
            }
            else {
                numSteps++;
                currentParent = currentNode; // if not found, search from last node
            }
        }
            



           }//keep searching
           

            return numSteps;
        }

        
       
        public static long lcm(long a, long b){
            if(b ==0 ){
                return a;
            }
            return lcm (b, a%b);
        }

        public static long findLCM(List<Long> nums){
            long res = nums.get(0);

            for(int i = 1; i < nums.size(); i++){
                long a = res;
                long b = nums.get(i);
                long gcd = lcm(a,b);
                res = (res * nums.get(i)) / gcd;
            }

            return res;

        }

        public static String generateOrder(String s){
        int length = s.length();

        if (length <= 1) {
            return s;
        } else {
            System.out.println("Generated: " + s.charAt(length - 1) + s.substring(1, length - 1) + s.charAt(0) );
            return s.charAt(length - 1) + s.substring(1, length - 1) + s.charAt(0);
        }
        }

        }

    class Node {
    String value;
    Node left;
    Node right;

    Node(String value) {
        this.value = value;
        right = null;
        left = null;
    }

     String[] getNodeNames(){
        String[] nodes = new String[1];
        nodes[0] = left.value;
        nodes[1] = right.value;
        return nodes;
    }
}

class BinaryTree {
     
   
    Node root;
     
    BinaryTree(String key) { root = new Node(key); }
    BinaryTree() { root = null; }

}


 

