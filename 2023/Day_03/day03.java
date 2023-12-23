import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class day03 {
    public static void main(String[] args){
        BufferedReader reader;
        int engSum = 0;
        List<List<String>> matrix = new ArrayList<List<String>>();  
        try{
        reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_03\\pauloInput.txt"));
			String line = reader.readLine();

               while (line != null) {
                //char[] cArr = line.toCharArray();
                List<String> row = Arrays.asList(line.split(""));
                matrix.add(row);
                /* 
                for (String e : row) {  
                        System.out.print(e);  
                    }  
                matrix.add(row);
                */

                //System.out.println("Line items: " + row.size());

                line = reader.readLine();

               }
              
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}// convert file to 2D array
        List<Integer> debugList = new ArrayList<>();
        for(int i = 0; i < matrix.size(); i++){
            boolean isValid = false;
            String numberToSum = "";
            for(int j = 0; j < matrix.get(i).size(); j++){ // each row
                //check to see if number
                String currPos = matrix.get(i).get(j);
                if(isNumber(currPos)){
                    //System.out.println("search to check if valid" + currPos);
                    numberToSum += currPos;
                    System.out.println("Digit to check: "+ currPos + " curr ov number: " + numberToSum);
                    //if number, check if valid
                    //if number was valid previously, let it continue checking until we see the "."
                    if(isNumValid(numberToSum, matrix, i, j) == false && isValid && numberToSum.length() > 0){
                        
                    }
                    else if(isNumValid(numberToSum, matrix, i, j) == true){
                            isValid = true;
                    }
                    System.out.println("Cur num " + numberToSum + " is valid? " + isValid);
                }
                else if(!isValid){
                    //delete everything
                    numberToSum ="";
                    isValid = false;

                }
                 else if(isValid){ // if special character is in between, reset the number
                    //delete everything, but add sum to number, reset everything
                    engSum += Integer.valueOf(numberToSum);
                    debugList.add(Integer.valueOf(numberToSum));
                    System.out.println("Added " + numberToSum + " curr Sum is now " + engSum);

                    numberToSum = "";
                    isValid = false;

                }

                

            }
            System.out.println("");

        }
        int dSum = 0;
        /* 
        for(int num : debugList){
            dSum += num;
            System.out.println("num : " + num);
        }
        */

        System.out.println (" da size "+ debugList.size());
        System.out.println("Part 1 solution: " + engSum);
       // saveVisuals(matrix);
       // readFromFile();
  
    }

    public static boolean isNumber(String num){
       return (
        num.equals("1") || num.equals("2") ||
        num.equals("3") || num.equals("4") ||
        num.equals("5") || num.equals("6") ||
        num.equals("7") || num.equals("8") ||
        num.equals("9") || num.equals("0")
       );
    }

    public static boolean isSpecial(String checked){
        return (!isNumber(checked) && !checked.equals("."));
    }

    public static void saveVisuals(List<List<String>> matrixCopy){
        List<String> cleanNums = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < matrixCopy.size(); i++){
            boolean isValid = false;
            String numberToSum = "";
            for(int j = 0; j < matrixCopy.get(i).size(); j++){ // each row
                //check to see if number
                String currPos = matrixCopy.get(i).get(j);
                if(isNumber(currPos)){
                    //System.out.println("search to check if valid" + currPos);
                    numberToSum += currPos;
                    System.out.println("Digit to check: "+ currPos + " curr ov number: " + numberToSum);
                    
                     if(isNumValid(numberToSum, matrixCopy, i, j) == true){
                            isValid = true;
                            matrixCopy.get(i).set(j, "X"); // replace all valid # s with X's 

                    }
                    System.out.println("Cur num " + numberToSum + " is valid? " + isValid);
                }
                else if(!isValid){
                    //delete everything
                    numberToSum ="";
                    isValid = false;

                }
                 else if(isValid){ 
                    numberToSum = "";
                    isValid = false;

                }
            }
        }
          for(int i = 0; i < matrixCopy.size(); i++){
       
            for(int j = 0; j < matrixCopy.get(i).size(); j++){ // each row
              builder.append(matrixCopy.get(i).get(j));
            }
            builder.append("\n");//append new line at the end of the row

        }

        StringBuilder builderT = new StringBuilder();

        for(int i = 0; i < matrixCopy.size(); i++){
       
            for(int j = 0; j < matrixCopy.get(i).size(); j++){ // each row
               
              builderT.append(matrixCopy.get(i).get(j));
            }
            builderT.append("\n");//append new line at the end of the row

        }
       
        BufferedWriter writerT;
        try {
           // writer = new BufferedWriter(new FileWriter("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_03\\write.txt"));
           // writer.write(builder.toString());//save the string representation of the board
           // writer.close();
            writerT = new BufferedWriter(new FileWriter("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_03\\test.txt"));
            writerT.write(builderT.toString());//save the string representation of the board
            writerT.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
    public static boolean isNumValid(String number, List<List<String>> matrix, int currI, int currJ){
        int matrixRows = matrix.size();
        int matrixColumns = matrix.get(matrixRows-1).size();
       // System.out.println("max rows and cols are : " +  matrixRows + "" +matrixColumns);
               // System.out.println("pass row and col: " +  currI + "" +currJ);


        //check up - check if on top
        if(currI != 0){
            String above = matrix.get(currI-1).get(currJ);
          

            if(isSpecial(above)){
                System.out.println("number is found to be valid!" + number);
                  System.out.println("checked above, found: " + above);
                return true;
            }
        }
        

        //check down - check to see if on bottom
        if(currI != matrixRows-1){
            String down = matrix.get(currI+1).get(currJ);
         

            if(isSpecial(down)){
                System.out.println("number is found to be valid!" + number);
                   System.out.println("checked down, found: " + down);
                return true;
            }
        }

        //check left - check to see if on far left
        if(currI!= 0 && currJ != 0){
            String left = matrix.get(currI).get(currJ-1);

            if(isSpecial(left)){
                System.out.println("number is found to be valid!" + number);
                System.out.println("checked left, found: " + left);

                return true;
            }

        }

        //check right  - check to see if on far right
         if(currJ != matrixColumns-1){
            String right = matrix.get(currI).get(currJ+1);
          

            if(isSpecial(right)){
                System.out.println("number is found to be valid!" + number);
                  System.out.println("checked right, found: " + right);
                return true;
            }

        }

        //check up/left
        if(currI != 0 &&  currJ != 0){
            String upLeft = matrix.get(currI-1).get(currJ-1);
          

            if(isSpecial(upLeft)){
                System.out.println("number is found to be valid!" + number);
                  System.out.println("checked up & left, found: " + upLeft);
                return true;
            }
        }

        //check up/right
          if(currI != 0 &&  currJ != matrixColumns-1){
            String upRight = matrix.get(currI-1).get(currJ+1);
          

            if(isSpecial(upRight)){
                System.out.println("number is found to be valid!" + number);
                  System.out.println("checked up & right , found: " + upRight);
                return true;
            }
        }

        //check down/right

          if(currI != matrixRows-1 &&  currJ != matrixColumns-1){
            String downRight = matrix.get(currI+1).get(currJ+1);
         //   System.out.println("checked down & right , found: " + downRight);

            if(isSpecial(downRight)){
                System.out.println("number is found to be valid!" + number);
                System.out.println("checked down & right , found: " + downRight);

                return true;
            }
        }

        //check down/left
         if(currJ != 0 && currI != matrixRows-1){
            String downLeft = matrix.get(currI+1).get(currJ-1);

            if(isSpecial(downLeft)){
                System.out.println("number is found to be valid!" + number);
                System.out.println("checked down & left , found: " + downLeft);

                return true;
            }
        }

        return false;

    }

   

   
}






    

