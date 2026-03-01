import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[][]=new int[n][m];
        int dp[][]=new int[n][m];

        int cnt=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j]=cnt++;
            }
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (k==0){
            for (int i = 1; i < n; i++) { // 3
                for (int j = 1; j < m; j++) { // 2
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            System.out.println(dp[n-1][m-1]);
        } else {
            int splitx = k % m;
            int splity = k / m;
            for (int i = 1; i <= splity; i++) { // 3
                for (int j = 1; j < splitx; j++) { // 2
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

            for (int i = splity+1; i < n; i++) {
                dp[i][splitx-1] = 1;
            }
            for (int i = splitx; i < m; i++) {
                dp[splity][i] = 1;
            }

            for (int i = splity+1; i < n; i++) { // 3
                for (int j = splitx; j < m; j++) { // 2
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            System.out.println(dp[splity][splitx-1] * dp[n-1][m-1]);
        }



    }
}