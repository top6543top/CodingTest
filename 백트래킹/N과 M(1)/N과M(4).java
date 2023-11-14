import java.util.*;
import java.io.*;
public class Main
{
	public static int n,m;
	public static int arr[];
	public static boolean visited[];
	public static StringBuilder sb;
	public static int prev=0;
	public static void backTracking(int k){
	    if(k==m){
	        prev=0;
	        for(int i=0;i<m;i++){
	            sb.append(arr[i]+" ");
	        }
	        sb.append("\n");
	        return;
	    }
	    for(int i=1;i<=n;i++){
	       arr[k]=i;
	       if(arr[prev]<=arr[k]){
           //중복된것을 포함하지 않는다고 하였으므로
	           prev=k;
        	   backTracking(k+1);
	       }
	    }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[m];
        visited=new boolean[n+1];
        
        backTracking(0);
        
        System.out.print(sb);
	}
}
