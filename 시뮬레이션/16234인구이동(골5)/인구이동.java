import java.io.*;
import java.util.*;
public class Main
{
	public static int N,L,R,flag;
	public static int arr[][];
	public static boolean union[][];
	public static boolean visited1[][];
	public static boolean visited2[][];
	public static boolean visited3[][];
	public static int dx[]={1,0,-1,0};
	public static int dy[]={0,1,0,-1};
	public static boolean check_arr(int r,int c){
	    return (r<N && c<N && r>=0 && c>=0);
	}
	//연합인지 확인하는 함수
	public static void make_union(int r,int c){
	    visited1[r][c]=true;
	    
	    Queue<int[]> q=new LinkedList<>();
	    q.offer(new int[]{r,c});
	    while(!q.isEmpty()){
	        int tmp[]=q.poll();
	        for(int i=0;i<4;i++){
    	        int tmp_y=tmp[0]+dy[i];
    	        int tmp_x=tmp[1]+dx[i];      
    	        if(check_arr(tmp_y,tmp_x) && !visited1[tmp_y][tmp_x]){
    	                int minus=Math.abs(arr[tmp[0]][tmp[1]]-arr[tmp_y][tmp_x]);
        	            if(minus>=L && minus<=R){
                            visited1[tmp_y][tmp_x]=true;
        	                union[tmp[0]][tmp[1]]=true;
        	                union[tmp_y][tmp_x]=true;
        	                flag=1; // 연합이 존재하면 탈출조건으로 사용하기 위해 flag를 1로 설정
                            q.offer(new int[]{tmp_y,tmp_x});
        	            }
    	        }
	        }
	    }
	}
	//위에서 확인한 연합을 다시 bfs를 이용하여 이동할 인원을 구해주는 함수
	public static int[] bfs(int r,int c){
	    int population=arr[r][c];
	    int many_union=1;
	    visited2[r][c]=true;
	    
	    Queue<int[]> q=new LinkedList<>();
	    q.offer(new int[]{r,c});
	    while(!q.isEmpty()){
	        int tmp[]=q.poll();
	        for(int i=0;i<4;i++){
    	        int tmp_y=tmp[0]+dy[i];
    	        int tmp_x=tmp[1]+dx[i];
    	        if(check_arr(tmp_y,tmp_x)
    	            && union[tmp_y][tmp_x] && !visited2[tmp_y][tmp_x]){
    	                visited2[tmp_y][tmp_x]=true;
    	                population+=arr[tmp_y][tmp_x];
    	                many_union++;
    	                q.offer(new int[]{tmp_y,tmp_x});
    	        }
	        }
	    }
	    return new int[]{population,many_union};
	}
	//bfs를 이용해 인원을 변경하는 함수
	public static void move_bfs(int r, int c, int people){
	    visited3[r][c]=true;
	    
	    Queue<int[]> q=new LinkedList<>();
	    q.offer(new int[]{r,c});
	    while(!q.isEmpty()){
	        int tmp[]=q.poll();
	        for(int i=0;i<4;i++){
    	        int tmp_y=tmp[0]+dy[i];
    	        int tmp_x=tmp[1]+dx[i];
    	        if(check_arr(tmp_y,tmp_x)
    	            && union[tmp_y][tmp_x] && !visited3[tmp_y][tmp_x]){
    	                visited3[tmp_y][tmp_x]=true;
                        arr[tmp[0]][tmp[1]]=people;
    	                arr[tmp_y][tmp_x]=people;
    	                q.offer(new int[]{tmp_y,tmp_x});
    	        }
	        }
	    }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
       
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken()); // L이상
        R=Integer.parseInt(st.nextToken()); // R이하
       
        arr=new int[N][N];
        
        
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
       
        int cnt=0;
        while(true){
            flag=0;
            visited1=new boolean[N][N];
            visited2=new boolean[N][N];
            visited3=new boolean[N][N];
            union=new boolean[N][N];
         
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited1[i][j]){
                        make_union(i,j);
                        if(union[i][j]==true){
                            int a[]=bfs(i,j);//[0]은 인구수 ,[1]은 연합수
                            int move=a[0]/a[1];
                            move_bfs(i,j,move);
                        }
                    }
                }
            }

            if(flag==0){break;}
            cnt++;

        }
       
        System.out.println(cnt);
	}
}
