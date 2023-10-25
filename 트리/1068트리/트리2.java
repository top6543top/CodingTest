import java.io.*;
import java.util.*;
public class Main
{
    public static ArrayList<ArrayList<Integer>> t;
    public static boolean visited[];
    public static int remove,result=0;
	public static void dfs(int start){
	    if(start==remove) return;
	    
	    visited[start]=true;
	    if(t.get(start).size()==1) result++;
	    
	    for(int i=0;i<t.get(start).size();i++){
	        int tmp=t.get(start).get(i);
	        if(visited[tmp]==false) dfs(tmp);
	    }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n=Integer.parseInt(br.readLine()); // 노드의 개수
        t=new ArrayList<>();
        for(int i=0;i<n;i++) t.add(new ArrayList<>());
        visited=new boolean[n];
        
        int flag=-1,start=0;
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int a=Integer.parseInt(st.nextToken());
            flag++;
            if(a==-1){
                start=flag;
                continue;
            } else {
                t.get(flag).add(a);
                t.get(a).add(flag);
            }
        }
        
        remove=Integer.parseInt(br.readLine());
        dfs(start);
        
        System.out.println(result);
	}
}
