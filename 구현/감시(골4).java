import java.util.*;
import java.io.*;
public class Main
{
    public static int office[][]; // 처음 상태를 저장하는 배열
    public static int c_office[][]; // 감시 사각지역을 구할때 사용하는 배열
    public static int dx[]={0,1,0,-1}; // 북 동 서 남 순으로 움직임을 나타내는 배열
    public static int dy[]={1,0,-1,0};
    public static ArrayList<int[]> xy;
    public static int size,n,m,result;
    //보이는 구역을 구하는 함수 [y][x]
	public static void move(int x,int y,int dir){
	    dir%=4;
	    while(true){
	           x+=dx[dir];// 골라준 방향을 더해줘서 움직인다
	           y+=dy[dir];
               if(!check_area(x,y) || c_office[y][x]==6) break; 
               // 장애물로 막혔거나 범위가 끝나면 종료
	           if(c_office[y][x]<=5 && c_office[y][x]>=1) continue;
	           //cctv를 만났을때는 넘어간다
	           c_office[y][x]=7; // 감시가 가능한 구역은 7로 변경
	    }
	}
	public static boolean check_area(int x,int y){
	   return (x<m && x>=0 && y<n && y>=0);
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken()); //세로
        m=Integer.parseInt(st.nextToken()); //가로
        office=new int[n][m];
        c_office=new int[n][m];
        xy=new ArrayList<>();
       
        int cnt=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int tmp=Integer.parseInt(st.nextToken());
                office[i][j]=tmp;
                if(office[i][j]!=0 && office[i][j]!=6){
                    //cctv의 좌표와 종류 저장
                    xy.add(new int[]{i,j,tmp});
                    cnt++;
                }
                if(office[i][j]==0){
                    size++;
                }
            }
        }
       
        int four=1; // 사진법을 개수를 구한다.
        for(int i=0;i<cnt;i++){
            four*=4;
        }
       
        int num,max=0;
        for(int i=0;i<four;i++){
            //방향 64가지를 모두 구한다.
            num=i; max=0;
            for(int l=0;l<n;l++){
                //반복문 돌릴때마다 새로운 c_office만들어 줘야함
                //각자 구하고 각자 센다.
                for(int k=0;k<m;k++){
                    c_office[l][k]=office[l][k];
                }
            }
            for(int j=0;j<xy.size();j++){
                int dir=num%4;
                num/=4;
                int x=xy.get(j)[1];
                int y=xy.get(j)[0];
                if(c_office[y][x]==1){
                    move(x,y,dir);
                } else if(c_office[y][x]==2){
                    move(x,y,dir);
                    move(x,y,dir+2);
                } else if(c_office[y][x]==3){
                    move(x,y,dir);
                    move(x,y,dir+1);
                } else if(c_office[y][x]==4){
                    move(x,y,dir);
                    move(x,y,dir+1);
                    move(x,y,dir+3);
                } else if(c_office[y][x]==5){
                    move(x,y,dir);
                    move(x,y,dir+1);
                    move(x,y,dir+2);
                    move(x,y,dir+3);
                }
            }
            for(int z=0;z<n;z++){
                for(int aa=0;aa<m;aa++){
                    if(c_office[z][aa]==7) max++;
                }
            }

            result=Math.max(result,max);
        }
   
	    System.out.print(size-result);
	}
}
