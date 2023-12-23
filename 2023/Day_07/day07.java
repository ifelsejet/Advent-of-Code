import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
public class day07 {
public static void main(String[] args) {
    BufferedReader reader;
    try{
        reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_07\\sample.txt"));
            String line = reader.readLine();

            while(line != null){
                System.out.println(line);
              
                
                line = reader.readLine();
            }
            reader.close();

        }  catch (IOException e) {
            e.printStackTrace();
        }
}
}
