import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MOD = 9901;
		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N + 1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1; 

		for (int i = 2; i <= N; i++) {
            // 0은 사자가 그 줄에 없는것
            // 1은 사자가 첫번째 칸에 있는것
            // 2는 사자가 두번째 칸에 있는것

            //사자가 두칸다 없으려면 전에 어떤 것이든 상관없다
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            // 1번째 칸에 사자가 있으려면 1칸에만 사자가 없으면 된다.
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            // 2번째 칸에 사자가 있으려면 2칸에만 사자가 없으면 된다.
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
		}

        //마지막 경우의 수를 다 더해주면 된다.
		long ans = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
