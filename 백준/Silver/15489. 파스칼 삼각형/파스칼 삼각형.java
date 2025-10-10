import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int r,c,w;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr=new int[31][31];
        for (int i = 1; i < 31; i++) {
            arr[i][1]=1;
            arr[i][i]=1;
        }

        for (int i = 3; i < 30; i++) {
            for (int j = 2; j < 30; j++) {
                arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
            }
        }

        st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());

        int cnt=0;
        int result=0;
        for (int i = r; i <= r+w-1; i++) {
            for (int j = c; j <= c+cnt; j++) {
                result+=arr[i][j];
            }
            cnt++;
        }
        System.out.println(result);


    }
}