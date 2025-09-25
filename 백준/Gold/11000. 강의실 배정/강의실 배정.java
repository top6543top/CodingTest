import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int[][] arr=new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0]=a;
            arr[i][1]=b;
        }

        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        /*for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }*/

        pq.add(arr[0][1]);
        for (int i = 1; i < n; i++) {
            //System.out.println(pq.peek());
            if(pq.peek()>arr[i][0]){
                pq.add(arr[i][1]);
            } else {
                pq.poll();
                pq.add(arr[i][1]);
            }
        }

        System.out.println(pq.size());
    }
}