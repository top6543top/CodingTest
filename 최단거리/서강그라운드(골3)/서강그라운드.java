import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken()); // 지역의 개수
        int m=Integer.parseInt(st.nextToken()); // 수색범위
        int r=Integer.parseInt(st.nextToken()); // 길의 개수

        int item[]=new int[n+1];
        int graph[][]=new int[n+1][n+1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        
        st=new StringTokenizer(br.readLine());
        for (int i=1;i<n+1;i++) {
            item[i]=Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<r;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            graph[a][b]=c;
            graph[b][a]=c;
        }
         
        int max=0;
        // 출발 지점마다 최단거리를 구하고 가장 많이 아이템을 얻을 수 있는 방법을 찾아야 함으로 
        // 반복문을 통해 설정
        for (int i=1;i<=n;i++) {
            int result=0;
            int dis[]=new int[n+1];
            for (int j=1;j<n+1;j++) {
                dis[j]=100000000;
            }
            dis[i]=0;
            pq.offer(new int[]{i,dis[i]});
            while (!pq.isEmpty()) {
                int tmp[]=pq.poll();
                if(tmp[1]<dis[tmp[0]]) continue;
                for (int j=1;j<n+1;j++) {
                    //0이면 연결이 안되어 있는 것
                    if(graph[tmp[0]][j]!=0){
                        if(dis[j]<tmp[1]+graph[tmp[0]][j]) {
                            continue;
                        }
                        dis[j]=tmp[1]+graph[tmp[0]][j];
                        pq.offer(new int[]{j,dis[j]});
                    }
                }
            }
            
            for (int j=1;j<n+1;j++) {
                if(dis[j]<=m) result+=item[j];
            }
            if(max<result) max=result;
        }

        System.out.println(max);
    }
}
