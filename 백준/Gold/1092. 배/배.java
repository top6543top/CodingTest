import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int[] crane;
    public static int[] box;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crane = new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        M=Integer.parseInt(br.readLine());
        box=new int[M];
        boolean visited[]=new boolean[M];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane);
        Arrays.sort(box);
        if(box[M-1]>crane[N-1]){
            System.out.println(-1);
            return;
        }

        int time=0;
        int cnt=0; // 박스는 총 M개가 나와야함
        int i=M-1;
        while(i>=0){
            if (cnt==M) break;
            for (int j = N-1; j >=0; j--) {
                if (cnt==M) break;
                if (!visited[i] && box[i]<=crane[j]){
                    cnt++;
                    visited[i]=true;
                    i--;
                } else {
                    int tmp=i;
                    for (int k = tmp-1; k >= 0; k--) {
                        if(!visited[k] && box[k]<=crane[j]){
                            cnt++;
                            visited[k]=true;
                            break;
                        }
                    }
                }
            }
            time++;
        }

        System.out.println(time);
    }
}