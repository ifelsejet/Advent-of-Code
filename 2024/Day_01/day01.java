import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class day01 {
    public static void main(String[] args) {
        BufferedReader reader;
       // int totalDistance = 0;
        int totalSimScore = 0 ;
        ArrayList<Integer> column1 = new ArrayList<>();
        ArrayList<Integer> column2 = new ArrayList<>();
            Pattern pattern = Pattern.compile("(mul\\((\\d+),(\\d+)\\))|(do\\(\\))|(don't\\(\\))");
            boolean isEnabled = true;

        try {
            // Initialize the BufferedReader to read the file
            reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2024\\Day_01\\test.txt"));
            String line = reader.readLine();

            // Read the file line by line
            while (line != null) {
                // Split the line into columns based on spaces
                String[] columns = line.trim().split("\\s+");

                // Add each column value to the respective ArrayList
                column1.add(Integer.parseInt(columns[0]));
                column2.add(Integer.parseInt(columns[1]));

                // Read the next line
                line = reader.readLine();
            }

            reader.close(); // Close the reader
        } catch (IOException e) {
            // Print error message if an exception occurs
            e.printStackTrace();
        }
        //Sort them - Part 1
       // Collections.sort(column1);
       // Collections.sort(column2);

        //Get absolute difference between the two
       // for(int i = 0; i < column1.size(); i++){
          //  totalDistance = totalDistance + Math.abs(column1.get(i) - column2.get(i));
      //  }
        //For each value, search num of ocurrances in column 2
      for(int i = 0; i < column1.size(); i++){
        int currentNum = column1.get(i);
        int occur = 0;
        for(int numbers : column2){
            if(numbers == currentNum){
                System.out.println("Current number is: " + numbers);
                occur +=1; 
            }
        }
            //After searching, add to total sim score if occured more than once
            if(occur != 0){

                totalSimScore = totalSimScore + (currentNum * occur);
                System.out.println("total sim score is: " + totalSimScore);
            }
        }
      

        // Print the results
        System.out.println("Column 1: " + column1);
        System.out.println("Column 2: " + column2);
       // System.out.println("Total Distance: " + totalDistance);
       System.out.println("Total Similarity Score: " + totalSimScore);
    }

}

