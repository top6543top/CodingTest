import java.io.*;
import java.util.*;
public class Main
{
    public static int n,m; // 노드의 수, 간선의 수
    public static int num[];
    public static ArrayList<int[]>[] graph;
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        
        num=new int[n+1];
        for(int i=1;i<n+1;i++){
            num[i]=i;
        }
        
        PriorityQueue<Node> pq=new PriorityQueue<>();
        
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            if(a!=b){
                pq.offer(new Node(a,b,c));
            }
        }
        int result=0;
        while(!pq.isEmpty()){
            Node tmp=pq.poll();
            if(union(tmp.a,tmp.b)){
                result+=tmp.cost;
            }
        }
        System.out.println(result);
	}
	public static boolean union(int x,int y){
	    x=find(x);
	    y=find(y);
	    
	    if(x==y) return false;
	    
	    if(x>=y) num[x]=y;
	    else num[y]=x;
	    return true;
	}
    public static int find(int x){
        if(num[x]==x) return x;
        else return find(num[x]);
    }
	public static class Node implements Comparable<Node>{
	    int a;
	    int b;
	    int cost;
	    public Node(int a,int b,int cost){
	        this.a=Math.min(a,b);
	        this.b=Math.max(a,b);
	        this.cost=cost;
	    }
	    
	    @Override
	    public int compareTo(Node node){
	        return this.cost-node.cost;
	    }
	}
}
