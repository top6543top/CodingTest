import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int result;
    public static int arr[];

    public static void binarySearch(int start,int last){
        if (start==last) return;
        int mid = (start+last)/2;

        int front=0;
        for (int i = start; i <= mid; i++) {
            front+=arr[i];
        }

        int back=0;
        for (int i = mid+1; i <= last; i++) {
            back+=arr[i];
        }

        result+= (front*back);
        binarySearch(start,mid);
        binarySearch(mid+1,last);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        arr=new int[n+1];

        st=new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        binarySearch(1,n);
        System.out.println(result);

    }
}