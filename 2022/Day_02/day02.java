import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class day02{
    public static void main(String[] args){
        BufferedReader reader;
        int totalScore = 0;
        HashMap<String, String> gameMap = new HashMap<>();
        gameMap.put("A", "X"); //Rock
        gameMap.put("B", "Y"); //Paper
        gameMap.put("C", "Z"); //Scissors
        /*
         * Part 1
         * HashMap<String, String> winMap = new HashMap<>();
        winMap.put("X", "C"); //Rock beats scissors
        winMap.put("Y", "A"); //Paper beats rock
        winMap.put("Z", "B"); //scissors beats paper
         */
        HashMap<String, String> winMap = new HashMap<>();
        winMap.put("A", "Y"); //Rock beats scissors
        winMap.put("B", "Z"); //Paper beats rock
        winMap.put("C", "X"); //scissors beats paper
        HashMap<String, String> loseMap = new HashMap<>();
        loseMap.put("C", "Y"); 
        loseMap.put("A", "Z"); 
        loseMap.put("B", "X"); 
        HashMap<String, Integer> pointMap = new HashMap<>();
        pointMap.put("X", 1); // Rock 1 points
        pointMap.put("Y", 2); // Paper 2 points
        pointMap.put("Z", 3); // Scissors 3 points


        /*
         * 
         * 1st column
         * A for Rock, 
         * B for Paper, and 
         * C for Scissors
         * 
         */

        /*
         * 2nd column (Part 1)
         * 
         * X for Rock, (1 pt)
         * Y for Paper, and (2pt)
         * Z for Scissors (3pt)
         * 
         * 0pts if lose
         * 3pts if draw
         * 6pts if win
         */

         /*
         * 2nd column (Part 2)
         * 
         * X - lose
         * Y - tie
         * Z - win
         * 
         * 0pts if lose
         * 3pts if draw
         * 6pts if win
         */
		try {
           
			reader = new BufferedReader(new FileReader("check.txt"));
			String line = reader.readLine();
			while (line != null) {
                
                String[] split = line.split("");
                System.out.println("Line is : " + line);
                String opp = split[0];
                String player  = split[2];
                if(player.equals("X")){ //lose
                    totalScore += pointMap.get(loseMap.get(opp));
                    System.out.println("Lose! "+ pointMap.get(loseMap.get(opp)) + " points given");
                }
                else if(player.equals("Z")){//win
                    totalScore += pointMap.get(winMap.get(opp));
                    System.out.println("Win! "+ pointMap.get(loseMap.get(opp)) + " points given");
                    totalScore += 6;
                }
                else{//draw "Y"
                    totalScore += pointMap.get(gameMap.get(opp));
                    System.out.println("Draw! "+ pointMap.get(loseMap.get(opp)) + " points given");
                    totalScore += 3;
                }
                /*
                 * Part 1
                 
                //check for player choice
                if(player.equals("X")){
                    totalScore += 1;
                }
                else if(player.equals("Y")){
                    totalScore += 2;
                }
                else if(player.equals("Z")){
                    totalScore += 3;
                }
                

                //check if player and opp the same
                if(player.equals(gameMap.get(opp))){
                    System.out.println("tie!");
                    totalScore += 3;
                }
                //check if player won
                else if(winMap.get(player).equals(opp)){
                    System.out.println("win!");
                    totalScore += 6;
                }
                else{
                    System.out.println("loss!");

                }

                //System.out.println("Split (1st col) is : " + split[0]);
                //System.out.println("Split (2nd col) is : " + split[2]);
                */
				// read next line
				line = reader.readLine();
                
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Score is " + totalScore);
        
	}
    }
