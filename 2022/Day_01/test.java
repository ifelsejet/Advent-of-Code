import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;


public class test{
    public static void main(String[] args){
        BufferedReader reader;
        int maxCalories = Integer.MIN_VALUE;
        int currCalories = Integer.MIN_VALUE;
        PriorityQueue<Integer> elfCalories = new PriorityQueue<>((a,b) -> b-a); //check to see if maxQueue 
		try {
            //File test=new File("check.txt");
            //if (test.createNewFile()) {
            //System.out.println("File created: " + test.getName());
            //}
            //Paths are stupid
			reader = new BufferedReader(new FileReader("test.txt"));
			String line = reader.readLine();

			while (line != null) {
                //if not a space, sum calories for current elf
				if(!line.equals("")){
                    currCalories += Integer.valueOf(line);
                }
                //if space, check calories for current elf
                if(line.equals("")){
                    elfCalories.add(currCalories);
                    //Part 1: maxCalories = Math.max(maxCalories, currCalories)
                    currCalories = 0;
                }
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
            System.out.println("purr");
		}
        for(int i = 0; i < 3; i++){
            maxCalories += elfCalories.poll();
        }
        System.out.println("Max calories is: " + maxCalories);
        int yer = 69310+68501+68293;
        System.out.println(yer); //min_value bad
	}
    }
