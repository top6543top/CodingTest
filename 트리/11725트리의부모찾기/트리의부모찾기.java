import java.io.*;
import java.util.*;
public class Main
{
	public static ArrayList<ArrayList<Integer>> tree;
	public static boolean visited[];
	public static int parents[];
	public static void dfs(int start){
	    visited[start]=true;
	    
	    for(int i=0;i<tree.get(start).size();i++){
	        if(!visited[tree.get(start).get(i)]){
	            parents[tree.get(start).get(i)]=start;
	            dfs(tree.get(start).get(i));
	        }
	    }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;        
        
        int n=Integer.parseInt(br.readLine());
        
        tree=new ArrayList<>();
        for(int i=0;i<n+1;i++) {tree.add(new ArrayList<>());}
        
        //그래프로 연결
        for(int i=1;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
     
        visited=new boolean[n+1];
        parents=new int[n+1];
        for(int i=1;i<n+1;i++){
            visited[i]=false;
        }
        dfs(1);
        StringBuilder sb=new StringBuilder();
        for(int i=2; i<=n; i++) {
			sb.append(parents[i]).append('\n');
		}
        System.out.println(sb);
	}
}
