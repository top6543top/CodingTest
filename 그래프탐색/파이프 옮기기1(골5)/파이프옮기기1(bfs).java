import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n,result=0;
    static int home[][];
    static int dp[][];
    static int mc[]={0,1,1}; // 세로 가로 대각선
    static int mr[]={1,0,1};
    public static void bfs(int startr,int startc,int state){
        
        //0이 가로일때, 1이 세로일때, 2가 대각선일때
        Queue<pipe> q=new LinkedList<>();
        q.offer(new pipe(startr,startc,state));
        while (!q.isEmpty()) {
            pipe nxt=q.poll();
            //도착점 도착 시 결과 값 카운트
            if(nxt.r==n && nxt.c==n){
                result++;
                continue;
            }
            // 파이프의 상태에 따라 q에 넣어준다
            if(nxt.state==0){
                if(chk(nxt.r+mr[0],nxt.c+mc[0],0)){
                    q.offer(new pipe(nxt.r+mr[0],nxt.c+mc[0],0));
                }
                if(chk(nxt.r+mr[2],nxt.c+mc[2],2)){
                    q.offer(new pipe(nxt.r+mr[2],nxt.c+mc[2],2));
                }
            } else if(nxt.state==1) {
                if(chk(nxt.r+mr[1],nxt.c+mc[1],1)){
                    q.offer(new pipe(nxt.r+mr[1],nxt.c+mc[1],1));
                }
                if(chk(nxt.r+mr[2],nxt.c+mc[2],2)){
                    q.offer(new pipe(nxt.r+mr[2],nxt.c+mc[2],2));
                }
            } else if(nxt.state==2) {
                if(chk(nxt.r+mr[0],nxt.c+mc[0],0)){
                    q.offer(new pipe(nxt.r+mr[0],nxt.c+mc[0],0));
                }
                if(chk(nxt.r+mr[1],nxt.c+mc[1],1)){
                    q.offer(new pipe(nxt.r+mr[1],nxt.c+mc[1],1));
                }
                if(chk(nxt.r+mr[2],nxt.c+mc[2],2)){
                    q.offer(new pipe(nxt.r+mr[2],nxt.c+mc[2],2));
                }
            }
        }
    }
    public static boolean chk(int r,int c,int state){
        if(r>n || c>n) return false;
        if(state==0){
            if(home[r][c]==1) return false;
        } else if(state==1){
            if(home[r][c]==1) return false;
        } else if(state==2){
            if(home[r][c]==1)   return false;
            if(home[r-1][c]==1) return false;
            if(home[r][c-1]==1) return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        home=new int[n+1][n+1];
       
        for (int i=1;i<=n;i++) {
            st=new StringTokenizer(br.readLine());
            for (int j=1;j<=n;j++) {
                home[i][j]=Integer.parseInt(st.nextToken());
            }    
        }

        if(home[n][n]==1){
            System.out.println(0);
            return;
        }
        bfs(1,2,1);

        System.out.println(result);
    } 
    static class pipe{
        int r,c,state;
        public pipe(int r,int c,int state){
            this.r=r;
            this.c=c;
            this.state=state;
        }
    }
}
