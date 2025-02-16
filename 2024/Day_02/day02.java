import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day02 {
    public static void main(String[] args) {
        BufferedReader reader;
        int numSafeReports = 0;

        try {
            // Initialize the BufferedReader to read the file
            reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2024\\Day_02\\test .txt"));
            String line = reader.readLine();

            // Read the file line by line
            while (line != null) {
                // Convert the row (line) into a list of integers
                String[] row = processRow(line);
                /* 
                if(safe(row)){
                    numSafeReports++;
                }
                    */
                    
                        boolean any = false;
                        for(int i = 0; i < row.length; i++){
                            String[] newrow = new String[row.length - 1];
                            System.arraycopy(row, 0, newrow, 0, i);
                            if (row.length >= i + 1)
                                System.arraycopy(row, i + 1, newrow, i + 1 - 1, row.length - (i + 1));
                            if(safe(newrow)){
                                any = true;
                            }
                        }
                        if(any){
                            numSafeReports++;
                        }
                    

                // Read the next line
                line = reader.readLine();
            }

            reader.close(); // Close the reader
        } catch (IOException e) {
            // Print error message if an exception occurs
            e.printStackTrace();
        }
        System.out.println("Number of safe reports are: " + numSafeReports);
    }

    // Method to process a row (convert a line into a list of integers)
    public static String[] processRow(String line) {
        return line.trim().split("\\s+");
    }
    

    public static boolean safe(String[] steps){
        int[] nums = new int[steps.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(steps[i]);
        }
        boolean decreasing = nums[0] > nums[1];
        if(nums[0] == nums[1]){
            return false;
        }
        for(int i = 1; i < nums.length; i++){
            if(Math.abs(nums[i] - nums[i-1]) > 3){
                return false;
            }
            if(nums[i] > nums[i - 1] && decreasing){
                return false;
            }
            if(nums[i] < nums[i - 1] && !decreasing){
                return false;
            }
            if(nums[i] == nums[i-1]){
                return false;
            }
        }
        return true;

    }
}
