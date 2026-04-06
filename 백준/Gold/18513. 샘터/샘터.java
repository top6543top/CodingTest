import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int k;
    public static int DEFAULT_VALUE=100_500_000;
    public static int move[]={1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        Deque<int[]> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        for(int i=0;i<n;i++){
            int water = Integer.parseInt(st.nextToken());
            q.offer(new int[]{water,0});
            visited.add(water);
        }

        Long result=0L;
        while(k>0 && !q.isEmpty()){
            int[] a=q.pollFirst();
            for(int i=0;i<2;i++){
                int nxt=a[0]+move[i];
                if(!visited.contains(nxt)){
                    q.offerLast(new int[]{nxt,a[1]+1});
                    result+=a[1]+1;
                    visited.add(nxt);
                    k--;
                    if(k==0) break;
                }
            }
        }

        System.out.println(result);

    }
}