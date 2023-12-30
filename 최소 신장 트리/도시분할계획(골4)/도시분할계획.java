import java.io.*;
import java.util.*;
public class Main
{
	public static int n,m,result;
	public static int arr[];
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken()); // 정점의 개수
        m=Integer.parseInt(st.nextToken()); // 간선의 개수
        
        arr=new int[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=i;
        }
        
        PriorityQueue<Node> pq=new PriorityQueue<>();
        
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            pq.offer(new Node(x,y,cost));
        }
        
        int max=-1;
        while(!pq.isEmpty()){
            Node tmp=pq.poll();
            if(union(tmp.x,tmp.y)){
                result+=tmp.cost;
                max=Math.max(max,tmp.cost);
            }
        }
        
        System.out.println(result-max);
	}
	public static boolean union(int x,int y){
	    x=find(x);
	    y=find(y);
	    
	    if(x==y) return false;
	    if(x>y) arr[x]=y;
	    else arr[y]=x;
	    
	    return true;
	}
	public static int find(int num){
	    if(arr[num]==num) return num;
	    return find(arr[num]);
	}
	public static class Node implements Comparable<Node>{
	    int x;
	    int y;
	    int cost;
	    
	    Node(int x,int y,int cost){
	        this.x=x;
	        this.y=y;
	        this.cost=cost;
	    }
	    
	    @Override
	    public int compareTo(Node other){
	        return this.cost-other.cost;
	    } 
	}
}
