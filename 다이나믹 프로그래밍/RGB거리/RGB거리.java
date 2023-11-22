import java.util.*;
import java.io.*;
public class Main
{
    public static int[][] rgb;
    public static int[][] result;
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n=Integer.parseInt(br.readLine()); // 집의 개수
        rgb=new int[n][3];
        result=new int[n][3];
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                rgb[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<n;i++){
            if(i==0){
                for(int j=0;j<3;j++){
                    result[i][j]=rgb[i][j];
                }
            } else {
                for(int j=0;j<3;j++){
                    //올수있는 경우의 수 중에 가장 작은 것을 고른다.
                    result[i][j]=Math.min(result[i-1][(j+1)%3]+rgb[i][j],result[i-1][(j+2)%3]+rgb[i][j]);
                }
            }
        }
        
        int print=result[n-1][0]<result[n-1][1]?result[n-1][0]:result[n-1][1];
        print=print<result[n-1][2]?print:result[n-1][2];
        
        System.out.print(print);
	}
}
