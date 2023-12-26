import java.io.*;
import java.util.*;
public class Main
{
    public static int n,m; // 노드의 수, 간선의 수
    public static int num[];
    // 그래프 연결
    public static ArrayList<Node>[] graph;
    public static boolean visited[];
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        
        visited=new boolean[n+1];
        PriorityQueue<Node> pq=new PriorityQueue<>();
        graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            if(a!=b){
                graph[a].add(new Node(b,c));
                graph[b].add(new Node(a,c));
            }
        }
        
        //임의의 점을 시작지점으로 정한다.
        for(int i=0;i<graph[1].size();i++){
            pq.offer(graph[1].get(i));
        }
        visited[1]=true;
        
        int cnt=1,result=0;
        while(cnt<n){
            Node tmp=pq.poll();
            if(!visited[tmp.b]){
                result+=tmp.cost;
                for(int i=0;i<graph[tmp.b].size();i++){
                    pq.offer(graph[tmp.b].get(i));
                }
                visited[tmp.b]=true;
                cnt++;
            }
        }
        
        System.out.println(result);
	}
	public static class Node implements Comparable<Node>{
	    int b;
	    int cost;
	    public Node(int b,int cost){
	        this.b=b;
	        this.cost=cost;
	    }
	    
	    @Override
	    public int compareTo(Node node){
	        return this.cost-node.cost;
	    }
	}
}
