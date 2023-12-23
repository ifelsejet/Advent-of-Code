import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day03try2 {

    public static void main(String[] args) {
        int ans = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\PC\\\\Documents\\\\GitHub\\\\Advent-of-Code\\\\2023\\\\Day_03\\\\pauloInput.txt"))) {
            String data;
            StringBuilder sb = new StringBuilder();

            while ((data = br.readLine()) != null) {
                sb.append(data).append("\n");
            }

            String[] lines = sb.toString().trim().split("\n");
            int n = lines.length;
            int m = lines[0].length();

            for (int i = 0; i < n; i++) {
                int start = 0;
                int j = 0;

                while (j < m) {
                    start = j;
                    StringBuilder numBuilder = new StringBuilder();

                    while (j < m && Character.isDigit(lines[i].charAt(j))) {
                        numBuilder.append(lines[i].charAt(j));
                        j++;
                    }

                    String numStr = numBuilder.toString();

                    if (numStr.isEmpty()) {
                        j++;
                        continue;
                    }

                    int num = Integer.parseInt(numStr);

                    // Number ended, look around
                    if (isSymbol(lines, i, start - 1) || isSymbol(lines, i, j)) {
                        ans += num;
                        continue;
                    }

                    for (int k = start - 1; k <= j + 1; k++) {
                        if (isSymbol(lines, i - 1, k) || isSymbol(lines, i + 1, k)) {
                            ans += num;
                            break;
                        }
                    }
                }
            }

            System.out.println(ans);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isSymbol(String[] lines, int i, int j) {
        int n = lines.length;
        int m = lines[0].length();

        return 0 <= i && i < n && 0 <= j && j < m && lines[i].charAt(j) != '.' && !Character.isDigit(lines[i].charAt(j));
    }
}
