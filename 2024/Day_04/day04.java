import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class day04 {

    public static final int[][] directions = {
        {0, 1},   // Right
        {0, -1},  // Left
        {1, 0},   // Down
        {-1, 0},  // Up
        {1, 1},   // Down-Right
        {-1, -1}, // Up-Left
        {1, -1},  // Down-Left
        {-1, 1}   // Up-Right
    };
    public static void main(String[] args) {
        
        List<String> lines = new ArrayList<>();
        int times = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2024\\Day_04\\sample.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* 
        for(int i = 0; i < lines.size(); i++){
            for(int j = 0; j < lines.get(0).length(); j++){
                for (int[] dir : directions) {
                    if (checkWord(lines, i, j, dir[0], dir[1])) {
                        times++;
                    }
                }

            }
        }
            */

        for(int i = 0; i < lines.size() -2 ; i++){
            for(int j = 0; j < lines.get(0).length() -2; j++){
                if (checkXMAS(lines, i, j)) {
                    times++;
                }

            }
        }
        System.out.println("Times are: " + times);


      

    }



     public static boolean checkWord(List<String> grid, int row, int col, int dRow, int dCol) {
        String target = "XMAS";
        int length = target.length();

        if (row + (length - 1) * dRow < 0 || row + (length - 1) * dRow >= grid.size() ||
            col + (length - 1) * dCol < 0 || col + (length - 1) * dCol >= grid.get(0).length()) {
            return false;
        }

        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            word.append(grid.get(row + i * dRow).charAt(col + i * dCol));
        }
        return word.toString().equals(target);
    }

    private static boolean isValidMAS(char a, char b, char c) {
        return (a == 'M' && b == 'A' && c == 'S') ||
               (a == 'S' && b == 'A' && c == 'M');
    }


    private static boolean checkXMAS(List<String> grid, int startRow, int startCol) {
        if (startRow + 2 >= grid.size() || startCol + 2 >= grid.get(0).length()) {
            return false;
        }

        char topLeft = grid.get(startRow).charAt(startCol);
        char middle = grid.get(startRow + 1).charAt(startCol + 1);
        char topRight = grid.get(startRow).charAt(startCol + 2);
        char bottomLeft = grid.get(startRow + 2).charAt(startCol);
        char bottomRight = grid.get(startRow + 2).charAt(startCol + 2);

        boolean diagonal1Valid = isValidMAS(topLeft, middle, bottomRight);
        boolean diagonal2Valid = isValidMAS(topRight, middle, bottomLeft);


        return diagonal1Valid && diagonal2Valid;
    }



   
   
    }


   

