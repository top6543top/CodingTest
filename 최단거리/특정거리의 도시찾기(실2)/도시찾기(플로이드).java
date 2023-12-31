import java.io.*;
import java.util.*;
public class Main
{
	public static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken()); // 도시 개수
        int m=Integer.parseInt(st.nextToken()); // 길의 개수
        int k=Integer.parseInt(st.nextToken()); // 최단 거리
        int x=Integer.parseInt(st.nextToken()); // 출발 도시
        
        int dis[][]=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==j){
                    dis[i][i]=0;
                } else {
                    dis[i][j]=1000000;
                }
            }
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph[a].add(b);
            dis[a][b]=1;
        }
        
        for(int z=1;z<n+1;z++){
            for(int i=1;i<n+1;i++){ //출발점
                for(int j=1;j<n+1;j++){// 도착점
                    dis[i][j]=Math.min(dis[i][j],dis[i][z]+dis[z][j]);
                }
            }
        }

        ArrayList<Integer> result=new ArrayList<>();
        for(int i=1;i<n+1;i++){
            if(dis[x][i]==k) result.add(i);
        }
        
        if(result.size()==0){
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for(int i=0;i<result.size();i++){
                System.out.println(result.get(i));
            }
        }
              
	}
}
