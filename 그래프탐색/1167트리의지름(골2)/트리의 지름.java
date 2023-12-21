//모든 정점은 cycle이 없음
//두 정점간 경로는 항상 유일
//길이가 가장 긴 정점 2개 중 하나는 어떤 정점의 가장 긴 정점이다.
//즉 임의의 정점에서 가장 먼 정점을 찾으면, 그 정점은 2개 중 하나가 될 것이고
//다시 그 정점에서 가장 먼 정점을 구하면 답이 나온다.
//입력값을 받는다.
import java.io.*;
import java.util.*;
public class Main
{
	public static ArrayList<Node>[] tree;
	public static boolean visited[];
	public static int max=-1,loc;
	public static void dfs(int start,int dis){
        visited[start]=true;
        for(int i=0;i<tree[start].size();i++){
            Node tmp=tree[start].get(i);
            //값이 기존의 값보다 크면
            if(max<=dis){
                max=dis;
                loc=start;
            }
            if(!visited[tmp.x]){
                dfs(tmp.x,dis+tmp.weight);
            }
        }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       
        int v=Integer.parseInt(br.readLine());
        visited=new boolean[v+1];
        tree=new ArrayList[v+1];
        for(int i=0;i<v+1;i++){
            tree[i]=new ArrayList<>();
        }
        
        //입력부분
        for(int i=0;i<v;i++){
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());    
            int cnt=0;
            int second=0,dis=0;
            while(true){
                int destination=Integer.parseInt(st.nextToken());
                if(destination==-1) {break;}
                int dis=Integer.parseInt(st.nextToken());
                tree[first].add(new Node(destination,dis));
            }
        }

        dfs(1,0);
        int result1=max;
        max=0;
        visited=new boolean[v+1];
        dfs(loc,0);
        int result2=max;
      
        System.out.println(Math.max(result1,result2));
        
	}
	public static class Node {
	    int x;
	    int weight;
	    
	    public Node(int x,int weight){
	        this.x=x;
	        this.weight=weight;
	    }
	}
}
