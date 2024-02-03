import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int[][] cost;
    public static boolean[][] visited;
    public static int dx[]={0,-1,0,1,0};
    public static int dy[]={0,0,1,0,-1};
    public static int n,result=Integer.MAX_VALUE;
    public static boolean chk_arr(int y,int x){
        return y>=0 && y<n && x>=0 && x<n;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        cost=new int[n][n];
        visited=new boolean[n][n];
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                cost[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n*n-2;i++){
            for(int j=i+1;j<n*n-1;j++){
                for(int k=j+1;k<n*n;k++){
                    int tmp=0,flag=0;
                    visited=new boolean[n][n];
                    for (int z=0;z<5;z++) {
                        if(chk_arr(i/n+dy[z],i%n+dx[z])){
                            visited[i/n+dy[z]][i%n+dx[z]]=true;
                            tmp+=cost[i/n+dy[z]][i%n+dx[z]];
                        } else {
                            flag=1;
                            break;
                        }
                        if(chk_arr(j/n+dy[z],j%n+dx[z])){
                            visited[j/n+dy[z]][j%n+dx[z]]=true;
                            tmp+=cost[j/n+dy[z]][j%n+dx[z]];
                        } else {
                            flag=1;
                            break;
                        }
                        if(chk_arr(k/n+dy[z],k%n+dx[z])){
                            visited[k/n+dy[z]][k%n+dx[z]]=true;
                            tmp+=cost[k/n+dy[z]][k%n+dx[z]];
                        } else {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1){
                        continue;
                    }

                    int cnt=0;
                    for (int z=0;z<n;z++) {
                        for(int zz=0;zz<n;zz++){
                            if(visited[z][zz]) cnt++;
                        }
                    }
                    
                    if(cnt==15){
                        result=Math.min(result,tmp);
                    }
                }
            }            
        }

        System.out.println(result);
    }
}
