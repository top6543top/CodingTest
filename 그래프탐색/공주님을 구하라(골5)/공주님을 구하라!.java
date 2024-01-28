import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n,m,t,cnt;
    static int arr[][];
    static boolean visited[][];
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static boolean check(int y,int x){
        if(x<0 || y<0 || x>=m || y>=n) return false;
        if(arr[y][x]==1) return false;
        return true;
    }
    public static int no_Gram_bfs(int start_y,int start_x,int last_y,int last_x){
        visited[start_y][start_x]=true;
        Queue<node> q=new LinkedList<>();
        q.offer(new node(start_y,start_x));

        //visit_cnt는 몇번째로 방문하는지 나타내는 변수
        int visit_cnt=0;
        //cnt는 n번째로 방문하는 노드가 몇개인지를 표시해주는 변수
        cnt=1;
        while(!q.isEmpty() && visit_cnt<t){
            int a=cnt;
            cnt=0;
            //n번째로 방문하는 것은 한번에 처리해야 함으로 큐에 넣어 반복문 처리한다.
            while (a-->0) {
                node tmp=q.poll();
                // 도착점에 도착하면 몇번째 방문하는지 return
                if(tmp.y==last_y && tmp.x==last_x){
                    return visit_cnt;
                }
                for (int i=0;i<4;i++) {
                    int y=tmp.y+dy[i];
                    int x=tmp.x+dx[i];
                    if(check(y,x) && !visited[y][x]){
                        cnt++;
                        visited[y][x]=true;
                        q.offer(new node(y,x));
                    }
                }
            }

            visit_cnt++;
        }
        return visit_cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());

        arr=new int[n][m];
        visited=new boolean[n][m];

        int gram_x=0,gram_y=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    gram_y=i;
                    gram_x=j;
                }
            }
        }

        //시작점에서 공주가 있는 지점까지 갈 수 있는지 판단
        int start_to_finish=no_Gram_bfs(0,0,n-1,m-1);
        //방문 못함 처리
        if(!visited[n-1][m-1]){
            start_to_finish=Integer.MAX_VALUE;
        }
        visited=new boolean[n][m];

        //그램이 있는 곳까지 갈 수 있는지 판단
        int start_to_gram=no_Gram_bfs(0,0,gram_y,gram_x);
        // 방문 못했거나 방문했는데 방문한 거리가 t라면 방문 못함처리
        if(!visited[gram_y][gram_x]||start_to_gram==t){
            start_to_gram=Integer.MAX_VALUE;
        } else {
            if( start_to_gram+n-1-gram_y+m-1-gram_x<=t){
                // 그램을 얻은 순간부터는 다 뚫고 갈수 있으므로 최소거리를 더해주면 된다.
                start_to_gram+=n-1-gram_y+m-1-gram_x;
            } else {
                 start_to_gram=Integer.MAX_VALUE;
            }
        }

        if(start_to_gram==Integer.MAX_VALUE && start_to_finish==Integer.MAX_VALUE){
            System.out.println("Fail");
            return;
        }
        System.out.println(Math.min(start_to_gram,start_to_finish));
    }
    public static class node{
        int x;
        int y;
        public node(int y,int x){
            this.x=x;
            this.y=y;
        }
    }
}
