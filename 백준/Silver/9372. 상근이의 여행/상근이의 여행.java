import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[n+1];
            ArrayList<Integer>[] graph = new ArrayList[n+1];
            for(int j=0;j<n+1;j++){
                graph[j]=new ArrayList<>();
            }

            for(int j=0;j<m;j++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            int result=bfs(graph, visited);
            sb.append(result-1).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static int bfs(ArrayList<Integer>[] graph, boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        visited[1]=true;

        int result=0;
        while(!q.isEmpty()){
            int tmp = q.poll();
            result++;

            for(int i : graph[tmp]){
                if(!visited[i]){
                    //System.out.println("tmp : " + tmp + ", i : "+i);
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }
        return result;
    }
}