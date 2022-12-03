import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class day03{
    public static void main(String[] args){
        BufferedReader reader;
        int pSum = 0;
        HashMap<String, Integer> lowMap = new HashMap<>();
        lowMap.put("a", 1);
        lowMap.put("b", 2);
        lowMap.put("c",3);
        lowMap.put("d", 4);
        lowMap.put("e", 5);
        lowMap.put("f", 6);
        lowMap.put("g", 7);
        lowMap.put("h", 8);
        lowMap.put("i", 9);
        lowMap.put("j", 10);
        lowMap.put("k", 11);
        lowMap.put("l", 12);
        lowMap.put("m", 13);
        lowMap.put("n", 14);
        lowMap.put("o", 15);
        lowMap.put("p", 16);
        lowMap.put("q", 17);
        lowMap.put("r", 18);
        lowMap.put("s", 19);
        lowMap.put("t", 20);
        lowMap.put("u", 21);
        lowMap.put("v", 22);
        lowMap.put("w", 23);
        lowMap.put("x", 24);
        lowMap.put("y", 25);
        lowMap.put("z", 26);
        lowMap.put("A", 27);
        lowMap.put("B", 28);
        lowMap.put("C",29);
        lowMap.put("D", 30);
        lowMap.put("E", 31);
        lowMap.put("F", 32);
        lowMap.put("G", 33);
        lowMap.put("H", 34);
        lowMap.put("I", 35);
        lowMap.put("J", 36);
        lowMap.put("K", 37);
        lowMap.put("L", 38);
        lowMap.put("M", 39);
        lowMap.put("N", 40);
        lowMap.put("O", 41);
        lowMap.put("P", 42);
        lowMap.put("Q", 43);
        lowMap.put("R", 44);
        lowMap.put("S", 45);
        lowMap.put("T", 46);
        lowMap.put("U", 47);
        lowMap.put("V", 48);
        lowMap.put("W", 49);
        lowMap.put("X", 50);
        lowMap.put("Y", 51);
        lowMap.put("Z", 52);
            
		try {
           
			reader = new BufferedReader(new FileReader("check.txt"));
			String line = reader.readLine();

			while (line != null) {
                //System.out.println("we back");
                int len = line.length();
                String part1 = line.substring(0, len / 2), part2 = line.substring(len / 2);
                System.out.println("Line is: " + line);
                System.out.println("1st half is: " + part1);
                System.out.println("2nd half is: " + part2);
                HashMap<Character, Integer> charMap = new HashMap<>();
                System.out.println(charMap.entrySet());
                for(Character c : part1.toCharArray()){
                    charMap.put(c, charMap.getOrDefault(c, 0)+ 1);
                }
                System.out.println(charMap.entrySet());
                
                for(Character c: part2.toCharArray()){
                    if(charMap.get(c) != null && charMap.get(c) > 0){
                        System.out.println("Character shared is: " + c + " added " + lowMap.get(String.valueOf(c)) + " points");
                        pSum += lowMap.get(String.valueOf(c));
                    }
                    //System.out.println("yer!");
                }
                
                
				// read next line
				line = reader.readLine();
               //System.out.println("next line???");
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Priority sum is: " + pSum);
	}
    
    }
