import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class day03try3p2{
    private static final List<int[]> dir = new ArrayList<>(List.of(
            new int[] { 1, 1 },
            new int[] { 1, 0 },
            new int[] { 1, -1 },
            new int[] { 0, -1 },
            new int[] { -1, -1 },
            new int[] { -1, 0 },
            new int[] { -1, 1 },
            new int[] { 0, 1 }));

    static boolean isSymbol(char ch) {
        return !Character.isDigit(ch) && ch != '.';
    }

    static boolean isEnginePart(int row, int col, int num, List<String[]> lines,
            Map<List<Integer>, List<Integer>> gears) {
        for (int[] d : dir) {
            int x = d[0];
            int y = d[1];
            int dx = row + x;
            int dy = col + y;

            if (dx >= 0 && dx < lines.size() && dy >= 0 && dy < lines.get(0).length && lines.get(dx)[dy].equals("*")) {
                List<Integer> key = Arrays.asList(dx, dy);
                List<Integer> gearList = gears.getOrDefault(key, new ArrayList<>());
                gearList.add(num);
                gears.put(key, gearList);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int res = 0;
        Map<List<Integer>, List<Integer>> gears = new HashMap<>();

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
                    int parsedNum = Integer.parseInt(num.toString());
                    // check if it is engine part
                    for (int k = i; k < j; k++) {
                        if (isEnginePart(row, k, parsedNum, lines, gears)) {
                            break;
                        }
                    }
                    // update i and j
                    i = j;
                }

                row++;
            }
            for (Map.Entry<List<Integer>, List<Integer>> entry : gears.entrySet()) {
                List<Integer> numList = entry.getValue();
                if (numList.size() == 2) {
                    int product = 1;
                    for (int n : numList) {
                        product *= n;
                    }
                    res += product;
                }
            }

            System.out.println("Answer: " + res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}