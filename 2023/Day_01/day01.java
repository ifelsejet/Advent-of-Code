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
        int calSum = 0;
        try{
        reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_01\\test.txt"));
			String line = reader.readLine();

               while (line != null) {
                    String str = line;
                    System.out.println("Fixed string: " + fixString(str));
                    System.out.println("Replaced w numbers: " + replaceString(fixString(str)));
                    String temp = replaceString(fixString(str));
                    String filtered = temp.replaceAll("[^0-9]", "");
                    System.out.println("Final Digits: " + getDigits(filtered));
                    calSum += getDigits(filtered);
                    /* 
                    String stringsOnly = str.replaceAll("\\d+(?:[.,]\\d+)*\\s*", "");
                    stringsOnly =  stringsOnly.replace("x","");
                    stringsOnly =  stringsOnly.replace("y","");
                    stringsOnly =  stringsOnly.replace("z","");
                    stringsOnly =  stringsOnly.replace("p","");
                    stringsOnly =  stringsOnly.replace("q","");
                    */
                    //System.out.println("letters only " + stringsOnly);
                   // String numberOnly= str.replaceAll("[^0-9]", "");
                   // System.out.println("Numbers: " + numberOnly + " Filter res: " + getDigits(numberOnly));
                    //char[] chars = numberOnly.toCharArray();
                   // char first = chars[0];
                   // char last = chars[chars.length-1];
                   // System.out.println("First dig: " + first + " Last dig: " + last);
                    // StringBuilder numb = new StringBuilder();
                   //numb.append(first);
                   // numb.append(last);
                    //System.out.println("appended number res " + getDigits(numberOnly.toString()));
                    
                   // calSum += getDigits(numberOnly);
                   // System.out.println(str.toCharArray())
                     line = reader.readLine();
               }
              
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Part 2 solution: " + calSum);
    }

    public static String fixString(String str){
      
        String fix = str.replaceAll("one", "oonee");
         fix = fix.replaceAll("two", "ttwoo");
         fix = fix.replaceAll("three", "tthreee");
         fix = fix.replaceAll("four", "ffourr");
         fix = fix.replaceAll("five", "ffivee");
         fix = fix.replaceAll("six", "ssixx");
         fix = fix.replaceAll("seven", "ssevenn");
         fix = fix.replaceAll("eight", "eeightt");
         fix = fix.replaceAll("nine", "nninee");
         return fix;

    }

    public static String replaceString(String replace){

         String fix = replace.replaceAll("one", "1");
         fix = fix.replaceAll("two", "2");
         fix = fix.replaceAll("three", "3");
         fix = fix.replaceAll("four", "4");
         fix = fix.replaceAll("five", "5");
         fix = fix.replaceAll("six", "6");
         fix = fix.replaceAll("seven", "7");
         fix = fix.replaceAll("eight", "8");
         fix = fix.replaceAll("nine", "9");
         return fix;

    }

    public static int getDigits(String number){
        if(number.length() == 1){
           StringBuilder sb = new StringBuilder();
                    sb.append(number);
                    sb.append(number);
                   return Integer.parseInt(sb.toString());
        }
        else if(number.length() >= 2){
             char[] chars = number.toCharArray();
                    char first = chars[0];
                    char last = chars[chars.length-1];
                    StringBuilder sb = new StringBuilder();
                    sb.append(first);
                    sb.append(last);
                   return Integer.parseInt(sb.toString());
                   
    }
    return -10000000; // edge case
}
}
    

