import java.io.*;
import java.util.*;
public class Main
{
	public static int v,e; //v는 정점 e는 간선의 개수
	public static ArrayList<int[]>[] graph; //[0]이 정점 [1]이 가중치
	public static boolean visited[];
	public static int result;//가중치의 합
	public static void find_Mst(int start){
	    PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
	    //가중치 오름차순으로 정렬
	    
	    for(int i=0;i<graph[start].size();i++){
	        pq.offer(graph[start].get(i));
	    }
	    visited[start]=true;
	    while(!pq.isEmpty()){
	        int tmp[]=pq.poll();
	        //방문하지 않았으면
	        if(!visited[tmp[0]]){
	            visited[tmp[0]]=true;
	            result+=tmp[1];
	            for(int i=0;i<graph[tmp[0]].size();i++){
	                pq.offer(graph[tmp[0]].get(i));
	            }
	        }
	    }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        
        visited=new boolean[v+1];
        graph=new ArrayList[v+1];
        for(int i=0;i<v+1;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());
            int node1=Integer.parseInt(st.nextToken());
            int node2=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            graph[node1].add(new int[]{node2,weight});
            graph[node2].add(new int[]{node1,weight});
        }
          
        find_Mst(1);
        System.out.println(result);
	}
}
