import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class day03try3 {
    private static final List<int[]> dir = new ArrayList<>(List.of(
            new int[] { 1, 1 },
            new int[] { 1, 0 },
            new int[] { 1, -1 },
            new int[] { 0, -1 },
            new int[] { -1, -1 },
            new int[] { -1, 0 },
            new int[] { -1, 1 },
            new int[] { 0, 1 }));
    public static void main(String[] args) {
        int res = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\Advent-of-Code\\2023\\Day_03\\input.txt"))) {
            List<String[]> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.split(""));
            }

            int row = 0;
            for (String[] strArray : lines) {
                int i = 0, j = 0;

                while (j < strArray.length) {
                    if (isSymbol(strArray[j].charAt(0)) || strArray[j].equals(".")) {
                        i++;
                        j++;
                        continue;
                    }
                    StringBuilder num = new StringBuilder();
                    while (j < strArray.length && !isSymbol(strArray[j].charAt(0)) && !strArray[j].equals(".")) {
                        num.append(strArray[j]);
                        j++;
                    }
                    // check if it is engine part
                    boolean flag = false;
                    for (int k = i; k < j; k++) {
                        if (isEnginePart(row, k, lines)) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        res += Integer.parseInt(num.toString());
                    }
                    // update i and j
                    i = j;
                }

                row++;
            }




            System.out.println("Answer: " + res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     static boolean isSymbol(char ch) {
        return !Character.isDigit(ch) && ch != '.';
    }

    static boolean isEnginePart(int row, int col, List<String[]> lines) {
        for (int[] d : dir) {
            int x = d[0];
            int y = d[1];
            int dx = row + x;
            int dy = col + y;

            if (dx >= 0 && dx < lines.size() && dy >= 0 && dy < lines.get(0).length
                    && isSymbol(lines.get(dx)[dy].charAt(0))) {
                return true;
            }
        }

        return false;
    }
}