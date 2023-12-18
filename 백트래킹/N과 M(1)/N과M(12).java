import java.io.*;
import java.util.*;
public class Main
{
    public static int n,m,prev1;
    public static int arr[];
    public static int result[];
    public static boolean visited[];
    public static StringBuilder sb;
    public static void backTracking(int start){
        if(start==m){
            prev1=0;
            for(int i=0;i<m;i++){
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }
        int prev2=0;
        for(int i=0;i<n;i++){
            //prev1은 오름차순으로 정렬하기 위한 변수이고 prev2는 같은 수열이 안나오기 위한 변수이다.
            if(prev1<=arr[i] && prev2!=arr[i]){
                result[start]=arr[i];
                prev2=arr[i];
                prev1=result[start];
                backTracking(start+1);
            }
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n];
        result=new int[m];
        sb=new StringBuilder();
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        backTracking(0);
        System.out.print(sb);
	}
}
