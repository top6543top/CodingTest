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
    public static boolean found;
    public static boolean visited[];

    public static void dfs(ArrayList<Integer>[] arr, int a,int depth){
        if(found) return;
        if(depth == 4) {found = true; return;}
        visited[a]=true;

        for (int i = 0; i < arr[a].size(); i++) {
            if(!visited[arr[a].get(i)]){
                dfs(arr,arr[a].get(i),depth+1);
            }
        }
        visited[a]=false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr=new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i]=new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        visited=new boolean[N];
        for (int i = 0; i < N && !found; i++) {
            dfs(arr,i, 0);
        }

        if(found) System.out.println(1);
        else System.out.println(0);
    }
}