import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int result;
    static int MAX=1000000009;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        long arr[]=new long[100001];
        long dp[]=new long[100001];

        //숫자의 배열을 구한다.
        arr[0]=1; arr[1]=1; arr[2]=2; arr[3]=4;
        for (int i=4;i<100001;i++) {
            arr[i]=(arr[i-3]%MAX+arr[i-2]%MAX+arr[i-1]%MAX)%MAX;
        }

        
        // 숫자 배열 + 1 + 숫자배열 ....
        // 숫자 배열 + 1 1 + 숫자배열 ... 
        // 이런식으로 생각해서 문제를 해결했다.
        dp[1]=1; dp[2]=2; dp[3]=2;
        for (int i=4;i<100001;i++) {
            for (int j=1;j<=3;j++) {
                if(i-2*j>=0 && (i-2*j)%2==0){
                    dp[i]=(dp[i]%MAX+arr[(i-2*j)/2]%MAX)%MAX;
                }// 1 1
                if(i-j>=0 && (i-j)%2==0){
                    dp[i]=(dp[i]%MAX+arr[(i-j)/2]%MAX)%MAX;
                }
            }
        }
        
        for (int i=0;i<t;i++) {
            int input=Integer.parseInt(br.readLine());
            sb.append(dp[input]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
