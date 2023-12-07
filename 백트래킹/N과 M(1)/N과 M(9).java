import java.io.*;
import java.util.*;
public class Main
{
    public static int num[];
    public static int use[][];
    public static int result[];
    public static boolean visited[];
    public static int n,m;
    public static StringBuilder sb;
    public static void backTracking(int start){
        if(start==m){
            for(int i=0;i<m;i++){
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }
        int before=0; 
        // 다음 수를 검사할때는 필요 없으므로 0으로 초기화
        // 이 반복문은 한자리를 결정할때 돌리는 반복문이다.
        for(int i=0;i<num.length;i++){
            //전에 사용했던 것과 지금 들어가려는 숫자가 같으면 같은 결과가 나오므로
            //조건을 다음과 같이 설정 정렬되있으므로 전 것만 검사하면 된다.
            if(!visited[i] && before!=num[i]){
                visited[i]=true;
                result[start]=num[i];
                before=num[i];
                backTracking(start+1);
                visited[i]=false;
            }
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        sb=new StringBuilder();
        visited=new boolean[n];
        num=new int[n];
        use=new int[n][m];
        result=new int[m];
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        backTracking(0);
        
        System.out.print(sb);
	}
}
