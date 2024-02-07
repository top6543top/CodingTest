import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int t,n;
    public static int dx[]={-1,0,1,0,0};
    public static int dy[]={0,-1,0,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        
        t=Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++) {
            n=Integer.parseInt(br.readLine());
            int arr[][]=new int[2][n];
            int c_arr[][]=new int[2][n];
            for (int j=0;j<2;j++) {
                st=new StringTokenizer(br.readLine());
                for (int k=0;k<n;k++) {
                    int tmp=Integer.parseInt(st.nextToken());
                    arr[j][k]=tmp;
                }
            }
            c_arr[0][0]=arr[0][0];
            c_arr[1][0]=arr[1][0];
            for (int j=1;j<n;j++) {
                if(j==1){
                  // 1일때는 전에 것만 비교
                    c_arr[0][j]=c_arr[1][0]+arr[0][j];
                    c_arr[1][j]=c_arr[0][0]+arr[1][j];
                } else {
                  // 그 이후일때는 대각선 2개까지 비교
                    c_arr[0][j]=Math.max(c_arr[1][j-1],c_arr[1][j-2])+arr[0][j];
                    c_arr[1][j]=Math.max(c_arr[0][j-1],c_arr[0][j-2])+arr[1][j];
                }
            }
            int max=-1;
            for (int j=0;j<2;j++) {
                for (int k=0;k<n;k++) {
                    max=Math.max(max,c_arr[j][k]);
                }
            }
            sb.append(max+"\n");
        }
        System.out.println(sb);
    }
}
