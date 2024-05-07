import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        int arr[][]=new int[n+1][n+1];
        int dp[][][]=new int[3][n+1][n+1];//가로 , 세로, 대각선

        for (int i=1;i<n+1;i++) {
            st=new StringTokenizer(br.readLine());
            for (int j=1;j<n+1;j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][2]=1;
        for (int i=1;i<n+1;i++) {
            for (int j=3;j<n+1;j++) {
                if(arr[i][j]==1) continue;
                //가로의 개수는 전의 것의 가로 + 대각선이다.
                dp[0][i][j]=dp[0][i][j-1]+dp[2][i][j-1];
                //세로일 때의 개수는 세로 + 대각선이다
                //위의 칸이 없으면 세로를 할 수 없으므로 1일 경우와 아닌경우를 나누어준다.
                if(i==1){
                    dp[1][i][j]=0;
                } else {
                    dp[1][i][j]=dp[1][i-1][j]+dp[2][i-1][j];
                }
                
                // 대각선이 되는 조건을 체크해준다.
                if(arr[i-1][j]==1 || arr[i][j-1]==1) continue;
                // 대각선의 개수는 대각선+가로+세로이므로 첫째줄 빼고 계산을 해준다
                if(i==1){
                    dp[2][i][j]=0;
                } else {
                    dp[2][i][j]=dp[0][i-1][j-1]+dp[1][i-1][j-1]+dp[2][i-1][j-1];
                }
            }
        }
        
        System.out.println(dp[0][n][n]+dp[1][n][n]+dp[2][n][n]);
    }
}
