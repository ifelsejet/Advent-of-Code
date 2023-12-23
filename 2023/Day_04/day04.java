import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class day04 {
    public static void main(String[] args ){
        BufferedReader reader;
        int totalPoints = 0;
        int lineCount = 6; //change for input
        int totalInstances = 0;
        int currCardCount = 0;

        List<Integer> instances = new ArrayList<>();
        for(int i = 0; i < lineCount; i++){
            instances.add(i, 1); // we will always have original instances
        }

        for(int i = 0; i < instances.size(); i++){
         //   System.out.println("# " + i + " value: " + instances.get(i) );
        }
        
       
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_04\\sample.txt"));
                String line = reader.readLine();
              
    
                   while (line != null) {
                     lineCount += 1 ;
                     currCardCount +=1 ;
                    //System.out.println(line.split("|"));
                    int currPoints = 0;
                    //String[] cards = line.substring(line.lastIndexOf(":")+1).split(" ");
                    String[] split = line.split(":");
                    String onlyNumbers = split[1];
                    String[] cardLine = onlyNumbers.split(" | ");
                    

                  
                    System.out.println("Only #'s :" + onlyNumbers);
                   
                    
                    HashSet<String> winning = new HashSet<>();
                    List<String> currWinningCards = new ArrayList<>();

                    //int currentWinningCards = 0;
                   // cards = cards.split(" ")
                   // System.out.println("cards :" + cards);
                   boolean isSplitFound = false;
                   int index = 0;
                    for(String card : cardLine){
                        index += 1;
                       if(card.equals("|")) {
                        isSplitFound = true;
                        System.out.println("Split is found, looking into actual cards!");
                       }
                       else if(!card.equals(" ") && isNumeric(card)){ // if not an empty space or |
                            if(!isSplitFound){
                                 System.out.println("Split is NOT found, adding " + card + " to winning deck!" );
                                winning.add(card);
                            }
                            else if(isSplitFound){
                                if(winning.contains(card)){
                                    currWinningCards.add(card);
                                    System.out.println(card + " is a winner" + " # of wins " + currWinningCards.size());

                                }
                            }
                       }
                       // System.out.println("On Card : " + index + " total matching cards " + currWinningCards.size());
                     
                    }

                    //when done with line
                    System.out.println("OUT OF LINE, # of matches found : " + currWinningCards.size() + "for card :" + currCardCount);

                    // if count is N, we want to add 1 from N+1 to the # of winning cards
                    // so if one on first card, and total count is 4, then add 1 to 2,3,4,5
                    int size = currWinningCards.size();
                    while(size > 0){
                        int acUpdate = currCardCount - (size-1); //indices to update
                        size--;
                    }
                    if(currWinningCards.size() > 0){
                        //add to card slots
                        for(int  i = currCardCount+1; i < instances.size(); i++ ){
                            instances.set(i, instances.get(i)+1); // upxate current card val
                            System.out.println("Card value " + i + " is NOW" + instances.get(i) + " for card turn : " + currCardCount);
                        }
                        
                    }

                   

                    /*PART 1
                    if(currWinningCards.size() >= 1 ){
                       currPoints += Math.pow(2, currWinningCards.size() -1);
                     }
                    
                     else{ //no winners were found
                        System.out.println("no winners! ");
                        currPoints = 0;
                     }
                    totalPoints += currPoints;
                    System.out.println("total points : "+ totalPoints);
                     */

                     //after reaching end of line
                     /* 
                     for(String winner : currWinningCards){
                        System.out.println("Winner #:" + winner);
                     }
                    System.out.println("total # of cards for line: " + currWinningCards.size());
                        */
                        line = reader.readLine();
                   }
                     reader.close();
                }
              
             catch (IOException e) {
                e.printStackTrace();
            }
           // System.out.println("Part 1 sol: " + totalPoints);
           
           for(Integer instance : instances){
                totalInstances += instance;
           }
            System.out.println("Part 2 sol: " + totalInstances);

        }
        public static boolean isNumeric(String strNum) {
            if (strNum == null) {
                return false;
            }
            try {
                double d = Double.parseDouble(strNum);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }
    }

