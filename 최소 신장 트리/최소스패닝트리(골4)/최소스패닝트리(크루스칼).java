import java.io.*;
import java.util.*;
public class Main
{
	public static int v,e; //v는 정점 e는 간선의 개수
	public static PriorityQueue<Node> pq;
	public static int arr[];
	public static int result;//가중치의 합
   	public static boolean union(int x,int y){
	    int tmp_x=find(x);
	    int tmp_y=find(y);
	    
	    if(tmp_x==tmp_y) return false;

        if(tmp_y>tmp_x) arr[tmp_y]=tmp_x;
        else arr[tmp_x]=tmp_y;
	    
	    return true;
	}
    public static int find(int x) {
        if (arr[x] == x) return x;
        return find(arr[x]);
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        
        arr=new int[v+1];
        for(int i=1;i<v+1;i++){
            arr[i]=i;
        }
        pq=new PriorityQueue<>();
        
        for(int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());
            int node1=Integer.parseInt(st.nextToken());
            int node2=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            pq.add(new Node(node1,node2,weight));
        }
        
        int cnt=0;
        while(cnt<v-1){
            Node tmp=pq.poll();
            if(union(tmp.x,tmp.y)){
                result+=tmp.weight;
                cnt++;
            }
        }
 
        System.out.println(result);
	}
	public static class Node implements Comparable<Node>{
	    int x;
	    int y;
	    int weight;
	    
	    public Node(int x,int y,int weight){
	        this.x=Math.min(x,y);
	        this.y=Math.max(x,y);
	        this.weight=weight;
	    }
	    //추상클래스를 상속받았으므로 compareTo를 무조건 구현해주어야 한다.
	    @Override
	    public int compareTo(Node other){
	        return this.weight-other.weight;
	        // 오름차순일때
	    }
	}
}
