import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static Integer[] crane;
    public static Integer[] box;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crane = new Integer[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        M=Integer.parseInt(br.readLine());
        box=new Integer[M];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(box, Collections.reverseOrder());
        if(box[0]>crane[0]){
            System.out.println(-1);
            return;
        }

        boolean visited[]=new boolean[M];
        int nxt[]=new int[N];
        int cnt=0;
        int time=0;


        while(cnt<M){
            for (int i = 0; i < N; i++) {
                while(nxt[i]<M){
                    if(!visited[nxt[i]] && crane[i]>=box[nxt[i]]){
                        visited[nxt[i]]=true;
                        nxt[i]++;
                        cnt++;
                        break;
                    } else {
                        nxt[i]++;
                    }
                }
            }
            time++;
        }

        System.out.println(time);
    }
}