import java.io.*;
import java.util.*;
public class Main
{
	public static int arr[];
	public static boolean visited[];
	public static StringBuilder sb;
	public static int N,M;
	public static void backTracking(int k,int prev){
	    if(k==M){
	        for(int i=0;i<M;i++){
	            sb.append(arr[i]+" ");
	        }
	        sb.append("\n");
	        return;    
	    }
	    for(int i=1;i<=N;i++){
        // N과 M(1)에서 오름차순 조건만 추가
	        if(!visited[i] && i>prev){
	            prev=i;
	            arr[k]=i;
	            visited[i]=true;
	            backTracking(k+1,i);
	            visited[i]=false;
	        }
	    }
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    
	    arr=new int[M];
	    visited=new boolean[N+1];
	    sb=new StringBuilder();
	    
	    backTracking(0,0);
	    System.out.println(sb);
	    
	}
}
