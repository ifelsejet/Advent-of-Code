import java.util.*;
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

public class day01 {
    public static void main(String[] args){
        BufferedReader reader;
        int totalDistance = 0;
        try{
        reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2024\\Day_01\\test.txt"));
			String line = reader.readLine();
/* 
               while (line != null) {
           
               }
              */
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Part 1 solution: " + totalDistance);
    }
}
    

