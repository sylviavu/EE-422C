//package assignment3;
/* WORD LADDER Node.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Summer 2019
 */

package assignment3;
import java.util.*;

public class Node{

       public String word;
       ArrayList<Node> adjacentList;
       boolean visited;
       static TreeMap<String, Node> wordGraph = new TreeMap<String, Node>();
       static Set<String> d = Main.makeDictionary();
       Node adjacent;

       public Node(String word){
           this.word = word;
           visited = false;
           this.adjacentList = new ArrayList<Node>();
       }

       // For each word in the dictionary, create a new Node
       public static void makeGraph(){
           for(String word : d){
               Node newNode = new Node(word);
               wordGraph.put(word, newNode);
           }
       }

       public void findAdjacent(){
           this.adjacentList = new ArrayList<Node>();
           for(Node next: wordGraph.values()){      // go through each of the nodes in the graph
               int similar = 0;
               int index = 0;      // word index (0 through 4) -> only testing 5 letter words

               /* Check to see how many letters are in common between a word in the dictionary and the word 
                we are currently dealing with (making the call)
                */
               while(index < 5){
                   if(this.word.charAt(index) == next.word.charAt(index)){
                       similar++;
                   }
                   index++;
               }
               
               // words are considered to be adjacent when they differ in only one letter
               if(similar == 4){
                   this.adjacentList.add(next);
               }
           }
           //return this.adjacent;
       }

       public ArrayList<Node> get_Adjacent(){
           return this.adjacentList;
       }
       
       public Node getAdjacent(){
           return adjacent;
       }


}
