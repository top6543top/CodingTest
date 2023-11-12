import java.io.*;
import java.util.*;
public class Main
{
    // a배열은 뽑힌 숫자가 들어가는 배열
	public static int a[];
	// 그 숫자를 방문했는지 확인하는 배열
	public static boolean visited[];
	public static StringBuilder sb;
	public static void backTracking(int n,int m,int k){
	   if(k==m){ // m개의 숫자를 다뽑았으면 함수 탈출
	       for(int i=0;i<m;i++){
	           sb.append(a[i]+" ");
	       }
	       sb.append("\n");
	       return;
	   }
	   for(int i=1;i<=n;i++){
	       if(!visited[i]){ // 숫자를 방문하지 않았으면
	           a[k]=i;  // 배열에 숫자를 집어 넣고
	           visited[i]=true; // 방문 처리
	           backTracking(n,m,k+1); // k를 증가시켜서 다음 숫자 뽑기
	           visited[i]=false; 
	           // 이미 i번째 숫자가 방문한 작업을 재귀를 통해 완료 했을 것이므로 값 초기화 
	       }
	   }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        sb=new StringBuilder();
        a=new int[N];
        visited=new boolean[N+1];
        backTracking(N,M,0);
        
        System.out.print(sb);
	}
}
