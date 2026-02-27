import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a[]=new int[n];
        int b[]=new int[n];
        Arrays.fill(b,Integer.MAX_VALUE);
        b[0]=0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<n;i++){
            for (int j = i+1; j <= i+a[i]; j++) {
                if(j >= n) continue;
                if (b[i] == Integer.MAX_VALUE) continue;
                int min = Math.min(b[j],b[i]+1);
                if(min == b[i]+1){
                    b[j]=b[i]+1;
                }
            }
        }

        if (b[n-1]==Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(b[n-1]);
        }

    }
}