import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int t;
    static boolean arr[];
    static boolean visited[];
    public static int finger_snap(int n,int a,int b){
        /*
        전 우주의 생명체 수를 현재의 절반으로 한다.
        전 우주의 생명체 수를 현재의 1/3로 한다.
        (위의 두 경우에서, 나누어 떨어지지 않으면 몫만 남기고, 나머지는 버린다.)
        전 우주의 생명체 수를 현재보다 하나 늘린다.
        전 우주의 생명체 수를 현재보다 하나 줄인다.
        (이미 전 우주의 생명체 수가 0이라면 할 수 없다.)
        */
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{n,0});
        visited[n]=true;
        
        while (!q.isEmpty()) {
            int num[]=q.poll();

            if(arr[num[0]] && num[0]>=a && num[0]<=b){
                return num[1];
            }
            
            for (int i=0;i<4;i++) {
                int nxt_num=num[0];
                switch (i) {
                    case 0:
                        nxt_num+=1;
                        break;
                    case 1:
                        nxt_num-=1;
                        break;
                    case 2:
                        nxt_num/=2;
                        break;
                    case 3:
                        nxt_num/=3;
                        break;
                }

                if(nxt_num<=1_000_000 && nxt_num>=0 && !visited[nxt_num]){
                    visited[nxt_num]=true;
                    q.offer(new int[]{nxt_num,num[1]+1});
                }
            }
            
        }

        return -1;
    }
       
        
    public static void make_Prime(){
        arr=new boolean[1_000_001];
        for (int i=2;i<=1_000_000;i++) {
            arr[i]=true;
        }

        for (int i=2;i<=Math.sqrt(1_000_000);i++) {
            if(arr[i]){
                for (int j=i*i;j<=1_000_000;j+=i) {
                    arr[j]=false;
                }
            }
        }
    }
        
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
       
        make_Prime();

        t=Integer.parseInt(br.readLine());
        for (int k=0;k<t;k++) {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            visited=new boolean[1000001];
            
            sb.append(finger_snap(n,a,b)+"\n");
        }
        System.out.println(sb.toString());
    }
}
