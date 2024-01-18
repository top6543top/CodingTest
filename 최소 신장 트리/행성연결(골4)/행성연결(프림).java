import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static boolean[] visited;
    public static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        visited=new boolean[n+1];
        graph=new int[n+1][n+1];
        
        for (int i=1;i<n+1;i++) {
            st=new StringTokenizer(br.readLine());
            for (int j=1;j<n+1;j++){
                int val=Integer.parseInt(st.nextToken());
                if(val!=0){ // 0은 자기자신이므로 그래프에 저장하지 않는다.
                    graph[i][j]=val;
                    graph[j][i]=val;
                }
            }
        }
        //임의의 점을 선정하여 시작점으로 정한다.
        visited[1]=true;
        for(int i=1;i<n+1;i++){
            if(graph[1][i]!=0){
                pq.offer(new int[]{i,graph[1][i]});
            }
        }

        long result=0;
        while(!pq.isEmpty()) {
            int[] tmp=pq.poll();
            if(!visited[tmp[0]]){
                result+=(long)tmp[1];
                visited[tmp[0]]=true;
                for(int i=1;i<n+1;i++){
                    if(graph[tmp[0]][i]!=0){
                        pq.offer(new int[]{i,graph[tmp[0]][i]});
                    }
                }
            }
        }
        System.out.println(result);
    }
}
