import java.util.*;
import java.io.*;
public class Main
{   
    //행은 가로로 그은거 열은 세로로 그은거
    //[][][] 1번째는 y좌표 2번째는 x좌표 3번째는
    // 몇번째 순서인지와 그 순서의 숫자
    public static int loc[][][];
    public static int copy_loc[][][];
    public static int dx[]={0,1,0,-1};
    public static int dy[]={1,0,-1,0};
    //좋아하는 친구를 저장하는 리스트
    public static ArrayList<Integer>[] fav;
    public static int num[];
    public static int n;
    /*
    비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
    1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
    2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
    */
    public static void add(int cnt){
        int max_friend=-1; // 주위의 친구가 몇개인지를 넣는 변수
        int max_blank=-1; // 주위의 빈칸이 몇개인지를 넣는 변수
        int tmp_x=0,tmp_y=0;
        //1번째 조건
        for(int j=1;j<n+1;j++){
            for(int i=1;i<n+1;i++){
                if(loc[i][j][0]==0){ // 0이면 그 칸을 체크
                    int tmp[]=check(cnt,i,j);
                    if(max_friend<tmp[1]){ // 만약 주위의 좋아하는 친구가 많다면
                    // max친구와 좌표를 갱신
                        max_friend=Math.max(max_friend,tmp[1]);
                        tmp_x=j;
                        tmp_y=i;
                    }
                }
            }
        }
        //2,3번째 조건
         for(int j=1;j<n+1;j++){
            for(int i=1;i<n+1;i++){
                if(loc[i][j][0]==0){
                    //친구가 같은데 빈칸이 많다면 좌표 새로 갱신
                    //같은 부호를 안함으로 행이 우선되게 선정
                    if(max_friend==tmp[1] && max_blank<tmp[0]){
                        max_blank=Math.max(max_blank,tmp[0]);
                        tmp_x=j;
                        tmp_y=i;
                    }
                }
            }
        }
        
        loc[tmp_y][tmp_x][0]=num[cnt];
        loc[tmp_y][tmp_x][1]=cnt;
    }
    public static int[] check(int cnt,int y,int x){
        int tmp[]=new int[2];
        //0은 빈칸의 개수 1은 친한 친구의 개수
        for(int i=0;i<4;i++){
            if(array_check(x+dx[i],y+dy[i])){
                if(loc[y+dy[i]][x+dx[i]][0]==0){
                    tmp[0]++;    
                }
                for(int j=0;j<fav[cnt].size();j++){
                    if(loc[y+dy[i]][x+dx[i]][0] == fav[cnt].get(j)){
                        tmp[1]++;    
                    }
                }
            }
        }
        return tmp;
    }
    public static int calculate(int y,int x,int cnt){
        int score=0;
        for(int i=0;i<4;i++){
            if(array_check(x+dx[i],y+dy[i])){
                for(int j=0;j<fav[cnt].size();j++){
                    if(loc[y+dy[i]][x+dx[i]][0]==fav[cnt].get(j)){
                         score++;       
                    }
                }
            }
        }
        if(score==0) return 0;
        if(score==1) return 1;
        if(score==2) return 10;
        if(score==3) return 100;
        return 1000;
    }
    public static boolean array_check(int x,int y){
        return ((x>=1 && x<=n) && (y>=1 && y<=n));
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n=Integer.parseInt(br.readLine());
        loc=new int[n+1][n+1][2];
        copy_loc=new int[n+1][n+1][2];
        num=new int[n*n+1];
        fav=new ArrayList[n*n+1];
        for(int i=0;i<n*n+1;i++){
            fav[i]=new ArrayList<>();
        }
        
        for(int i=1;i<=n*n;i++){
            st=new StringTokenizer(br.readLine());
            num[i]=Integer.parseInt(st.nextToken());
            for(int j=0;j<4;j++){
                fav[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=1;i<=n*n;i++){
            add(i);
        }

        int result=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                result+=calculate(i,j,loc[i][j][1]);
            }
        }
        
        System.out.println(result);
	}
}
