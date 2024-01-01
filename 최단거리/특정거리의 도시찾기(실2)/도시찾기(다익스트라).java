import java.io.*;
import java.util.*;
public class Main
{
    // 다익스트라 알고리즘
    public static final int MAX = 100_000_000;
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken()); // 도시개수
        int m=Integer.parseInt(st.nextToken()); // 도로개수
        int k=Integer.parseInt(st.nextToken()); // 거리정보
        int x=Integer.parseInt(st.nextToken()); // 출발도시
        
        //---------- 변수 선언부 -----------
        int dis[]=new int[n+1];
        for(int i=0;i<n+1;i++){
            dis[i]=MAX;
        }
        
        ArrayList<Integer>[] graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        
        PriorityQueue<Node> pq=new PriorityQueue<>();
        // ----------------------------------
        
        // 입력받기
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        
        //초기값 집어넣는다.
        dis[x]=0;
        pq.offer(new Node(x,dis[x]));
        
        while(!pq.isEmpty()){
            Node tmp=pq.poll();
            //뽑은 값이 최단거리 테이블에 들어와있는 값과 다르면 무시
            if(tmp.cost!=dis[tmp.y]) continue;
            
            for(int i=0;i<graph[tmp.y].size();i++){
                int nxt=graph[tmp.y].get(i);
              // 기존의 있는 값이 뽑은 노드의 값에서 가중치가 더해진 값보다 작다면 방문처리
                if(dis[nxt]<tmp.cost+1) continue;
                dis[nxt]=tmp.cost+1;
                pq.offer(new Node(nxt,tmp.cost+1));
            }
        }
        
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=1;i<n+1;i++){
            if(dis[i]==k) result.add(i); 
        }
        if(result.size()==0){
            System.out.println(-1);
            return;
        }
        Collections.sort(result);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<result.size();i++){
            sb.append(result.get(i)+"\n");
        }
        System.out.print(sb);
	}
	public static class Node implements Comparable<Node>{
	    int y;
	    int cost;
	    public Node(int y,int cost){
	        this.y=y;
	        this.cost=cost;
	    }
	    
	    @Override
	    public int compareTo(Node Other){
	        return this.cost-Other.cost;
	    }
	}
}
