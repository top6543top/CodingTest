import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());

        long arr[]=new long[n+1];
        long copy[]=new long[n+1];
        
        st=new StringTokenizer(br.readLine());
        for (int i=1;i<n+1;i++) {
            arr[i]=Long.parseLong(st.nextToken());
            copy[i]=-1;
        }
        
        for (int i=2;i<n+1;i++) {
            for(int j=i-1;j>0;j--){
                //전 칸에서 넘어올때의 값을 정하는 변수 tmp
                // ex) 3->2로 넘어올때 필요한 힘의 크기가 tmp다
                // 만약 3,2로 넘어올때의 힘 3이 들었고 2,1에서 들었던 힘이 4가 들었으면 상한선이 3,2로 오는 힘은 최소 4가 되야한다.
                long tmp=Math.max( (i-j)*(1+Math.abs(arr[j]-arr[i])), copy[j]);
                // 다른 곳에서 넘어오는 것중 최소를 구하는 것
                if(copy[i]==-1){
                    copy[i]=tmp;
                } else{
                    copy[i]=Math.min(tmp,copy[i]);
                }
            }
        }

        
        System.out.println(copy[n]);
    }
}
