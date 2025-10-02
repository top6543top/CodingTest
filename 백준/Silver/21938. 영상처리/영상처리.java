import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int result;
    static int[] move_y = {0,1,0,-1};
    static int[] move_x = {1,0,-1,0};

    public static boolean chk_arr(int y,int x){
        if (y>=0 && y<n && x>=0 && x<m) return true;
        return false;
    }

    public static void dfs(int start_y,int start_x,int pixel[][], boolean visited[][]){
        visited[start_y][start_x] = true;
        for (int i = 0; i < 4; i++) {
            int next_y=start_y+move_y[i];
            int next_x=start_x+move_x[i];
            if (chk_arr(next_y,next_x) && !visited[next_y][next_x] && pixel[next_y][next_x]==255){
                dfs(next_y,next_x,pixel,visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int rgb[][]=new int[n][3*m];
        int pixel[][]=new int[n][m];
        boolean visited[][]=new boolean[n][m];


        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < 3*m; j++) {
                rgb[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int t=Integer.parseInt(br.readLine());

        int value=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3*m; j++) {
                value += rgb[i][j];
                if(j%3==2){
                    value=value/3;
                    if (value >= t) pixel[i][j/3] = 255;
                    else pixel[i][j/3]=0;
                    value=0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && pixel[i][j] != 0){
                    result++;
                    dfs(i,j,pixel,visited);
                }
            }
        }

        System.out.println(result);
    }
}

/*two Americans , */