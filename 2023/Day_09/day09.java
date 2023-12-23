import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
public class day09 {
public static void main(String[] args) {
    BufferedReader reader;
    long sumExtract = 0;
    List<List<Integer>>  nums = new ArrayList<>();
    int index = 0;
    try{
        reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_09\\input.txt"));
            String line = reader.readLine();
          
         //   List<List<Integer>> sequenceDifferences = new ArrayList<>();
            while(line != null){
                 List<Integer> originalSequence = new ArrayList<>();
                for(String num : line.split(" ")){
                   originalSequence.add(Integer.parseInt(num));
               }
               //add sequence to input list
               nums.add(index, originalSequence);
               index++;
                //find the differences between the sequence
              

                //return a list to append to seqDiff
                //List<Integer> theDiff = getDifferences(originalSequence);
               // int index = 0;
             //   sequenceDifferences.add(index, theDiff);
              //  index++;
              //  for(List<Integer> list: sequenceDifferences){
               //     list.forEach(item -> System.out.println("item: " + item));
              //  }
               // System.out.println("BREAK, last item is " + sequenceDifferences.get(1));

               //while are all not 0, keep adding to sequence difference, and taking the difference of the current 
               //while(!areAllZero(sequenceDifferences.get(index))){

              //  index++;
              // }

              

             
                //when differences are all zero, get the last element in list and add this to last # of original sequence
                
              
                
                line = reader.readLine();
            }
            reader.close();

        }  catch (IOException e) {
            e.printStackTrace();
        }
        
        int lSize = 0;
        for(List<Integer> numList : nums){
                Collections.reverse(numList);
           }

           for(List<Integer> numList : nums){
               sumExtract += getNum(numList);
           }

        
       
        System.out.println("Extracted values for: " + sumExtract);
        // System.out.println("Extracted values! for: " + nums.stream().mapToInt(getNum(nums.forEach(list))).sum());

}
public static int getNum(List<Integer> numList){
    int sum = 0;
     while(true){
            List<Integer> diffs = new ArrayList<>();
            boolean areAllZero = true;
            sum += numList.get(numList.size() -1);
            for(int i = 0; i < numList.size() -1; i++){
                int difference = numList.get(i+1) - numList.get(i);
                if(difference != 0){
                    areAllZero = false;
                }
                diffs.add(difference);
            }
            if(areAllZero == true){
                break;
            }
            numList = diffs;
}
return sum;
}
 public static List<Integer> getDifferences(List<Integer> sequence){
            List<Integer> ans = new ArrayList<>();
            for(int i = 0 ; i < sequence.size()-1; i++){
                ans.add(sequence.get(i+1)-sequence.get(i)); //calculate difference
            }
            return ans;
        }
public static boolean areAllZero(List<Integer> sequence){
    for(int num : sequence){
        if(num != 0){
            return false;
        }
    }

    return true;
}
}
