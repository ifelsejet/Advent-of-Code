import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class SonarSweep {
    public static ArrayList<Integer> inputList = new ArrayList<Integer>();

    public static void main(String[] args){
        try {
            Scanner input = new Scanner(new File("C:\\Users\\ifels\\Documents\\GitHub\\Advent-of-Code\\2021\\Day_01\\input.txt"));
            while(input.hasNextInt()){
                inputList.add(input.nextInt());
            }
        } catch(FileNotFoundException exception){}

        System.out.println(calcDepthIncreases(inputList));
        System.out.println(sumOfWindows(inputList));

    }
    
    public static int calcDepthIncreases(ArrayList<Integer> list){
        int depthIncreases = 0;
        for(int i = 0; i < list.size() -1; i++){
            if(list.get(i) < list.get(i+1)){
                depthIncreases += 1;
            }

        }


        return depthIncreases;


    }

    public static int sumOfWindows(ArrayList<Integer> list){
        int res = 0;
        for(int i = 3; i< list.size(); i++){
        if(list.get(i-3) + list.get(i-2) + list.get(i-1) < list.get(i) + list.get(i-2) + list.get(i-1)){
        res++;
      }
    }
    return res;
  }
    
    
}
