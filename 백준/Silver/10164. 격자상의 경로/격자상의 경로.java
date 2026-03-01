import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k == 0) {
            System.out.println(calculate(n, m));
        } else {
            int ry = (k - 1) / m;
            int rx = (k - 1) % m;

            long first = calculate(ry + 1, rx + 1);
            long second = calculate(n - ry, m - rx);

            System.out.println(first * second);
        }
    }

    public static long calculate(int r, int c) {
        long[][] dp = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[r - 1][c - 1];
    }
}