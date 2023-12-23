import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
public class day10 {
   
    public static void main(String[] args) {
         BufferedReader reader;
        long steps = 0;
        List<List<String>>  matrix = new ArrayList<>();
        int N = 0;
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_10\\sample.txt"));
                String line = reader.readLine();
              
        
                while(line != null){
                  String[] elements = line.split("");
                  matrix.add(N, Arrays.asList(elements));
                  N++; // increase index;
                 
                   line = reader.readLine();
                }
                reader.close();

            }  catch (IOException e) {
                e.printStackTrace();
            }
                
                for(List<String> list: matrix){
                      list.forEach(item -> System.out.println("item: " + item));
                }
            System.out.println("steps needed: " + steps);
        
    }
}
