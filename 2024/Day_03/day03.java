import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.List;


public class day03 {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        int lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2024\\Day_03\\test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        final Pattern p = Pattern.compile("mul\\((\\d+),(\\d+)\\)|(do|don't)\\(\\)");

        boolean enabled = true;
        int result = 0, filtered = 0;
        for (String s : lines) {
            Matcher m = p.matcher(s);
            while (m.find()) {
                if (m.group(0).startsWith("mul")) {
                    int product = Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(2));
                    result += product;
                    if (enabled) {
                        filtered += product;
                    }
                } else {
                    enabled = !m.group(0).startsWith("don't");
                }
            }
        }

        System.out.printf("Part 1: %d\n", result);
        System.out.printf("Part 2: %d\n", filtered);
        System.out.println("Chars are: " + countCharacters(lines));
        System.out.println("Line count is: " + lineCount);

    }

    public static int countCharacters(List<String> strings) {
        int total = 0;
        for (String str : strings) {
            if (str != null) {
                total += str.length();
            }
        }
        return total;
    }
   
    }


   

