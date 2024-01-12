import java.io.*;
import java.util.*;
public class Main
{
	public static int n,result=0;
	public static int chess[];
	public static boolean visited[];
	public static void loc_queen(int start){
	    if(start==n+1){
	        result++;
	        return;
	    }
	    
	    for(int i=1;i<=n;i++){
	       chess[start]=i;
	       if(atk_queen(start)){
	            loc_queen(start+1);
	       }
	    }
	}
	public static boolean atk_queen(int x){
	    for(int i=1;i<x;i++){
	       //일직선 구간 검사
	       if(chess[i]==chess[x]) return false;
	     
	        //대각선 구간 검사
            if(Math.abs(i-x)==Math.abs(chess[i]-chess[x])){
                return false;
            }
	    }
	    
	    return true;
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        chess=new int[n+1];
        visited=new boolean[n+1];
        loc_queen(1);
        System.out.print(result);
	}   
}
