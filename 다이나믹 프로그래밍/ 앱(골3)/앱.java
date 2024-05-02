import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M; // N -> 앱의 개수 , M -> 확보해야하는 메모리
    static int An[]; // 어플이 쓰고 있는 메모리의 수
    static int Cn[]; // 비활성화 비용
    static int dp[][];
    static int result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        An=new int[N+1];
        Cn=new int[N+1];
        
        
        st=new StringTokenizer(br.readLine());
        for (int i=1;i<N+1;i++) {
            An[i]=Integer.parseInt(st.nextToken());
        }
        
        int plus=0;
        st=new StringTokenizer(br.readLine());
        for (int i=1;i<N+1;i++) {
            Cn[i]=Integer.parseInt(st.nextToken());
            plus+=Cn[i];
        }

        // 비용을 기준으로 배낭문제 알고리즘 시행
        dp=new int[N+1][plus+1];
        for (int i=1;i<N+1;i++) {
            for (int j=0;j<plus+1;j++) {
                if(Cn[i]<=j){
                    // 무게를 비교했을때 전에것이 무거우면 전에 비용을 가져오고
                    // 아니라면 자신의 비용에서 뺀 것의 무게 + 자신의 무게를 고른다
                    dp[i][j]=Math.max( dp[i-1][j] , dp[i-1][j-Cn[i]]+An[i] );
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        // 처음으로 M을 넘는 비용이 나온다면 그 값이 정답
        int result=0;
        find: for(int j=0;j<plus+1;j++) {
            for (int i=1;i<N+1;i++) {
                if(dp[i][j]>=M){
                    result=j;
                    break find;
                } 
            }
        }
        
        System.out.println(result);
    }
}
