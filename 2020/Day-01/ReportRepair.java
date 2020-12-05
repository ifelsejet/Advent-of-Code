import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReportRepair {
    public static ArrayList<Integer> inputList = new ArrayList<Integer>();
    public static void main(String[] args) {  
        try {
            Scanner input = new Scanner(new File("input.txt"));
            while(input.hasNextInt())
                inputList.add(input.nextInt());
            System.out.println(calcSolution1());
            System.out.println(calcSolution2());
        } catch(FileNotFoundException exception){}
    }

    public static int calcSolution1() {
        for(int i = 0; i < inputList.size(); i++) 
            for(int v = 1; v < inputList.size(); v++)
                if(inputList.get(i) + inputList.get(v) == 2020)
                    return inputList.get(i)*inputList.get(v);
                    
        return -1;
    }

    public static int calcSolution2() {
        for(int i = 0; i < inputList.size(); i++)
            for(int v = 1; v < inputList.size(); v++)
                for(int a = 2; a < inputList.size(); a++)
                    if(inputList.get(i) + inputList.get(v) + inputList.get(a) == 2020)
                        return inputList.get(i)*inputList.get(v)*inputList.get(a);
        return -1;
    }

}