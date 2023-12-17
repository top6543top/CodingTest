import java.io.*;
import java.util.*;
public class Main
{
	public static int N,L,R,flag;
	public static int arr[][];
	public static boolean visited1[][];
	public static int dx[]={1,0,-1,0};
	public static int dy[]={0,1,0,-1};
	public static ArrayList<int[]> xy;
	public static boolean check_arr(int r,int c){
	    return (r<N && c<N && r>=0 && c>=0);
	}
	public static void make_union(int r,int c){
	    visited1[r][c]=true;
	    xy.add(new int[]{r,c});
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
        	                xy.add(new int[]{tmp_y,tmp_x});
                            q.offer(new int[]{tmp_y,tmp_x});
                            flag=1;
        	            }
    	        }
	        }
	    }
	}
	public static void bfs(){
	    int population=0;
	    int many_union=0;
	    
	    for(int[] tmp:xy){
	        population+=arr[tmp[0]][tmp[1]];
	        many_union++;
	    }

	    int p=population/many_union;
	     for(int[] tmp:xy){
	        arr[tmp[0]][tmp[1]]=p;
	    }
	    return;
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
            xy=new ArrayList<>();
            visited1=new boolean[N][N];
         
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited1[i][j]){
                        make_union(i,j);
                        if(xy.size()>1){bfs();}
                        xy=new ArrayList<>();
                    }
                }
            }
            if(flag==0){break;}
            cnt++;

        }
       
        System.out.println(cnt);
	}
}
