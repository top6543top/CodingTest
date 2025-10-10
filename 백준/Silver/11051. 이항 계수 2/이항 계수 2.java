import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int n,k;
    public static int DIVIDE_NUM = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        arr=new int[n+2][n+2];
        for (int i = 0; i <= n; i++) {
            arr[i][0]=1;
            arr[i][i]=1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j]=(arr[i-1][j]%DIVIDE_NUM+arr[i-1][j-1]%DIVIDE_NUM)%DIVIDE_NUM;
            }
        }

        /*for (int i = 0; i <= n+1; i++) {
            for (int j = 0; j <= n+1; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }*/

        System.out.println(arr[n][k]%DIVIDE_NUM);
    }
}