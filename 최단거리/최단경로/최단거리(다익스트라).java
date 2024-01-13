import java.io.*;
import java.util.*;
public class Main
{
    public static int n,e,MAX=1000000; // 정점, 간선의 개수
    public static int ess1,ess2;
    public static int dis[];
    public static PriorityQueue<Node> pq;
    public static ArrayList<Node> graph[];
    public static void find_root(int start){
        dis[start]=0;
        pq.offer(new Node(start,dis[start]));
        
        while(!pq.isEmpty()){
            Node tmp=pq.poll();
            if(tmp.cost!=dis[tmp.x]) continue;
            for(int i=0;i<graph[tmp.x].size();i++){
                Node nxt=graph[tmp.x].get(i);
                if(dis[nxt.x]<tmp.cost+nxt.cost) continue;
                dis[nxt.x]=tmp.cost+nxt.cost;
                pq.offer(new Node(nxt.x,dis[nxt.x]));
            }
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        
        dis=new int[n+1];
        for(int i=0;i<n+1;i++){
            dis[i]=MAX;
        }
        pq=new PriorityQueue<>();
        graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }
        
        st=new StringTokenizer(br.readLine());
        ess1=Integer.parseInt(st.nextToken());
        ess2=Integer.parseInt(st.nextToken());
        
        int result=0;
        int ess1_start,ess1_last;
        int ess2_start,ess2_last;
        
        find_root(ess1);
        //필수 방문 점끼리의 최소거리를 먼저 구한다.
        if(dis[ess2]==MAX){
            System.out.println(-1);
            return;
        } else {
            result+=dis[ess2];
        }
        
        ess1_last=dis[n];
        ess1_start=dis[1];
        
        for(int i=0;i<n+1;i++){
            dis[i]=MAX;
        }
        
        find_root(ess2);
        
        ess2_last=dis[n];
        ess2_start=dis[1];

        //start지점과 last지점에 가는 길이 없다면 -1 출력
        if(ess2_start==MAX && ess1_start==MAX){
            System.out.println(-1);
            return;
        }
        if(ess2_last==MAX && ess1_last==MAX){
            System.out.println(-1);
            return;
        }
        // 시작점과 마지막점으로 가는길이 더 작은 것으로 더해준다.
        if(ess1_start+ess2_last>ess2_start+ess1_last){
            result+=ess2_start+ess1_last;
        } else {
            result+=ess1_start+ess2_last;
        }
        
        System.out.println(result);
	}
	static class Node implements Comparable<Node>{
	    int x;
	    int cost;
	    
	    Node(int x,int cost){
	        this.x=x;
	        this.cost=cost;
	    }
	    
	    @Override
	    public int compareTo(Node other){
	        return this.cost-other.cost;
	    }
	}
}
