import java.util.*;
import java.io.*;
public class Main
{
    public static int result=0,n,m;
    public static int mirro[][];
    public static boolean visited[][];
    public static int dx[]={0,1,0,-1};
    public static int dy[]={1,0,-1,0};
    public static void bfs(int start_x,int start_y,int cnt){
        visited[start_y][start_x]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{start_x,start_y,cnt});
        while(!q.isEmpty()){
            int tmp[]=q.poll();
            //만약 도착했다면 결과를 리턴
            if(tmp[0]==m-1 && tmp[1]==n-1){
                result=tmp[2];
                return;
            }
            for(int i=0;i<4;i++){
                //4군데 탐색
                int x=tmp[0]+dx[i];
                int y=tmp[1]+dy[i];
                // 4방향이 배열안에 있는지 체크하고
                if(check(x,y)){
                    // 안에 있다면 1인지 확인하고 방문했는지 확인
                    if(mirro[y][x]==1 && !visited[y][x]){
                        visited[y][x]=true;
                        q.add(new int[]{x,y,tmp[2]+1});
                    }
                }
            }
        }
    }
    public static boolean check(int x,int y){
        return ((x>=0 && x<m)&&(y>=0 && y<n));
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        mirro=new int[n][m];
        visited=new boolean[n][m];
        
        for(int i=0;i<n;i++){
            String tmp=br.readLine();
            for(int j=0;j<m;j++){
                mirro[i][j]=tmp.charAt(j)-'0';
            }
        }
        
        bfs(0,0,1);
        System.out.println(result);
	}
}
