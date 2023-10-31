///https://www.acmicpc.net/problem/17073
import java.util.*;
import java.io.*;
public class Main
{
    public static ArrayList<Integer>[] tree;
    public static boolean visited[];
    public static double floor[];
    public static double result=0;
    public static int cnt=0,n,w;
    
    public static void dfs(int start){
        visited[start]=true;
        if(start!=1 && tree[start].size()==1){
            cnt++;
            result+=(floor[start]*w);
        }
        for(int i=0;i<tree[start].size();i++){
            int a=tree[start].get(i);
            if(!visited[a]){
                //부모노드랑 자식노드 계산 방법이다름
                if(start==1){floor[a]=floor[start]/tree[start].size();}
                else{floor[a]=floor[start]/(tree[start].size()-1);};
                dfs(a);
            }
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        
        tree=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            tree[i]=new ArrayList<>();
        }
        visited=new boolean[n+1];
        floor=new double[n+1];
        for(int i=0;i<n+1;i++){
            floor[i]=1;
        }
        
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        
        dfs(1);
        result=result/cnt;
        System.out.println(result);
	}
}
