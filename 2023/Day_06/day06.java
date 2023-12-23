import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
public class day06 {
    public static void main(String[] args) {
        BufferedReader reader;
        boolean isFirstLine = true;
        ArrayList<String> time = new ArrayList<>();
        ArrayList<String> dist = new ArrayList<>();
        int numWays = 1;

        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_06\\input.txt"));
                String line = reader.readLine();

                while(line != null){
                    System.out.println(line);
                    String[] nums = line.split(" ");
                    if(isFirstLine){
                        isFirstLine = false;
                        for(String num : nums){
                          //  System.out.println(num);
                            time.add(num); 
                        }
                    }
                    else{//add distances
                        for(String num : nums){
//System.out.println(num);
                            dist.add(num); 
                        } 
                    }
                    line = reader.readLine();
                }
                reader.close();

            }  catch (IOException e) {
                e.printStackTrace();
            }

            time.forEach(item -> System.out.println("time: " + item));
             dist.forEach(item -> System.out.println("dist: " + dist));
            ArrayList<Long> ans = new ArrayList<>();
            for(int i = 0; i < time.size(); i++){
                ans.add(findWays(Long.parseLong(time.get(i)), Long.parseLong(dist.get(i))));
            }//find ways for each

            for(Long way : ans){
                numWays *= way;
            }

            System.out.println("# of ways: " + numWays);
    }

    public static long findWays(long time, long distance){
        int count = 0;
        //use formula
        for(int i = 0; i < time; i++){
            if((time-i) * i > distance){
                count++;
            }
        }

        return count;

    }

    
}
