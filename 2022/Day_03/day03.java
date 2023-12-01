import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class day03{
    public static void main(String[] args){
        BufferedReader reader;
        int prioritySum = 0;
        int lineCount  = 0;
        List<String> ruckSacks = new ArrayList<>();
       // System.out.println("Working Directory = " + System.getProperty("user.dir"));

        try{
        reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2022\\Day_03\\test.txt"));
			String line = reader.readLine();

			while (line != null) {
                lineCount++;
                if(lineCount % 3 == 0){
                    ruckSacks.add(line);
                    System.out.println("on line " + lineCount);
                    System.out.println("items from 3 lines " + ruckSacks.size());

                    //if 3 lines have been read.
                    String item1 = ruckSacks.get(0);
                    String item2 = ruckSacks.get(1);
                    String item3 = ruckSacks.get(2);

                    item2 = item2.concat(ruckSacks.get(2));
                    System.out.println("items are: " + item1 + " item 2 " + item2 + " item 3 " + item3);
                    System.out.println("common char for all 3 is:" + findCommonCharForThree(item1, item2, item3) +" score is " + characterToPriority(findCommonCharForThree(item1, item2, item3))) ;
                    prioritySum += characterToPriority(findCommonCharForThree(item1, item2, item3));
                    //clear sack when done
                    ruckSacks.removeAll(ruckSacks);
                }
                else{
                    ruckSacks.add(line);
                }
                line = reader.readLine();
                //System.out.println(line);
                /*
                 * For all items in line, we want to split into half. Then find the characters that are in each compartment
                 * 
                 */
				// read next line
                /*
                String compartment1 = line.substring(0, line.length()/2);
                String compartment2 = line.substring(line.length()/2);
                
                System.out.println("Line is " +  line);
                System.out.println("Splits are " +  compartment1 +" AND " + compartment2);

                //Find the common character in each compartment
                char common_char = findCommonChar(compartment1, compartment2);
                prioritySum += characterToPriority(common_char);
				line = reader.readLine();
                */
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
            System.out.println("purr");
		}
        System.out.println("Part 2 solution: " + prioritySum);
    }

	
    public static char findCommonChar(String s1, String s2){
        HashSet<Character> s1Set = new HashSet<>();
        Character commonChar = 'a'; 
        for(Character ch: s1.toCharArray()){
            s1Set.add(ch);
        }

        for(Character ch : s2.toCharArray()){
            if(s1Set.contains(ch)){
               return ch.charValue();
            }
        }
        return '?'; //if no default chars are found
    }

    public static int characterToPriority(char c) {
        if ('a' <= c && c <= 'z') {
            return c - 'a' + 1;
        } else if ('A' <= c && c <= 'Z') {
            return c - 'A' + 27;
    }
    else{
        return -1;
    }
        }

        public static char findCommonCharForThree(String s1, String s2, String s3) {
            for (char c : s1.toCharArray()) {
                if (s2.indexOf(c) != -1 && s3.indexOf(c) != -1) {
                    return c;
                }
            }
            return '?'; // Return null if no common character is found
        }
}

