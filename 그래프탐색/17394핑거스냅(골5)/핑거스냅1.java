import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int t;
    static int arr[];
    static int dp[];
    static int cal[]={-1,1,2,3};
    public static int finger_snap(int n,int a,int b){
        /*
        전 우주의 생명체 수를 현재의 절반으로 한다.
        전 우주의 생명체 수를 현재의 1/3로 한다.
        (위의 두 경우에서, 나누어 떨어지지 않으면 몫만 남기고, 나머지는 버린다.)
        전 우주의 생명체 수를 현재보다 하나 늘린다.
        전 우주의 생명체 수를 현재보다 하나 줄인다.
        (이미 전 우주의 생명체 수가 0이라면 할 수 없다.)
        */


        if(n>=a && n<=b && arr[n]==0) {
            return 0;
        }
        
        dp=new int[1_000_001];
        dp[n]=0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(n);
        
        while (!q.isEmpty()) {
            int num=q.poll();
            
            for (int i=0;i<4;i++) {
                int tmp=0;
                if(i<2){
                    tmp=num+cal[i];
                    if((tmp>=0 && tmp<=1000000) && dp[tmp]==0){
                        dp[tmp]=dp[num]+1;
                        q.offer(tmp);
                    }
                } else {
                    tmp=num/cal[i];
                    if((tmp>=0 && tmp<=1000000) && dp[tmp]==0){
                        dp[tmp]=dp[num]+1;
                        q.offer(tmp);
                    }
                }
            }
        }

        int result=Integer.MAX_VALUE;
        for (int i=a;i<=b;i++) {
            if(arr[i]==0){
                result=Math.min(result,dp[i]);
            }
        }

        if(result==Integer.MAX_VALUE) return -1;
        return result;
    }
       
        

        
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        arr=new int[100_001];
        arr[0]=1; arr[1]=1; // 소수가 아님
        for (int i=2;i<=Math.sqrt(100_000);i++) {
            if(arr[i]==0){
                for (int j=i*i;j<=100_000;j+=i) {
                    arr[j]=1;
                }
            }
        }

        t=Integer.parseInt(br.readLine());
        for (int k=0;k<t;k++) {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            
            sb.append(finger_snap(n,a,b)+"\n");
        }
        System.out.println(sb.toString());
    }
}
